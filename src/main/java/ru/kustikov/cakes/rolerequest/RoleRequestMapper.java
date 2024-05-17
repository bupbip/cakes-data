package ru.kustikov.cakes.rolerequest;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import ru.kustikov.cakes.feedback.FeedbackMapper;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, uses = FeedbackMapper.class)
public interface RoleRequestMapper {
    RoleRequestEntity dtoToEntity(RoleRequestRecord record);

    RoleRequestRecord entityToDto(RoleRequestEntity entity);
}
