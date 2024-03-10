package ru.kustikov.cakes.order;

import org.mapstruct.*;
import ru.kustikov.cakes.productorder.ProductOrderEntity;
import ru.kustikov.cakes.productorder.ProductOrderRecord;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface OrderMapper {
    @Mapping(source = "entity.productOrders", target = "products")
    @Mapping(source = "entity.orderId", target = "orderId")
    OrderRecord entityToDto(OrderEntity entity);

    @Mapping(source = "dto.products", target = "productOrders")
    OrderEntity dtoToEntity(OrderRecord dto);

    @Mapping(source = "orderItemId", target = "productOrderId")
    ProductOrderEntity mapProductOrder(ProductOrderRecord productOrderRecord);

    default Long map(OrderEntity order) {
        return order.getOrderId();
    }

    default OrderEntity map(Long orderId) {
        OrderEntity order = new OrderEntity();
        order.setOrderId(orderId);
        return order;
    }

    @AfterMapping
    default void mapOrderId(ProductOrderEntity entity, @MappingTarget ProductOrderRecord record) {
        record.setOrderId(entity.getOrder().getOrderId());
        record.setOrderItemId(entity.getProductOrderId());
    }

    @AfterMapping
    default void mapOrderIds(OrderRecord dto, @MappingTarget OrderEntity entity) {
        // Предполагается, что в OrderRecord есть поле orderId
        entity.setOrderId(dto.getOrderId());

        // Установите productOrderId для каждого ProductOrderEntity в productOrders
        if (entity.getProductOrders() != null) {
            for (ProductOrderEntity productOrderEntity : entity.getProductOrders()) {
                productOrderEntity.setOrder(entity);
            }
        }
    }
}
