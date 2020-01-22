package me.pharmacy.controller;

import me.pharmacy.model.Customer;
import me.pharmacy.model.CustomerInfo;
import me.pharmacy.services.CustomerInfoService;
import me.pharmacy.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * Created by Minhaz on 1/22/2020.
 */
@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerInfoService customerInfoService;

    @GetMapping("/customer/sales")
    public List<Customer> getUserSales(@RequestParam("userName") String userName){
        return customerService.getCustomerByUserName(userName);
    }
    @GetMapping("/customer/info")
    public CustomerInfo getCustomerInfo(@RequestParam("userName") String userName){
        Optional<CustomerInfo> userInfo=customerInfoService.getCustomerInfo(userName);
        if(userInfo.isPresent()){
            return customerInfoService.getCustomerInfo(userName).get();
        }
        return null;
    }

}
