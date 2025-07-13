package com.Priyanka.Expense_tracker.dto;

import com.Priyanka.Expense_tracker.entity.Expense;
import com.Priyanka.Expense_tracker.entity.Income;
import lombok.Data;

import java.util.List;

@Data
public class GraphDTO {

    private List<Expense> expenseList;
    private List<Income> incomeList;
}
