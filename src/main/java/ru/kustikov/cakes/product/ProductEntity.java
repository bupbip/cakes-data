package ru.kustikov.cakes.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.kustikov.cakes.consumable.ConsumableEntity;
import ru.kustikov.cakes.consumableproduct.ConsumableProductEntity;
import ru.kustikov.cakes.filling.FillingEntity;
import ru.kustikov.cakes.productorder.ProductOrderEntity;
import ru.kustikov.cakes.producttype.ProductTypeEntity;
import ru.kustikov.cakes.user.UserEntity;

import java.util.List;

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

    @ManyToOne
    private ProductTypeEntity productType;

    @Column(name = "price")
    private Integer price;

    @Column(name = "count")
    private Integer count;

    @Column(name = "weight")
    private Double weight;

    @ManyToOne
    private FillingEntity topping;

    @Column(name = "comment")
    private String comment;

    @Column(name = "image", columnDefinition = "TEXT")
    private String image;

    @OneToOne(cascade = CascadeType.ALL)
    private ProductOrderEntity productOrder;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity author;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ConsumableProductEntity> consumableProducts;

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
