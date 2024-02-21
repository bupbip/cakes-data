package ru.kustikov.cakes.user;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UserMapper {
    UserRecord entityToDto(UserEntity entity);

    @Mapping(source = "dto.image", target = "image")
    UserEntity dtoToEntity(UserRecord dto);
}
