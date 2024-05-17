package ru.kustikov.cakes.statistic;

import lombok.Data;

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
