package ru.kustikov.cakes.address;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface AddressMapper {
    @Mapping(source = "settlement.name", target = "settlementName")
    AddressRecord entityToDto(AddressEntity entity);

    AddressEntity dtoToEntity(AddressRecord dto);
}
