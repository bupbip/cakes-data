package ru.kustikov.cakes.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<Object> getConfectioners(@RequestParam Integer skip,
                                                   @RequestParam Integer limit) {
        return ResponseEntity.ok(userService.getConfectioners(skip, limit));
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveUser(@RequestBody UserRecord user) {
        userService.update(user);
        return ResponseEntity.ok("Success!");
    }
}
