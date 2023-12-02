package ru.kustikov.cakes.product;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRecord {
    private Long productId;

    private BigDecimal price;

    private Integer count;

    private Double weight;

    private String topping;

    private String comment;

    private byte[] image;
}
