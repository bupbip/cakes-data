package ru.kustikov.cakes.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1/user")
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
}
