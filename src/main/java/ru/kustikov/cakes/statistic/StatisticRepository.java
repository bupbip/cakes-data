package ru.kustikov.cakes.statistic;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kustikov.cakes.user.UserEntity;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface StatisticRepository extends CrudRepository<StatisticEntity, Long> {
    List<StatisticEntity> findAllByYearAndUser(Integer year, UserEntity user);
}
