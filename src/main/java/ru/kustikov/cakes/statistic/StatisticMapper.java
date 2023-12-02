package ru.kustikov.cakes.statistic;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface StatisticMapper {
    StatisticRecord entityToDto(StatisticEntity entity);

    StatisticEntity dtoToEntity(StatisticRecord dto);
}
