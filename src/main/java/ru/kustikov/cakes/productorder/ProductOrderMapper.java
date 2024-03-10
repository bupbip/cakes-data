package ru.kustikov.cakes.productorder;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import ru.kustikov.cakes.order.OrderEntity;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ProductOrderMapper {
    @Mapping(source = "entity.order.orderId", target = "orderId")
    @Mapping(source = "entity.productOrderId", target = "orderItemId")
    ProductOrderRecord entityToDto(ProductOrderEntity entity);

    @Mapping(source = "dto.orderId", target = "order")
    @Mapping(source = "dto.orderItemId", target = "productOrderId")
    ProductOrderEntity dtoToEntity(ProductOrderRecord dto);

    default Long map(OrderEntity order) {
        return order.getOrderId();
    }

    default OrderEntity map(Long orderId) {
        OrderEntity order = new OrderEntity();
        order.setOrderId(orderId);
        return order;
    }
}

