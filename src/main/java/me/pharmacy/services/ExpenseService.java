/**
 * 
 */
package me.pharmacy.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import me.pharmacy.dao.ExpenseStatics;
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

	public List<ExpenseStatics> expenseStatics(String  startDate, String endDate) throws ParseException{
		DateFormat df  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<ExpenseStatics> expenseStatics=new ArrayList<ExpenseStatics>();
		Date date_from =df.parse(startDate);
		Date date_to =df.parse(endDate);
		if(date_to.compareTo(date_from) <0) {
			date_to  =df.parse(startDate);
			date_from =df.parse(endDate);
		}
		Calendar c = Calendar.getInstance();
		Date nextDate;
		while(date_to.compareTo(date_from) >0 || date_to.compareTo(date_from) ==0) {
			c.setTime(date_from);
			c.add(Calendar.DATE, 1);
			nextDate =c.getTime();
			ExpenseStatics statics =expenseRepository.findTotalExpenseByDate(date_from,nextDate);
			expenseStatics.add(statics);
			date_from=nextDate;
		}
		expenseStatics.sort((ss1,ss2)-> 0-ss1.getDate().compareTo(ss2.getDate()));
		return expenseStatics;
	}


}
