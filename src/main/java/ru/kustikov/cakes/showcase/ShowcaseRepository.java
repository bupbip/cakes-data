package ru.kustikov.cakes.showcase;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowcaseRepository extends CrudRepository<ShowcaseEntity, Long> {
}
