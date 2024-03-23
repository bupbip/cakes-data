package ru.kustikov.cakes.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.kustikov.cakes.productorder.ProductOrderEntity;
import ru.kustikov.cakes.user.UserEntity;

@Entity(name = "products")
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

    @Column(name = "price")
    private Integer price;

    @Column(name = "count")
    private Integer count;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "topping")
    private String topping;

    @Column(name = "comment")
    private String comment;

    @Column(name = "image", columnDefinition = "TEXT")
    private String image;

    @OneToOne(cascade = CascadeType.ALL)
    private ProductOrderEntity productOrder;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity author;

    public ProductEntity(ProductEntity original) {
        this.name = original.getName();
        this.productType = original.getProductType();
        this.price = original.getPrice();
        this.count = original.getCount();
        this.weight = original.getWeight();
        this.topping = original.getTopping();
        this.comment = original.getComment();
        this.image = original.getImage();
    }
}
