package ru.kustikov.cakes.statistic;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.kustikov.cakes.consumable.ConsumableEntity;
import ru.kustikov.cakes.consumableproduct.ConsumableProductEntity;
import ru.kustikov.cakes.order.OrderEntity;
import ru.kustikov.cakes.order.OrderRepository;
import ru.kustikov.cakes.order.OrderStatus;
import ru.kustikov.cakes.productorder.ProductOrderEntity;
import ru.kustikov.cakes.user.UserEntity;
import ru.kustikov.cakes.user.UserRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class StatisticService {
    private final StatisticRepository statisticRepository;
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final StatisticMapper statisticMapper;

    public StatisticRecord create(StatisticRecord statisticRecord) {
        StatisticEntity statisticEntity = statisticMapper.dtoToEntity(statisticRecord);
        StatisticEntity savedStatisticEntity = statisticRepository.save(statisticEntity);
        return statisticMapper.entityToDto(savedStatisticEntity);
    }

    public StatisticRecord get(Long id) {
        StatisticEntity statisticEntity = statisticRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Statistic not found"));
        return statisticMapper.entityToDto(statisticEntity);
    }

    public StatisticRecord update(StatisticRecord statisticRecord) {
        StatisticEntity statisticEntity = statisticMapper.dtoToEntity(statisticRecord);
        StatisticEntity savedStatisticEntity = statisticRepository.save(statisticEntity);

        return statisticMapper.entityToDto(savedStatisticEntity);
    }

    public List<StatisticRecord> getAllByYear(Integer year, Long userId) {
        UserEntity user = userRepository.findById(userId).orElseThrow();
        List<StatisticEntity> entities = statisticRepository.findAllByYearAndUser(
                year, user);

        return entities.stream()
                .map(statisticMapper::entityToDto)
                .collect(Collectors.toList());
    }

    public void calculate(OrderEntity orderEntity) {
        LocalDate date = orderEntity.getCreatedDate().toLocalDate();

        StatisticEntity statistic = statisticRepository.findByYearAndMonthAndUser(
                date.getYear(),
                date.getMonthValue(),
                orderEntity.getConfectioner()
        ).orElse(new StatisticEntity(orderEntity.getConfectioner(), date.getYear(), date.getMonthValue(),
                0, 0, 0L, 0L,0L));
        if (orderEntity.getStatus() == OrderStatus.APPLIED) { // принят
            statistic.setOrderCount(statistic.getOrderCount() + 1);
            List<OrderEntity> filteredOrders = orderRepository.getAllByCustomerOrderByCreatedDate(orderEntity.getCustomer()).stream()
                    .filter(order -> {
                        LocalDateTime createdDate = order.getCreatedDate();
                        return createdDate.getMonthValue() == date.getMonthValue() && createdDate.getYear() == date.getYear();
                    })
                    .filter(order -> order.getConfectioner() == orderEntity.getConfectioner())
                    .toList();
            if (filteredOrders.size() == 0) {
                statistic.setCustomerCount(statistic.getCustomerCount() + 1);
            }

            UserEntity confectioner = statistic.getUser();
            decreaseConsumable(confectioner, orderEntity);
            userRepository.save(confectioner);
        }
        if (orderEntity.getStatus() == OrderStatus.CANCELLED) {
            statistic.setOrderCount(statistic.getOrderCount() - 1);

            List<OrderEntity> filteredOrders = orderRepository.getAllByCustomerOrderByCreatedDate(orderEntity.getCustomer()).stream()
                    .filter(order -> {
                        LocalDateTime createdDate = order.getCreatedDate();
                        return createdDate.getMonthValue() == date.getMonthValue() && createdDate.getYear() == date.getYear();
                    })
                    .filter(order -> order.getConfectioner() == orderEntity.getConfectioner())
                    .toList();
            if (filteredOrders.size() != 0) {
                statistic.setCustomerCount(statistic.getCustomerCount() - 1);
            }

            UserEntity confectioner = statistic.getUser();
            increaseConsumable(confectioner, orderEntity);
            userRepository.save(confectioner);
        }
        if (orderEntity.getStatus() == OrderStatus.PAID) {
            statistic.setIncome(Long.valueOf(orderEntity.getResultPrice()) + statistic.getIncome());
            statistic.setExpences(Long.valueOf(orderEntity.getSpentPrice()) + statistic.getExpences());
            statistic.setProfit(statistic.getIncome() - statistic.getExpences() + statistic.getProfit());
        }
        statisticRepository.save(statistic);
    }

    public void delete(Long id) {
        statisticRepository.deleteById(id);
    }

    private void decreaseConsumable(UserEntity user, OrderEntity order) {
        List<ConsumableEntity> userConsumables = user.getConsumables();
        List<ProductOrderEntity> productOrders = order.getProductOrders();

        for (ProductOrderEntity productOrder : productOrders) {
            List<ConsumableProductEntity> consumableProducts = productOrder.getProduct().getConsumableProducts();

            if (consumableProducts != null) {
                for (ConsumableProductEntity consumableProduct : consumableProducts) {

                    for (ConsumableEntity userConsumable : userConsumables) {
                        if (userConsumable.getConsumableId().equals(consumableProduct.getConsumable().getConsumableId())) {
                            double newCount = userConsumable.getQuantity() - consumableProduct.getCount();
                            userConsumable.setQuantity(newCount);
                            break;
                        }
                    }
                }
            }
        }
    }

    private void increaseConsumable(UserEntity user, OrderEntity order) {
        List<ConsumableEntity> userConsumables = user.getConsumables();
        List<ProductOrderEntity> productOrders = order.getProductOrders();

        for (ProductOrderEntity productOrder : productOrders) {
            List<ConsumableProductEntity> consumableProducts = productOrder.getProduct().getConsumableProducts();

            if (consumableProducts != null) {
                for (ConsumableProductEntity consumableProduct : consumableProducts) {

                    for (ConsumableEntity userConsumable : userConsumables) {
                        if (userConsumable.getConsumableId().equals(consumableProduct.getConsumable().getConsumableId())) {
                            double newCount = userConsumable.getQuantity() + consumableProduct.getCount();
                            userConsumable.setQuantity(newCount);
                            break;
                        }
                    }
                }
            }
        }
    }
}
