package ru.kustikov.cakes.consumableproduct;

import lombok.Data;
import ru.kustikov.cakes.consumable.ConsumableRecord;

@Data
public class ConsumableProductRecord {
    private Long consumableProductId;

    private ConsumableRecord consumable;

    private Double count;
}
