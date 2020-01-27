package me.pharmacy.controller;

import me.pharmacy.model.CustomerInfo;
import me.pharmacy.model.DuePayHistry;
import me.pharmacy.services.CustomerInfoService;
import me.pharmacy.services.DuePayHistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

/**
 * Created by Minhaz on 1/20/2020.
 */
@Controller
public class AccountController {
    @Autowired
    private CustomerInfoService customerInfoService;

    @Autowired
    private DuePayHistryService duePayHistryService;



    @GetMapping("/create")
    protected ModelAndView createUser(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("views/createUser.html");
        return mv;
    }
    @PostMapping("/create")
    protected RedirectView createUser(@ModelAttribute  CustomerInfo customerInfo){
        customerInfoService.saveCustomerInfo(customerInfo);
        return new RedirectView("/success");
    }
    @PostMapping("/payDue")
    protected RedirectView createUser(@ModelAttribute DuePayHistry duePayHistry) {
        try {
            System.out.println("Controller Hit----------");
            Optional<CustomerInfo> user = customerInfoService.getCustomerInfo(duePayHistry.userId);
            if (user.isPresent() && user.get().getTotalDue() > 0 && user.get().getTotalDue() >= duePayHistry.getAmount()) {
                user.get().setTotalDue(user.get().getTotalDue() - duePayHistry.getAmount());
                customerInfoService.saveCustomerInfo(user.get());
                duePayHistry.setRemainingAmount(user.get().getTotalDue());
                duePayHistry.setCustomerInfoId(user.get());
                duePayHistryService.saveCustomerInfo(duePayHistry);
                return new RedirectView("/success");
            }
        }catch(Exception e){
        System.out.println(e);
    }
        return null;
 }
}
