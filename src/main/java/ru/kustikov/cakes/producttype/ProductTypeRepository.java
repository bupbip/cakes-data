package ru.kustikov.cakes.producttype;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypeRepository extends CrudRepository<ProductTypeEntity, Long> {
}
