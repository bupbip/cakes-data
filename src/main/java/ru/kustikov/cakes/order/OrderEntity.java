package ru.kustikov.cakes.order;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.kustikov.cakes.productorder.ProductOrderEntity;
import ru.kustikov.cakes.user.UserEntity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Entity
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

    @Column(name = "prefer_price", columnDefinition = "numeric(19,2)")
    private BigDecimal preferPrice;

    @Column(name = "spent_price", columnDefinition = "numeric(19,2)")
    private BigDecimal spentPrice;

    @Column(name = "result_price", columnDefinition = "numeric(19,2)")
    private BigDecimal resultPrice;

    @OneToOne
    private UserEntity client;

    @OneToOne
    private UserEntity baker;

    @Column(name = "created_date")
    private Timestamp createdDate;

    @Column(name = "complete_date")
    private Timestamp completeDate;

    @OneToMany
    private List<ProductOrderEntity> products;
}
