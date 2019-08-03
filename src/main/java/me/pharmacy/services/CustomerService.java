package me.pharmacy.services;

import java.util.Date;
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
	List<Customer> getAllDue(Date startDate,Date endDate){
		return customerRepo.findAllDueByDate(startDate, endDate);
	}
	List<Customer> getAllPaid(Date startDate,Date endDate){
		return customerRepo.findAllCashPaidByDate(startDate, endDate);
	}
	List<Customer> getAllCustomer(Date startDate,Date endDate){
		return customerRepo.findAllSalesByDate(startDate, endDate);
	}
	List<Customer> getAllCommission(Date startDate,Date endDate){
		return customerRepo.findAllCommissionByDate(startDate, endDate);
	}
	
	Integer getTotalCashPaid(Date startDate,Date endDate){
		return customerRepo.findTotalCashPaidByDate(startDate, endDate);
	}
	Integer getTotalDue(Date startDate,Date endDate){
		return customerRepo.findTotalDueByDate(startDate, endDate);
	}
	Integer getTotalCommission(Date startDate,Date endDate){
		return customerRepo.findTotalComisionByDate(startDate, endDate);
	}
	Integer getTotalEarn(Date startDate,Date endDate){
		return customerRepo.findTotalEarnByDate(startDate, endDate);
	}
	Integer getTotalSales(Date startDate,Date endDate){
		return customerRepo.findTotalSalesByDate(startDate, endDate);
	}
	public Customer getCustomer(int id) {
		return customerRepo.findById(id).get();
	}
	
}
