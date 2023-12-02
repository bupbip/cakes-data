package ru.kustikov.cakes.consumable;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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

    public ConsumableRecord update(ConsumableRecord consumableRecord) {
        ConsumableEntity consumableEntity = consumableMapper.dtoToEntity(consumableRecord);
        ConsumableEntity savedConsumableEntity = consumableRepository.save(consumableEntity);
        return consumableMapper.entityToDto(savedConsumableEntity);
    }

    public void delete(Long id) {
        consumableRepository.deleteById(id);
    }
}
