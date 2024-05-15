package ru.kustikov.cakes.subscriptions;

import lombok.Data;

@Data
public class SubscriptionsRecord {
    private Long subscriptionId;

    private boolean consumable;

    private boolean monthly;

    private Integer userId;
}