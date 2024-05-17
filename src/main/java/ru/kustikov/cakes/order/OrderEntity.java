package ru.kustikov.cakes.order;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.kustikov.cakes.productorder.ProductOrderEntity;
import ru.kustikov.cakes.user.UserEntity;

import java.time.LocalDateTime;
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

    private String comment;

    @ManyToOne
    private UserEntity customer;

    @ManyToOne
    private UserEntity confectioner;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "complete_date")
    private LocalDateTime completeDate;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<ProductOrderEntity> productOrders;
}
