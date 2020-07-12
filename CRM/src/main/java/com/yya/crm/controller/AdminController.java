package com.yya.crm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yya.crm.entity.Customer;
import com.yya.crm.model.CustomerModel;
import com.yya.crm.service.CustomerService;
 

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimerEditor=new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimerEditor);
	}
	
	@Autowired
	public CustomerService customerService;
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") Integer customerId,Model theModel) {
		//get the customer from database
		Customer customer=customerService.getCustomer(customerId);
		
		
		CustomerModel customerModel=new CustomerModel();
		customerModel.setId(customerId);
		customerModel.setFname(customer.getFirst_name());
		customerModel.setLname(customer.getLast_name());
		customerModel.setAge(customer.getAge());
		customerModel.setEmail(customer.getEmail());
		customerModel.setAddress(customer.getAddress());
		//set the customer to the model
		theModel.addAttribute("customer",customerModel);
		
		return "customer-update";		
	}
	
	@PostMapping("/updateCustomer")
	public String updateCustomer(@Valid @ModelAttribute("customer") CustomerModel customerModel,BindingResult bindingresult) {
		
		if(bindingresult.hasErrors()){
			return "customer-update";
		}else {
			
			//get the customer from database
			Customer customer=customerService.getCustomer(customerModel.getId());
			
			customer.setFirst_name(customerModel.getFname());
			customer.setLast_name(customerModel.getLname());
			customer.setAge(customerModel.getAge());
			customer.setEmail(customerModel.getEmail());
			customer.setAddress(customerModel.getAddress());
			
			
			customerService.saveCustomer(customer);
		}
		
		return "redirect:/homepage";
	}
	
	@GetMapping("/customerDelete")
	public String deleteCustomer(@RequestParam("customerId") Integer customerId) {
		
		customerService.deleteCustomer(customerId);
		
		return "redirect:/homepage";
	}
}
