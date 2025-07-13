package com.Priyanka.Expense_tracker.dto;

import com.Priyanka.Expense_tracker.entity.Expense;
import com.Priyanka.Expense_tracker.entity.Income;
import lombok.Data;

@Data
public class StatsDTO {

    private Double totalIncome;
    private Double totalExpense;

    private Income latestIncome;
    private Expense latestExpense;

    private Double balance;

    private Double minIncome;
    private Double maxIncome;

    private Double minExpense;
    private Double maxExpense;

}
