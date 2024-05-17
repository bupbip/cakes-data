package ru.kustikov.cakes.producttype;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.kustikov.cakes.user.UserEntity;

import java.util.List;

@Entity(name = "product_types")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_type_id")
    private Long productTypeId;

    @Column(name = "name")
    private String name;

    @Column(name = "can_order")
    private boolean canOrder;

    @Column(name = "can_weight")
    private boolean canWeight;

    @Column(name = "can_count")
    private boolean canCount;

    @ElementCollection
    @Column(name = "fillings")
    private List<Long> fillings;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private UserEntity user;
}
