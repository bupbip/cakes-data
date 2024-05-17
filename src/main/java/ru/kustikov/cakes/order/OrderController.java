package ru.kustikov.cakes.order;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kustikov.cakes.statistic.StatisticService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final StatisticService statisticService;

    @GetMapping("/get-all")
    public ResponseEntity<List<OrderRecord>> getUserOrders(@RequestParam String userId) {
        return ResponseEntity.ok(orderService.getAllByUserId(userId));
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> save(@RequestBody OrderRecord order) {
        OrderEntity orderEntity = orderService.update(order);

        statisticService.calculate(orderEntity);
        return ResponseEntity.ok("Success!");
    }
}
