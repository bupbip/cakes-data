package ru.kustikov.cakes.order;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kustikov.cakes.user.UserEntity;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<OrderEntity, Long> {
    List<OrderEntity> getAllByBakerOrderByCreatedDate(UserEntity baker);

    List<OrderEntity> getAllByClientOrderByCreatedDate(UserEntity client);


}
