package ru.kustikov.cakes.consumable;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ConsumableMapper {
    ConsumableRecord entityToDto(ConsumableEntity entity);

    ConsumableEntity dtoToEntity(ConsumableRecord dto);
}
