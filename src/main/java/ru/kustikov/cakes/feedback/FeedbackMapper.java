package ru.kustikov.cakes.feedback;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface FeedbackMapper {
    @Mapping(target = "userFrom.name", source = "userFrom")
    FeedbackRecord entityToDto(FeedbackEntity feedback);

    FeedbackEntity dtoToEntity(FeedbackRecord feedback);
}
