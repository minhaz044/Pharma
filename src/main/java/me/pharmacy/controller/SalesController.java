package me.pharmacy.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import me.pharmacy.model.Customer;
import me.pharmacy.model.Order;
import me.pharmacy.model.Sales;
import me.pharmacy.model.SalesProduct;
import me.pharmacy.services.CustomerService;
import me.pharmacy.services.SalesService;

@RestController
@RequestMapping("/customer")
public class SalesController {
	@Autowired
	private SalesService salesService;
	@Autowired
	private CustomerService customerService;
		
	@RequestMapping(value = "/sale",method = RequestMethod.POST)
	protected Order SaleProduct(@RequestBody Order order) {
		if(Optional.ofNullable(order).isPresent()) {
			if(Optional.ofNullable(order.getCustomer()).isPresent()) {
				Customer customer=customerService.saveCustomer(order.getCustomer());
				if(Optional.ofNullable(customer).isPresent()) {
					for (Sales sales: order.getOrders()) {
						SalesProduct salesProduct=new SalesProduct();
						salesProduct.setCustomer_id(customer.getCustomer_id());
						salesProduct.setComision(0);
						salesProduct.setProduct_id(sales.getProduct().getMedicine_id());
						salesProduct.setQuantity(sales.getQuantity());
						salesService.saveSalesProduct(salesProduct);
						
					}
					return order;
				} 
			}
		}
		return null;
	}

}
