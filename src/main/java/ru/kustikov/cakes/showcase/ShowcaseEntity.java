package ru.kustikov.cakes.showcase;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.kustikov.cakes.product.ProductEntity;
import ru.kustikov.cakes.user.UserEntity;

import java.util.List;

@Entity(name = "showcases")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShowcaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "showcase_id")
    private Long showcaseId;

    @OneToMany
    private List<ProductEntity> products;

    @OneToOne
    private UserEntity user;
}
