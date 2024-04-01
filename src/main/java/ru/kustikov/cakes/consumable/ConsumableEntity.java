package ru.kustikov.cakes.consumable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

@Entity(name = "consumables")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConsumableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "consumable_id")
    private Long consumableId;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private Double quantity;

    /**
     * Тип количества (штуки, граммы, литры и т.д.)
     */
    @Column(name = "quantity_type")
    @Enumerated(EnumType.STRING)
    private ConsumableQuantityType quantityType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private UserEntity user;
}
