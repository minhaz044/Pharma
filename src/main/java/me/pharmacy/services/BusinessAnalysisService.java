/**
 * 
 */
package me.pharmacy.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.pharmacy.dao.CustomerRepository;
import me.pharmacy.model.SalesStatics;

/**
 * @author Minhaz Uddin
 *
 * Aug 3, 2019
 */
@Service
public class BusinessAnalysisService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	
	public List<SalesStatics> salesStatics(String  startDate,String endDate) throws ParseException{
		 DateFormat df  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 List<SalesStatics> salesStatics=new ArrayList<SalesStatics>();
		 Date date_from =df.parse(startDate);
		 Date date_to =df.parse(endDate);
		  if(date_to.compareTo(date_from) <0) {
			   	date_to  =df.parse(startDate);
			   	date_from =df.parse(endDate);
		  }
		  Calendar   c = Calendar.getInstance();
		  Date nextDate;
		  while(date_to.compareTo(date_from) >0 || date_to.compareTo(date_from) ==0) {
				c.setTime(date_from);
				c.add(Calendar.DATE, 1);
				nextDate =c.getTime();
				SalesStatics statics =customerRepository.findAllSalesByDate(date_from,nextDate);
				salesStatics.add(statics);
				date_from=nextDate;
				
		  }
		
		salesStatics.sort((ss1,ss2)-> 0-ss1.getDate().compareTo(ss2.getDate()));
		return salesStatics;
	}
	
	
	

}
