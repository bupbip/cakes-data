package ru.kustikov.cakes.feedback;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface FeedbackMapper {
    @Mapping(source = "feedback.userTo.userId", target = "userTo")
    FeedbackRecord entityToDto(FeedbackEntity feedback);

    @Mapping(target = "userTo", ignore = true)
    FeedbackEntity dtoToEntity(FeedbackRecord feedback);
}
