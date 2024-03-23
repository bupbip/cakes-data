package ru.kustikov.cakes.filling;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import ru.kustikov.cakes.user.UserMapper;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface FillingMapper {
    @Mapping(source = "entity.user.userId", target = "userId")
    FillingRecord entityToDto(FillingEntity entity);

    FillingEntity dtoToEntity(FillingRecord dto);
}
