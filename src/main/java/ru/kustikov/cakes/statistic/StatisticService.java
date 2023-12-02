package ru.kustikov.cakes.statistic;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class StatisticService {
    private final StatisticRepository statisticRepository;
    private final StatisticMapper statisticMapper;

    public StatisticRecord create(StatisticRecord statisticRecord) {
        StatisticEntity statisticEntity = statisticMapper.dtoToEntity(statisticRecord);
        StatisticEntity savedStatisticEntity = statisticRepository.save(statisticEntity);
        return statisticMapper.entityToDto(savedStatisticEntity);
    }

    public StatisticRecord get(Long id) {
        StatisticEntity statisticEntity = statisticRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Statistic not found"));
        return statisticMapper.entityToDto(statisticEntity);
    }

    public StatisticRecord update(StatisticRecord statisticRecord) {
        StatisticEntity statisticEntity = statisticMapper.dtoToEntity(statisticRecord);
        StatisticEntity savedStatisticEntity = statisticRepository.save(statisticEntity);
        return statisticMapper.entityToDto(savedStatisticEntity);
    }

    public void delete(Long id) {
        statisticRepository.deleteById(id);
    }
}
