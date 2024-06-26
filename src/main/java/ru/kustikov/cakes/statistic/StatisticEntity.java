package ru.kustikov.cakes.statistic;

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
import ru.kustikov.cakes.user.UserEntity;

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

    @ManyToOne
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

    public StatisticEntity(UserEntity user, Integer year, Integer month, Integer orderCount, Integer customerCount, Long income, Long expences, Long profit) {
        this.user = user;
        this.year = year;
        this.month = month;
        this.orderCount = orderCount;
        this.customerCount = customerCount;
        this.income = income;
        this.expences = expences;
        this.profit = profit;
    }
}
