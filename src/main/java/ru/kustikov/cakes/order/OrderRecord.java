package ru.kustikov.cakes.order;

import lombok.Data;
import ru.kustikov.cakes.productorder.ProductOrderRecord;
import ru.kustikov.cakes.user.UserEntity;

import java.time.LocalDateTime;
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

    private LocalDateTime createdDate;

    private LocalDateTime completeDate;

    private List<ProductOrderRecord> products;
}
