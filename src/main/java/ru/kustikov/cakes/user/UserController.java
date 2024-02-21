package ru.kustikov.cakes.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    private final UserMapper userMapper;

    @PostMapping("/register")
    public ResponseEntity<Object> register(UserRecord userRecord) {
        return ResponseEntity.ok(userService.saveUser(userRecord));
    }

    @PostMapping("/login")
    public ResponseEntity<Object> authenticate(UserRecord userRecord) {
        return ResponseEntity.ok(userService.getUserByEmail(userRecord.getEmail()));
    }

    @GetMapping("/get")
    public ResponseEntity<Object> getUser(@RequestParam String username) {
        return ResponseEntity.ok(userService.getUserByUsername(username));
    }

    @GetMapping("/confectioners")
    public ResponseEntity<Object> getConfectioners() {
        return ResponseEntity.ok(userService.getConfectioners());
    }

    @PostMapping("/save")
    public ResponseEntity<String> createProduct(@RequestBody UserRecord user) {
        userService.update(user);
        return ResponseEntity.ok("Success!");
    }
}
