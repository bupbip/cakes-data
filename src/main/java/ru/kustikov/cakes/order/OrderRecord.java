package ru.kustikov.cakes.order;

import lombok.Data;
import ru.kustikov.cakes.productorder.ProductOrderEntity;
import ru.kustikov.cakes.productorder.ProductOrderRecord;
import ru.kustikov.cakes.user.UserEntity;

import java.sql.Timestamp;
import java.util.List;

@Data
public class OrderRecord {
    private Long orderId;

    private String status;

    private Integer preferPrice;

    private Integer spentPrice;

    private Integer resultPrice;

    private UserEntity customer;

    private UserEntity confectioner;

    private Timestamp createdDate;

    private Timestamp completeDate;

    private List<ProductOrderRecord> products;
}
