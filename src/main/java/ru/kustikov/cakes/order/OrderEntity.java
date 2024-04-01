package ru.kustikov.cakes.order;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.kustikov.cakes.productorder.ProductOrderEntity;
import ru.kustikov.cakes.user.UserEntity;

import java.sql.Timestamp;
import java.util.List;

@Entity(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Column(name = "prefer_price")
    private Integer preferPrice;

    @Column(name = "spent_price")
    private Integer spentPrice;

    @Column(name = "result_price")
    private Integer resultPrice;

    private String address;

    @ManyToOne
    private UserEntity customer;

    @ManyToOne
    private UserEntity confectioner;

    @Column(name = "created_date")
    private Timestamp createdDate;

    @Column(name = "complete_date")
    private Timestamp completeDate;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<ProductOrderEntity> productOrders;
}
