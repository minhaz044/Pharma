package me.pharmacy.controller;

import java.util.List;
import java.util.Optional;


import me.pharmacy.model.*;
import me.pharmacy.services.CustomerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import me.pharmacy.services.CustomerService;
import me.pharmacy.services.SalesService;

@RestController
@RequestMapping("/customer")
public class SalesController {
	@Autowired
	private SalesService salesService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private CustomerInfoService customerInfoService;

	@RequestMapping(value = "/sale",method = RequestMethod.POST)
	protected Order SaleProduct(@RequestBody Order order) {
		try{
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
						if(order.getUserInfoId()>0){
							Optional<CustomerInfo> CustomerInfo =customerInfoService.getCustomerInfo(order.getUserInfoId());
							if(CustomerInfo.isPresent()){
								double amount1=(double)(CustomerInfo.get().getTotalAmount()==null?0:CustomerInfo.get().getTotalAmount());
								double amount2=customer.getCashBackAmount();
								CustomerInfo.get().setTotalAmount(amount1+amount2);
								customerInfoService.saveCustomerInfo(CustomerInfo.get());
							}
						}
						return order;
					}
				}
			}
		}catch (Exception e){
			return null;
		}

		return null;
	}

}
