package ru.kustikov.cakes.product;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.kustikov.cakes.user.UserEntity;
import ru.kustikov.cakes.user.UserMapper;
import ru.kustikov.cakes.user.UserRecord;
import ru.kustikov.cakes.user.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final ProductMapper productMapper;
    private final UserMapper userMapper;

    public ProductRecord get(Long id) {
        ProductEntity productEntity = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return productMapper.entityToDto(productEntity);
    }

    public List<ProductRecord> getAll(Integer skip, Integer limit) {
        Page<ProductEntity> products = productRepository.findAllByAuthorNotNull(PageRequest.of(skip / limit, limit));

        return products.stream()
                .map(productMapper::entityToDto)
                .collect(Collectors.toList());
    }

    public List<ProductRecord> getAllByUser(UserRecord user) {
        List<ProductEntity> products = productRepository.findAllByAuthor(userMapper.dtoToEntity(user));

        return products.stream()
                .map(productMapper::entityToDto)
                .collect(Collectors.toList());
    }

    public ProductRecord update(ProductRecord productRecord) {
        UserEntity user = userRepository.findByUsername(productRecord.getOwnerUsername()).orElseThrow();
        ProductEntity productEntity = productMapper.dtoToEntity(productRecord);
        productEntity.setAuthor(user);
        productEntity.getConsumableProducts().forEach(p -> p.setProduct(productEntity));
        productEntity.getConsumableProducts().forEach(cp -> cp.getConsumable().setUser(user));
        ProductEntity savedProductEntity = productRepository.save(productEntity);
        return productMapper.entityToDto(savedProductEntity);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
