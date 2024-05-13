package ru.kustikov.cakes.productorder;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductOrderRepository extends CrudRepository<ProductOrderEntity, Long> {
}
