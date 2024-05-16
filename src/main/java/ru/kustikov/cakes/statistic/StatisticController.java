package ru.kustikov.cakes.statistic;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/statistic")
@RequiredArgsConstructor
public class StatisticController {
    private final StatisticService statisticService;

    @GetMapping("/get")
    public ResponseEntity<List<StatisticRecord>> getStatistic(@RequestParam Integer year,
                                                                @RequestParam Long userId) {
        return ResponseEntity.ok(statisticService.getAllByYear(year, userId));
    }

    @GetMapping("/get-month-statistic")
    public ResponseEntity<List<StatisticRecord>> getMonthStatistic(@RequestParam Integer month) {
        return ResponseEntity.ok(statisticService.getStatToSendByMonth(month));
    }
}
