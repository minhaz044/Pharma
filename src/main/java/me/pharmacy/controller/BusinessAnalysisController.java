/**
 * 
 */
package me.pharmacy.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import me.pharmacy.model.SalesStatics;
import me.pharmacy.services.BusinessAnalysisService;
import me.pharmacy.services.SalesService;

/**
 * @author Minhaz Uddin
 *
 * Aug 3, 2019
 */
@RestController
@RequestMapping("/business")
public class BusinessAnalysisController {
	
	  @Autowired
	  private BusinessAnalysisService businessAnalysisService;
	
	  
	  @GetMapping("/date") 
	  public List<SalesStatics> getTodaySalesStatus( @RequestParam("from") String from ,@RequestParam("to") String to) throws ParseException {
		 
		  System.out.println(from);
		  System.out.println(to);
		 
		 return businessAnalysisService.salesStatics(from,to); 
	  }
	  @GetMapping("/week") public Map<String,String>getThisWeekSalesStatus() {
		 return null; 
	  }
	  @GetMapping("/month") public Map<String,String>getThisMonthSalesStatus() {
		 return null; 
	  }
	  @GetMapping("/year") public Map<String,String>getThisYearSalesStatus() {
		 return null; 
	  }
	 
}
