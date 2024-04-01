package ru.kustikov.cakes.order;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/get-all")
    public ResponseEntity<List<OrderRecord>> getUserOrders(@RequestParam String userId) {
        return ResponseEntity.ok(orderService.getAllByUserId(userId));
    }

    @PostMapping("/save")
    public ResponseEntity<String> createProduct(@RequestBody OrderRecord order) {
        orderService.update(order);
        return ResponseEntity.ok("Success!");
    }
}
