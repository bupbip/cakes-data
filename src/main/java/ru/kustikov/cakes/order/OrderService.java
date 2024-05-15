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
import ru.kustikov.cakes.subscriptions.SendMailService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ConsumableRepository consumableRepository;
    private final OrderMapper orderMapper;
    private final SendMailService mailService;

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

        if (orderRepository.findById(orderRecord.getOrderId()).isPresent()) {
            OrderEntity savedOrder = orderRepository.findById(orderRecord.getOrderId()).get();
            if (savedOrder.getStatus() != orderEntity.getStatus()) {
                mailService.send(orderEntity.getCustomer().getEmail(),
                        "Статус заказа №" + savedOrder.getOrderId() + " поменялся на " + orderEntity.getStatus().getInfo() + ".");
            }
            if (!Objects.equals(savedOrder.getResultPrice(), orderEntity.getResultPrice())) {
                mailService.send(orderEntity.getCustomer().getEmail(),
                        "Итоговая стоимость заказа №" + savedOrder.getOrderId() + " изменилась и составляет: " + orderEntity.getResultPrice() + ".");
            }
            if (!Objects.equals(savedOrder.getCompleteDate(), orderEntity.getCompleteDate())) {
                mailService.send(orderEntity.getCustomer().getEmail(),
                        "Дата выполнения заказа №" + savedOrder.getOrderId() + " изменилась на " + orderEntity.getCompleteDate() + ".");
            }
        } else {
            mailService.send(orderEntity.getCustomer().getEmail(),
                    "Ваш заказ был успешно создан! Всю информацию о нём Вы можете посмотреть во вкладке заказы.");
        }

        return orderRepository.save(orderEntity);
    }


    public void delete(Long id) {
        orderRepository.deleteById(id);
    }
}
