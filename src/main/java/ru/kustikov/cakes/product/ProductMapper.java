package ru.kustikov.cakes.product;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ProductMapper {
    ProductRecord entityToDto(ProductEntity entity);

    ProductEntity dtoToEntity(ProductRecord dto);
}
