package ru.kustikov.cakes.consumable;

import lombok.Data;

@Data
public class ConsumableRecord {
    private Long consumableId;

    private String name;

    private Double quantity;

    private Double threshold;

    private String quantityType;

    private String userId;
}
