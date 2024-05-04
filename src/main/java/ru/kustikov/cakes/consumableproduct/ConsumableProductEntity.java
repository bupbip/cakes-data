package ru.kustikov.cakes.consumableproduct;

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
import ru.kustikov.cakes.consumable.ConsumableEntity;
import ru.kustikov.cakes.product.ProductEntity;

@Entity(name = "consumable_product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConsumableProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "consumable_product_id")
    private Long consumableProductId;

    @OneToOne
    private ConsumableEntity consumable;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    @Column(name = "count")
    private Double count;
}
