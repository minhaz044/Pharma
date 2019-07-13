package me.pharmacy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import me.pharmacy.dao.CustomerRepository;
import me.pharmacy.dao.SalesRepository;
import me.pharmacy.services.CustomerService;
import me.pharmacy.services.SalesService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private SalesService salesService;
	@Autowired
	private CustomerService customerService;
	/*	
	@RequestMapping(value = "/sale",method = RequestMethod.POST)
	protected List SaleProduct() {
		
	}*/

}
