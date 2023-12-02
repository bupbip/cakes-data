package ru.kustikov.cakes.order;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface OrderMapper {
    OrderRecord entityToDto(OrderEntity entity);

    OrderEntity dtoToEntity(OrderRecord dto);
}
