package ru.kustikov.cakes.filling;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/filling")
@RequiredArgsConstructor
public class FillingController {
    private final FillingService fillingService;

    @PostMapping("/save")
    public ResponseEntity<List<FillingRecord>> saveFillings(@RequestBody List<FillingRecord> fillings) {
        return ResponseEntity.ok(fillingService.save(fillings));
    }

    @PostMapping("/delete")
    public ResponseEntity<String> saveFillings(@RequestBody Long fillingId) {
        fillingService.delete(fillingId);
        return ResponseEntity.ok("Success delete");
    }
}
