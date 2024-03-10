package ru.kustikov.cakes.product;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kustikov.cakes.user.UserEntity;
import ru.kustikov.cakes.user.UserMapper;
import ru.kustikov.cakes.user.UserService;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final UserService userService;

    private final UserMapper userMapper;

    @GetMapping("/get-all")
    public ResponseEntity<Object> getAll(@RequestParam(required = false) String username) {
        if (username != null && !username.isEmpty()) {
            UserEntity user = userService.getUserByUsername(username);
            return ResponseEntity.ok(productService.getAllByUser(user));
        } else {
            return ResponseEntity.ok(productService.getAll());
        }
    }

    @PostMapping("/save")
    public ResponseEntity<String> createProduct(@RequestBody ProductRecord product) {
        productService.update(product);
        return ResponseEntity.ok("Success!");
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deleteProduct(@RequestBody ProductRecord product) {
        productService.delete(product.getProductId());
        return ResponseEntity.ok("Success!");
    }

}
