package ru.kustikov.cakes.product;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ProductMapper {
    @Mapping(target = "name", source = "entity.name")
    @Mapping(target = "type", source = "entity.productType")
    @Mapping(target = "image", source = "entity.image")
    ProductRecord entityToDto(ProductEntity entity);

    ProductEntity dtoToEntity(ProductRecord dto);
}
