package ru.kustikov.cakes.statistic;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatisticRepository extends CrudRepository<StatisticEntity, Long> {
}
