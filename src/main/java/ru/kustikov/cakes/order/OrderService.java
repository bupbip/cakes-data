package ru.kustikov.cakes.order;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kustikov.cakes.consumable.ConsumableEntity;
import ru.kustikov.cakes.consumable.ConsumableRepository;
import ru.kustikov.cakes.consumableproduct.ConsumableProductEntity;
import ru.kustikov.cakes.product.ProductEntity;
import ru.kustikov.cakes.product.ProductRepository;
import ru.kustikov.cakes.productorder.ProductOrderEntity;
import ru.kustikov.cakes.productorder.ProductOrderRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ConsumableRepository consumableRepository;
    private final OrderMapper orderMapper;

    public List<OrderRecord> getAllByUserId(String userId) {
        Long id = Long.parseLong(userId);
        List<OrderEntity> entities = orderRepository.getAllByCustomer_UserIdOrConfectioner_UserIdOrderByCreatedDateDesc(id, id);

        return entities.stream()
                .map(orderMapper::entityToDto)
                .collect(Collectors.toList());
    }

    public OrderRecord get(Long id) {
        OrderEntity orderEntity = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        return orderMapper.entityToDto(orderEntity);
    }

    public OrderEntity update(OrderRecord orderRecord) {
        OrderEntity orderEntity = orderMapper.dtoToEntity(orderRecord);

        for (ProductOrderEntity productOrder : orderEntity.getProductOrders()) {
            ProductEntity product = productOrder.getProduct();
            product.getConsumableProducts().forEach(cp -> {
                cp.setProduct(product);
                if (cp.getConsumable().getConsumableId() != null) {
                    ConsumableEntity existingConsumable = consumableRepository.findById(cp.getConsumable().getConsumableId()).orElse(null);
                    if (existingConsumable != null) {
                        cp.setConsumable(existingConsumable);
                    }
                }
            });
        }

        return orderRepository.save(orderEntity);
    }


    public void delete(Long id) {
        orderRepository.deleteById(id);
    }
}
