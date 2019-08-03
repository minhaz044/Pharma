/**
 * 
 */
package me.pharmacy.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.pharmacy.services.SalesService;

/**
 * @author Minhaz Uddin
 *
 * Aug 3, 2019
 */
@RestController
@RequestMapping("business")
public class BusinessAnalysisController {
	@Autowired
	private SalesService salesService;
	
	@GetMapping("/today")
	public Map<String,String>getTodaySalesStatus() {
		return null;
	}
	
}
