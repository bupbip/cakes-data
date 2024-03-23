package ru.kustikov.cakes.filling;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FillingRepository extends CrudRepository<FillingEntity, Long> {
}
