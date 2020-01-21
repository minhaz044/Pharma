package me.pharmacy.controller;

import me.pharmacy.model.CustomerInfo;
import me.pharmacy.services.CustomerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * Created by Minhaz on 1/21/2020.
 */
@RestController
public class AccountRestController {
    @Autowired
    private CustomerInfoService customerInfoService;
    @GetMapping("/user")
    protected CustomerInfo createUser(@RequestParam("userName")String userName){
        Optional<CustomerInfo> customerInfo= customerInfoService.getCustomerInfo(userName);
        return customerInfo.isPresent()?customerInfo.get():null;
    }
    @GetMapping("/users")
    protected List<CustomerInfo> createUser(){
        return customerInfoService.getAllCustomerInfo();
    }
}
