/**
 * 
 */
package me.pharmacy.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.pharmacy.dao.ExpenseRepository;
import me.pharmacy.model.Expense;
import me.pharmacy.model.SalesStatics;

/**
 * @author Minhaz Uddin
 *
 * Nov 16, 2019
 */

@Service
public class ExpenseService {
	@Autowired
	private ExpenseRepository expenseRepository; 
	public Expense addExpense(Expense expense) {
		return expenseRepository.save(expense);
	}
	
	public List<Expense> getAllExpenseBetweenDate(String startDate,String endDate) throws ParseException{
		 DateFormat df  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 List<SalesStatics> salesStatics=new ArrayList<SalesStatics>();
		 Date date_from =df.parse(startDate);
		 Date date_to =df.parse(endDate);
		return expenseRepository.findAllByDate(date_from, date_to);
	}
	
}
