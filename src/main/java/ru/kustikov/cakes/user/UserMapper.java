package ru.kustikov.cakes.user;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UserMapper {
    UserRecord entityToDto(UserEntity entity);

    UserEntity dtoToEntity(UserRecord dto);
}
