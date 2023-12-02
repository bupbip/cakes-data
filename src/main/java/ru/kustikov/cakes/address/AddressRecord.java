package ru.kustikov.cakes.address;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class AddressRecord {
    private Long addressId;

    private String settlementName;

    @Column(name = "address")
    private String address;

    @Column(name = "description")
    private String description;
}
