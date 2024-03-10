package ru.kustikov.cakes.productorder;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.mapstruct.Mapping;
import ru.kustikov.cakes.order.OrderEntity;
import ru.kustikov.cakes.product.ProductEntity;

@Entity(name = "product_orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductOrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_order_id")
    private Long productOrderId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    @OneToOne
    @JoinColumn(name = "product_id")
    @Cascade(CascadeType.ALL)
    private ProductEntity product;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "reference", columnDefinition="TEXT")
    private String reference;
}
