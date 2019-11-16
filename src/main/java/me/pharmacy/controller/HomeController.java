package me.pharmacy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@GetMapping("/")
	protected ModelAndView index() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("views/index.html");
		return mv;
	}
	  @GetMapping("/business") public ModelAndView Business() {
		  ModelAndView mv=new ModelAndView();
		  mv.setViewName("views/business.html");
		 return mv; 
	  }
	  @GetMapping("/sales") public ModelAndView SalesStatus() {
		  ModelAndView mv=new ModelAndView();
		  mv.setViewName("views/sales.html");
		 return mv; 
	  }
	  @GetMapping("/expense") public ModelAndView ExpenseStatus() {
		  ModelAndView mv=new ModelAndView();
		  mv.setViewName("views/expense.html");
		 return mv; 
	  }
	@GetMapping("/home")
	protected ModelAndView home() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("views/home.html");
		return mv;
	}
	@GetMapping("/shop")
	protected ModelAndView shop() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("views/shop.html");
		return mv;
	}
	@GetMapping("/shop1")
	protected ModelAndView shop1() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("views/shop1.html");
		return mv;
	}
}
