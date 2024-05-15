package ru.kustikov.cakes.order;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderStatus {
    CREATED("Создан"),
    APPLIED("Принят"),
    DECLINED("Отклонён"),
    HALF_PAID("Оплачен наполовину"),
    PAID("Полностью оплачен"),
    DELIVERED("Доставлен"),
    CANCELLED("Отменён");

    private final String info;
}
