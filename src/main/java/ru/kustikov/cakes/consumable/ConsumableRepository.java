package ru.kustikov.cakes.consumable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumableRepository extends CrudRepository<ConsumableEntity, Long> {
}
