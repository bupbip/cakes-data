package ru.kustikov.cakes.productorder;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "result_image", columnDefinition = "TEXT")
    private String resultImage;
}
