package ru.kustikov.cakes.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);

    Optional<UserEntity> findByUsername(String username);

    List<UserEntity> findAllByRoleOrderByLastActivity(Role role);

    Page<UserEntity> findAllByRoleOrderByLastActivity(Pageable pageable, Role role);
}
