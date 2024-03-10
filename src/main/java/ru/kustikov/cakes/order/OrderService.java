package ru.kustikov.cakes.order;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.kustikov.cakes.product.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
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

    public OrderRecord update(OrderRecord orderRecord) {
        OrderEntity orderEntity = orderMapper.dtoToEntity(orderRecord);
        OrderEntity savedOrderEntity = orderRepository.save(orderEntity);

        return orderMapper.entityToDto(savedOrderEntity);
    }

    public void delete(Long id) {
        orderRepository.deleteById(id);
    }
}
