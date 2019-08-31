package me.pharmacy.services;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.pharmacy.dao.CustomerRepository;
import me.pharmacy.model.Customer;

@Service
public class CustomerService {

	@Autowired
	public CustomerRepository customerRepo;

	public Customer saveCustomer(Customer customer) {
		return customerRepo.save(customer);
	}

	/*
	 * List<Map<String,Double>> getAllCustomer(Date startDate,Date endDate){
	 * 
	 * SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd hh:mm tt"); Calendar
	 * c = Calendar.getInstance(); c.setTime(sdf.parse(startDate));
	 * c.add(Calendar.DATE, 1); // number of days to add dt =
	 * sdf.format(c.getTime());
	 * 
	 * //return customerRepo.findAllSalesByDate(startDate, endDate); return null; }
	 */
	/*
	 * List<Customer> getAll(){ return customerRepo.findAll(); } List<Customer>
	 * getAllDue(Date startDate,Date endDate){ return
	 * customerRepo.findAllDueByDate(startDate, endDate); } List<Customer>
	 * getAllPaid(Date startDate,Date endDate){ return
	 * customerRepo.findAllCashPaidByDate(startDate, endDate); } List<Customer>
	 * getAllCustomer(Date startDate,Date endDate){ return
	 * customerRepo.findAllSalesByDate(startDate, endDate); } List<Customer>
	 * getAllCommission(Date startDate,Date endDate){ return
	 * customerRepo.findAllCommissionByDate(startDate, endDate); }
	 * 
	 * Integer getTotalCashPaid(Date startDate,Date endDate){ return
	 * customerRepo.findTotalCashPaidByDate(startDate, endDate); } Integer
	 * getTotalDue(Date startDate,Date endDate){ return
	 * customerRepo.findTotalDueByDate(startDate, endDate); } Integer
	 * getTotalCommission(Date startDate,Date endDate){ return
	 * customerRepo.findTotalComisionByDate(startDate, endDate); } Integer
	 * getTotalEarn(Date startDate,Date endDate){ return
	 * customerRepo.findTotalEarnByDate(startDate, endDate); } Integer
	 * getTotalSales(Date startDate,Date endDate){ return
	 * customerRepo.findTotalSalesByDate(startDate, endDate); } public Customer
	 * getCustomer(int id) { return customerRepo.findById(id).get(); }
	 */
}
