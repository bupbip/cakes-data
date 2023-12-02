package ru.kustikov.cakes.order;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderRecord create(OrderRecord orderRecord) {
        OrderEntity orderEntity = orderMapper.dtoToEntity(orderRecord);
        OrderEntity savedOrderEntity = orderRepository.save(orderEntity);
        return orderMapper.entityToDto(savedOrderEntity);
    }

    public OrderRecord get(Long id) {
        OrderEntity orderEntity = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        return orderMapper.entityToDto(orderEntity);
    }

    public OrderRecord update(OrderRecord orderRecord) {
        OrderEntity orderEntity = orderMapper.dtoToEntity(orderRecord);
        OrderEntity savedOrderEntity = orderRepository.save(orderEntity);
        return orderMapper.entityToDto(savedOrderEntity);
    }

    public void delete(Long id) {
        orderRepository.deleteById(id);
    }
}
