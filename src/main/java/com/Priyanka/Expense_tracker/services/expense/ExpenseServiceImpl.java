package com.Priyanka.Expense_tracker.services.expense;


import com.Priyanka.Expense_tracker.dto.ExpenseDTO;
import com.Priyanka.Expense_tracker.entity.Expense;
import com.Priyanka.Expense_tracker.repository.ExpenseRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PatchMapping;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService{


    private final ExpenseRepository expenseRepository;

    public Expense postExpense(ExpenseDTO expenseDTO){
        return saveorUpdateExpense(new Expense(), expenseDTO);
    }
    
    private Expense saveorUpdateExpense(Expense expense, ExpenseDTO expenseDTO){

        expense.setTitle(expenseDTO.getTitle());
        expense.setDate(expenseDTO.getDate());
        expense.setAmount(expenseDTO.getAmount());
        expense.setCategory(expenseDTO.getCategory());
        expense.setDescription(expenseDTO.getDescription());

        return expenseRepository.save(expense);
    }

    public Expense updateExpense(Long id, ExpenseDTO expenseDTO){
        return expenseRepository.findById(id)
                .map(expense -> {

            if (expenseDTO.getTitle() != null)
            {
                expense.setTitle(expenseDTO.getTitle());
            }
            if (expenseDTO.getAmount() != null) {
                expense.setAmount(expenseDTO.getAmount());
            }
            if (expenseDTO.getDate() != null) {
                expense.setDate(expenseDTO.getDate());
            }
            if (expenseDTO.getDescription() != null) {
                expense.setDescription(expenseDTO.getDescription());
            }
            if (expenseDTO.getCategory() != null) {
                expense.setCategory(expenseDTO.getCategory());
            }
            return expenseRepository.save(expense);
        }).orElseThrow(() -> new EntityNotFoundException("Expense not found for id " + id));
    }

    public List<Expense> getAllExpense(){
        return expenseRepository.findAll().stream()
                .sorted(Comparator.comparing(Expense::getDate).reversed())
                .collect(Collectors.toList());
    }

    public Expense getExpenseById(Long id){
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if(optionalExpense.isPresent()){
            return optionalExpense.get();
        }else{
            throw new EntityNotFoundException("expense is not present for id"  + id);
        }
    }


    public void deleteExpense(Long id){
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if(optionalExpense.isPresent()){
            expenseRepository.deleteById(id);
        }else{
            throw new EntityNotFoundException("expense is not present for id"  + id);
        }
    }




}


