/**
 * 
 */
package me.pharmacy.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.pharmacy.model.Expense;
import me.pharmacy.model.SalesStatics;
import me.pharmacy.services.ExpenseService;

/**
 * @author Minhaz Uddin
 *
 * Nov 16, 2019
 */

@RestController
@RequestMapping("/expense")
public class ExpenseController {
	@Autowired
	public  ExpenseService expenseService;
	
	@PostMapping("/add")
	public Expense addExpense(@RequestBody Expense expense) {
		return expenseService.addExpense(expense);
	}
	
	public List<Expense> getExpenseBetweenDate(@RequestParam("startDate") String startDate ,@RequestParam("endDate") String endDate ) throws ParseException{
		return expenseService.getAllExpenseBetweenDate(startDate, endDate);
	}
	


}
