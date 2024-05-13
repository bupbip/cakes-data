package ru.kustikov.cakes.consumable;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<ConsumableRecord> create(@RequestBody ConsumableRecord consumables) {
        return ResponseEntity.ok(consumableService.update(consumables));
    }

    @DeleteMapping("/delete/{consumableId}")
    public ResponseEntity<String> delete(@PathVariable Long consumableId) {
        consumableService.delete(consumableId);
        return ResponseEntity.ok("Success!");
    }



}
