package ru.kustikov.cakes.rolerequest;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface RoleRequestMapper {
    RoleRequestEntity dtoToEntity(RoleRequestRecord record);

    RoleRequestRecord entityToDto(RoleRequestEntity entity);
}
