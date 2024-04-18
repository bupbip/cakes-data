package ru.kustikov.cakes.statistic;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.kustikov.cakes.order.OrderEntity;
import ru.kustikov.cakes.order.OrderRepository;
import ru.kustikov.cakes.user.UserEntity;
import ru.kustikov.cakes.user.UserRecord;
import ru.kustikov.cakes.user.UserRepository;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class StatisticService {
    private final StatisticRepository statisticRepository;
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
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

    public List<StatisticRecord> getAllByYear(Integer year, Long userId) {
        UserEntity user = userRepository.findById(userId).orElseThrow();
        List<StatisticEntity> entities = statisticRepository.findAllByYearAndUser(
                year, user);

        return entities.stream()
                .map(statisticMapper::entityToDto)
                .collect(Collectors.toList());
    }

    public void calculate(UserEntity user) {
        List<OrderEntity> orders = orderRepository.getAllByConfectionerOrderByCreatedDate(user);

        for (OrderEntity order : orders) {
            LocalDate date = order.getCompleteDate().toLocalDate();
            // todo вот тут доделать
        }
    }

    public void delete(Long id) {
        statisticRepository.deleteById(id);
    }
}
