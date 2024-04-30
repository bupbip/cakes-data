package ru.kustikov.cakes.product;

import lombok.Data;
import ru.kustikov.cakes.consumable.ConsumableRecord;
import ru.kustikov.cakes.filling.FillingRecord;
import ru.kustikov.cakes.producttype.ProductTypeRecord;

import java.util.List;

@Data
public class  ProductRecord {
    private Long productId;

    private String name;

    private Integer price;

    private Integer count;

    private Double weight;

    private FillingRecord topping;

    private String comment;

    private ProductTypeRecord productType;

    private String image;

    private String ownerUsername;

    private List<ConsumableRecord> consumables;
}
