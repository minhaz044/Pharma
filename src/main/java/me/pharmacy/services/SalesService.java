package me.pharmacy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.pharmacy.dao.CustomerRepository;
import me.pharmacy.dao.SalesProductRepository;
import me.pharmacy.model.Customer;
import me.pharmacy.model.SalesProduct;

@Service
public class SalesService {
	@Autowired
	public SalesProductRepository salesRepository;
	
	public SalesProduct saveSalesProduct(SalesProduct salesProduct) {
		return salesRepository.save(salesProduct);
	}
}
