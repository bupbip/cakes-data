package ru.kustikov.cakes.rolerequest;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRequestRepository extends CrudRepository<RoleRequestEntity, Long> {
}
