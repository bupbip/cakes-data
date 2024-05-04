package ru.kustikov.cakes.consumableproduct;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ConsumableProductMapper {
    ConsumableProductEntity dtoToEntity(ConsumableProductRecord record);

    ConsumableProductRecord entityToDto(ConsumableProductEntity entity);
}
