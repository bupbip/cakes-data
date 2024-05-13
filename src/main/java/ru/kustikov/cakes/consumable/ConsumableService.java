package ru.kustikov.cakes.consumable;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.kustikov.cakes.mail.MailData;
import ru.kustikov.cakes.user.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ConsumableService {
    private final ConsumableRepository consumableRepository;
    private final UserRepository userRepository;
    private final ConsumableMapper consumableMapper;

    public ConsumableRecord create(ConsumableRecord consumableRecord) {
        ConsumableEntity consumableEntity = consumableMapper.dtoToEntity(consumableRecord);
        ConsumableEntity savedConsumableEntity = consumableRepository.save(consumableEntity);
        return consumableMapper.entityToDto(savedConsumableEntity);
    }

    public ConsumableRecord get(Long id) {
        ConsumableEntity consumableEntity = consumableRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consumable not found"));
        return consumableMapper.entityToDto(consumableEntity);
    }

    public ConsumableRecord update(ConsumableRecord record) {
        ConsumableEntity entity = consumableMapper.dtoToEntity(record);
        entity.setUser(userRepository.findById(Long.valueOf(record.getUserId())).orElseThrow());

        ConsumableEntity savedEntity = consumableRepository.save(entity);
        if (savedEntity.getThreshold() > savedEntity.getQuantity()) {
            RestTemplate restTemplate = new RestTemplate();
            String url = "http://localhost:4302/api/v1/mail/send-msg";
            restTemplate.postForObject(url, new MailData(savedEntity.getUser().getEmail(), "У вас заканчивается " + savedEntity.getName() +
                    ".\nОсталось " + savedEntity.getQuantity() + " " + savedEntity.getQuantityType()), String.class);
        }

        return consumableMapper.entityToDto(savedEntity);
    }

    public void delete(Long id) {
        consumableRepository.deleteById(id);
    }

    public List<ConsumableRecord> getAllByUser(String username) {
        List<ConsumableEntity> entities = consumableRepository.findAllByUser_Username(username);

        return entities
                .stream()
                .map(consumableMapper::entityToDto)
                .collect(Collectors.toList());
    }
}
