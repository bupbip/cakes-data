package ru.kustikov.cakes.consumable;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Slf4j
@RequiredArgsConstructor
public class ConsumableService {
    private final ConsumableRepository consumableRepository;
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

    public List<ConsumableRecord> update(List<ConsumableRecord> records) {
        Iterable<ConsumableEntity> savedConsumableEntity = consumableRepository
                .saveAll(records
                        .stream()
                        .map(consumableMapper::dtoToEntity)
                        .collect(Collectors.toList()
                        ));
        return StreamSupport.stream(savedConsumableEntity.spliterator(), false)
                .map(consumableMapper::entityToDto)
                .collect(Collectors.toList());
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
