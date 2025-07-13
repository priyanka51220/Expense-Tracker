package com.Priyanka.Expense_tracker.services.StatsService;

import com.Priyanka.Expense_tracker.dto.GraphDTO;
import com.Priyanka.Expense_tracker.dto.StatsDTO;

public interface StatsService {

    GraphDTO getChartData();

    StatsDTO getStats();
}
