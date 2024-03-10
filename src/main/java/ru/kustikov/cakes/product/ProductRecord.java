package ru.kustikov.cakes.product;

import lombok.Data;

@Data
public class  ProductRecord {
    private Long productId;

    private String name;

    private Integer price;

    private Integer count;

    private Double weight;

    private String topping;

    private String comment;

    private ProductType productType;

    private String image;

    private String ownerUsername;
}
