package ru.kustikov.cakes.consumable;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/consumable")
@RequiredArgsConstructor
public class ConsumableController {
    private final ConsumableService consumableService;

    @GetMapping("/get")
    public ResponseEntity<Object> getAll(@RequestParam String username
    ) {
        return ResponseEntity.ok(consumableService.getAllByUser(username));
    }

    @PostMapping("/save")
    public ResponseEntity<List<ConsumableRecord>> createProduct(@RequestBody List<ConsumableRecord> consumables) {
        return ResponseEntity.ok(consumableService.update(consumables));
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deleteProduct(@RequestBody ConsumableRecord consumable) {
        consumableService.delete(consumable.getConsumableId());
        return ResponseEntity.ok("Success!");
    }

}
