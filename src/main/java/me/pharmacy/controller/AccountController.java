package me.pharmacy.controller;

import me.pharmacy.model.CustomerInfo;
import me.pharmacy.services.CustomerInfoService;
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


}
