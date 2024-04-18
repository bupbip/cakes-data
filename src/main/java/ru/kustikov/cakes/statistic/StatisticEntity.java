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
import java.time.LocalDate;

@Entity(name = "statistics")
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

    @Column(name = "year")
    private Integer year;

    @Column(name = "month")
    private Integer month;

    @Column(name = "order_count")
    private Integer orderCount;

    @Column(name = "customer_count")
    private Integer customerCount;

    @Column(name = "income")
    private Long income;

    @Column(name = "expences")
    private Long expences;

    @Column(name = "profit")
    private Long profit;
}
