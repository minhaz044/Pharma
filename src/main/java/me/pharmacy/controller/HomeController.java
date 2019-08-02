package me.pharmacy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@GetMapping("/")
	protected ModelAndView home() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("index.html");
		return mv;
	}

}
