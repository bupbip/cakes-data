package ru.kustikov.cakes.rolerequest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/role-request")
@RequiredArgsConstructor
public class RoleRequestController {
    private final RoleRequestService roleRequestService;

    @GetMapping("/get-all")
    public ResponseEntity<List<RoleRequestRecord>> getAll() {
        return ResponseEntity.ok(roleRequestService.getAll());
    }

    @PostMapping("/approve")
    public ResponseEntity<String> approve(@RequestBody RoleRequestRecord request) {
        return ResponseEntity.ok(roleRequestService.approve(request));
    }

    @PostMapping("/decline")
    public ResponseEntity<String> decline(@RequestBody RoleRequestRecord request) {
        return ResponseEntity.ok(roleRequestService.decline(request));
    }

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody RoleRequestRecord record) {
        return ResponseEntity.ok(roleRequestService.save(record));
    }
}
