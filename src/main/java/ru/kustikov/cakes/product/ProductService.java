package ru.kustikov.cakes.product;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductRecord create(ProductRecord productRecord) {
        ProductEntity productEntity = productMapper.dtoToEntity(productRecord);
        ProductEntity savedProductEntity = productRepository.save(productEntity);
        return productMapper.entityToDto(savedProductEntity);
    }

    public ProductRecord get(Long id) {
        ProductEntity productEntity = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return productMapper.entityToDto(productEntity);
    }

    public ProductRecord update(ProductRecord productRecord) {
        ProductEntity productEntity = productMapper.dtoToEntity(productRecord);
        ProductEntity savedProductEntity = productRepository.save(productEntity);
        return productMapper.entityToDto(savedProductEntity);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
