package ru.kustikov.cakes.producttype;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/product-type")
@RequiredArgsConstructor
public class ProductTypeController {
    private final ProductTypeService productTypeService;

    @PostMapping("/delete")
    public ResponseEntity<String> deleteProductType(@RequestBody Long productTypeId) {
        productTypeService.delete(productTypeId);
        return ResponseEntity.ok("Успешное удаление!");
    }

}
