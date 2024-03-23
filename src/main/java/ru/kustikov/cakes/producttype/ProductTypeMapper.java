package ru.kustikov.cakes.producttype;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ProductTypeMapper {
    ProductTypeRecord entityToDto(ProductTypeEntity entity);

    ProductTypeEntity dtoToEntity(ProductTypeRecord dto);
}
