package ru.kustikov.cakes.statistic;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.kustikov.cakes.user.UserEntity;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StatisticEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "statistic_id")
    private Long statisticId;

    @OneToOne
    private UserEntity user;

    @Column(name = "start_date")
    private Timestamp startDate;

    @Column(name = "end_date")
    private Timestamp endDate;

    @Column(name = "order_count")
    private Integer orderCount;

    @Column(name = "income", columnDefinition = "numeric(19,2)")
    private BigDecimal income;

    @Column(name = "expences", columnDefinition = "numeric(19,2)")
    private BigDecimal expences;

    @Column(name = "profit", columnDefinition = "numeric(19,2)")
    private BigDecimal profit;
}
