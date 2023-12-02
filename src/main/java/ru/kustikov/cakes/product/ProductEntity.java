package ru.kustikov.cakes.product;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

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

    @Lob
    @Column(name = "image", columnDefinition = "bytea")
    private byte[] image;
}
