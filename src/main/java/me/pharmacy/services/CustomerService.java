package me.pharmacy.services;

import java.util.List;

import org.springframework.stereotype.Service;

import me.pharmacy.dao.CustomerRepository;
import me.pharmacy.model.Customer;

@Service
public class CustomerService {
	public CustomerRepository customerRepo;
	List<Customer> getAll(){
		return customerRepo.findAll();
	}
	


}
