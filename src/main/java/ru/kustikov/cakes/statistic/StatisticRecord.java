package ru.kustikov.cakes.statistic;

import jakarta.persistence.Column;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
public class StatisticRecord {
    private Long statisticId;

    private Integer year;

    private Integer month;

    private Integer orderCount;

    private Integer customerCount;

    private Long income;

    private Long expences;

    private Long profit;

    private String userEmail;
}
