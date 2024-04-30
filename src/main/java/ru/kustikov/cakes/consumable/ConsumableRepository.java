package ru.kustikov.cakes.consumable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsumableRepository extends CrudRepository<ConsumableEntity, Long> {
    List<ConsumableEntity> findAllByUser_Username(String username);
}
