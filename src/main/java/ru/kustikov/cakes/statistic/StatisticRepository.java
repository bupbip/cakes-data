package ru.kustikov.cakes.statistic;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kustikov.cakes.user.UserEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface StatisticRepository extends CrudRepository<StatisticEntity, Long> {
    List<StatisticEntity> findAllByYearAndUser(Integer year, UserEntity user);

    List<StatisticEntity> findAllByYearAndMonthAndUser_Subscriptions_Monthly(Integer year, Integer month, boolean subscribe);

    Optional<StatisticEntity> findByYearAndMonthAndUser(Integer year, Integer month, UserEntity user);
}
