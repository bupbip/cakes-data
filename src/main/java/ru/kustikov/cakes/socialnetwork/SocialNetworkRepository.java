package ru.kustikov.cakes.socialnetwork;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialNetworkRepository extends CrudRepository<SocialNetworkEntity, Long> {
}
