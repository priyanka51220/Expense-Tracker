package com.Priyanka.Expense_tracker.controller;

import com.Priyanka.Expense_tracker.dto.GraphDTO;
import com.Priyanka.Expense_tracker.services.StatsService.StatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stats")
@RequiredArgsConstructor
@CrossOrigin("*")
public class StatsController {

    public final StatsService statsService;

    @GetMapping("/charts")
    public ResponseEntity<GraphDTO> getChartData(){
        return ResponseEntity.ok(statsService.getChartData());
    }

    @GetMapping
    public ResponseEntity<?> getStats(){
        return ResponseEntity.ok(statsService.getStats());
    }
}
