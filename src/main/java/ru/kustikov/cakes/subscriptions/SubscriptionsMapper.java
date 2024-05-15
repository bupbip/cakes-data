package ru.kustikov.cakes.subscriptions;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import ru.kustikov.cakes.filling.FillingMapper;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, uses = FillingMapper.class)
public interface SubscriptionsMapper {
    @Mapping(source = "user.userId", target = "userId")
    SubscriptionsRecord entityToDto(SubscriptionsEntity entity);

    SubscriptionsEntity dtoToEntity(SubscriptionsRecord dto);
}
