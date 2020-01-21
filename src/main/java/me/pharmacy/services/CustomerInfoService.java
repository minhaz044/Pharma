package me.pharmacy.services;

import me.pharmacy.dao.CustomerInfoRepository;
import me.pharmacy.dao.CustomerRepository;
import me.pharmacy.model.Customer;
import me.pharmacy.model.CustomerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Minhaz on 1/21/2020.
 */
@Service
public class CustomerInfoService  {
    @Autowired
    public CustomerInfoRepository customerInfoRepo;
    public CustomerInfo saveCustomerInfo(CustomerInfo customerInfo) {
        return customerInfoRepo.save(customerInfo);
    }
    public Optional<CustomerInfo> getCustomerInfo(String userName)
    {
        return customerInfoRepo.findByUserName(userName);
    }
    public Optional<CustomerInfo> getCustomerInfo(int id)
    {
        return customerInfoRepo.findById(id);
    }
    public List<CustomerInfo> getAllCustomerInfo()
    {
        return customerInfoRepo.findAll();
    }


}
