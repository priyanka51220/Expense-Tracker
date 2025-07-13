package com.Priyanka.Expense_tracker.services.expense;

import com.Priyanka.Expense_tracker.dto.ExpenseDTO;
import com.Priyanka.Expense_tracker.entity.Expense;

import java.util.List;

public interface ExpenseService {

    Expense postExpense(ExpenseDTO expenseDTO);
    Expense updateExpense(Long id, ExpenseDTO expenseDTO);

    List<Expense> getAllExpense();

    Expense getExpenseById(Long id);

    void deleteExpense(Long id);


}
