package ru.kustikov.cakes.product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kustikov.cakes.user.UserEntity;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Long> {
    List<ProductEntity> findAllByAuthorNotNull();

    List<ProductEntity> findAllByAuthor(UserEntity user);
}
