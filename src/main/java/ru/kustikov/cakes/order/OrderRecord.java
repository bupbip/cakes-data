package ru.kustikov.cakes.order;

import lombok.Data;
import ru.kustikov.cakes.productorder.ProductOrderEntity;
import ru.kustikov.cakes.user.UserEntity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Data
public class OrderRecord {
    private Long orderId;

    private String status;

    private BigDecimal preferPrice;

    private BigDecimal resultPrice;

    private UserEntity client;

    private UserEntity baker;

    private Timestamp createdDate;

    private Timestamp completeDate;

    private List<ProductOrderEntity> products;
}
