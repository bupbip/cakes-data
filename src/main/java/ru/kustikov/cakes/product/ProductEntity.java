package ru.kustikov.cakes.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.kustikov.cakes.productorder.ProductOrderEntity;
import ru.kustikov.cakes.user.UserEntity;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "name")
    private String name;

    @Column(name = "product_type")
    @Enumerated(EnumType.STRING)
    private ProductType productType;

    @Column(name = "price", columnDefinition = "numeric(19,2)")
    private BigDecimal price;

    @Column(name = "count")
    private Integer count;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "topping")
    private String topping;

    @Column(name = "comment")
    private String comment;

    @Column(name = "image")
    private String image;

    @OneToMany(mappedBy = "product")
    private List<ProductOrderEntity> productOrders;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity author;
}
