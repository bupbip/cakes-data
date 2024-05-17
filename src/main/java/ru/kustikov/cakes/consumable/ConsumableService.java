package ru.kustikov.cakes.consumable;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.kustikov.cakes.subscriptions.SendMailService;
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
    private final SendMailService mailService;

    public ConsumableRecord get(Long id) {
        ConsumableEntity consumableEntity = consumableRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consumable not found"));
        return consumableMapper.entityToDto(consumableEntity);
    }

    public ConsumableRecord update(ConsumableRecord record) {
        ConsumableEntity entity = consumableMapper.dtoToEntity(record);
        entity.setUser(userRepository.findById(Long.valueOf(record.getUserId())).orElseThrow());

        ConsumableEntity savedEntity = consumableRepository.save(entity);
        if (savedEntity.getThreshold() > savedEntity.getQuantity() && savedEntity.getUser().getSubscriptions().isConsumable()) {
            mailService.send(savedEntity.getUser().getEmail(),
                    "У вас заканчивается " + savedEntity.getName() +
                            ".\nОсталось " + savedEntity.getQuantity() + " " + savedEntity.getQuantityType());
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
