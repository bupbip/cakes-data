package ru.kustikov.cakes.statistic;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class StatisticRecord {
    private Long statisticId;

    private Timestamp startDate;

    private Timestamp endDate;

    private Integer orderCount;

    private BigDecimal income;

    private BigDecimal expences;

    private BigDecimal profit;
}
