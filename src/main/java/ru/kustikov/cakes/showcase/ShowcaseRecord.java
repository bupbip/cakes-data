package ru.kustikov.cakes.showcase;

import lombok.Data;
import ru.kustikov.cakes.product.ProductEntity;

import java.util.List;

@Data
public class ShowcaseRecord {
    private Long showcaseId;

    private Long userId;

    private List<ProductEntity> products;
}
