package ru.kustikov.cakes.address;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.kustikov.cakes.city.SettlementEntity;

@Entity(name = "address")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long addressId;

    @ManyToOne
    private SettlementEntity settlement;

    @Column(name = "address")
    private String address;

    @Column(name = "description")
    private String description;
}
