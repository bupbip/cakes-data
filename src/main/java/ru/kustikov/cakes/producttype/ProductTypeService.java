package ru.kustikov.cakes.producttype;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductTypeService {
    private final ProductTypeRepository productTypeRepository;

    public void delete(Long productTypeId) {
        ProductTypeEntity productType = productTypeRepository.findById(productTypeId)
                .orElseThrow(() -> new IllegalArgumentException("Product type not found with id: " + productTypeId));
        productTypeRepository.delete(productType);
    }
}
