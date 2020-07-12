package com.yya.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yya.crm.entity.Customer;
import com.yya.crm.service.CustomerService;

@Controller
public class CustomerController {
	
	//Inject CustomerService
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/homepage")
	public String getCustomers(Model theModel){
		
		List<Customer> customers=customerService.getCustomers();
		theModel.addAttribute("customers", customers);
  
		return "customer-list";
		
	}
	
	@GetMapping("/search")
	public String getCustomer(@RequestParam("email") String email,Model theModel) {
		List<Customer> customers=customerService.getCustomers(email);
		theModel.addAttribute("customers", customers);
  
		return "customer-list";
	}
}
