package ru.kustikov.cakes.filling;

import lombok.Data;

@Data
public class FillingRecord {
    private Long fillingId;

    private String name;

    private String description;

    private Long userId;
}
