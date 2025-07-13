package com.Priyanka.Expense_tracker.services.income;

import com.Priyanka.Expense_tracker.dto.IncomeDTO;
import com.Priyanka.Expense_tracker.entity.Income;

import java.util.List;

public interface IncomeService {

    Income postIncome(IncomeDTO incomeDTO);

    List<IncomeDTO> getAllIncome();

    IncomeDTO getIncomebyId(long id);

    Income updateIncome(Long id, IncomeDTO incomeDTO);

    void deleteIncome(Long id);
}
