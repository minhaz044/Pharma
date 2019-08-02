package me.pharmacy.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.pharmacy.dao.CustomerRepository;
import me.pharmacy.model.Customer;

@Service
public class CustomerService {
	@Autowired
	public CustomerRepository customerRepo;
	List<Customer> getAll(){
		return customerRepo.findAll();
	}
	
	public Customer getCustomer(int id) {
		return customerRepo.findById(id).get();
	}
	
}
