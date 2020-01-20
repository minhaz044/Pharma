/**
 * 
 */
package me.pharmacy.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import me.pharmacy.dao.ExpenseStatics;
import me.pharmacy.services.BusinessAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

	@GetMapping("/date")
	public List<ExpenseStatics> getTodaySalesStatus(@RequestParam("from") String from , @RequestParam("to") String to) throws ParseException {
		System.out.println(from);
		System.out.println(to);
		return expenseService.expenseStatics(from,to);
	}
	@GetMapping("/week") public Map<String,String> getThisWeekSalesStatus() {
		return null;
	}
	@GetMapping("/month") public Map<String,String>getThisMonthSalesStatus() {
		return null;
	}
	@GetMapping("/year") public Map<String,String>getThisYearSalesStatus() {
		return null;
	}

}
