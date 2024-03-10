package ru.kustikov.cakes.productorder;

import jakarta.persistence.Column;
import lombok.Data;
import ru.kustikov.cakes.product.ProductRecord;

@Data
public class ProductOrderRecord {
    private Long orderItemId;

    private Long orderId;

    private ProductRecord product;

    private Integer quantity;

    private String reference;
}
