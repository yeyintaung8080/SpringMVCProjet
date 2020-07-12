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

import com.yya.crm.entity.Customer;
import com.yya.crm.model.CustomerModel;
import com.yya.crm.service.CustomerService;

@Controller
@RequestMapping("/manager")
public class ManagerController {
	@Autowired
	private CustomerService customerService;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimerEditor=new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimerEditor);
	}
	
	@GetMapping("/showFormForAdd")
	public String showForm(Model model) {
		
		CustomerModel customer=new CustomerModel();
		
		model.addAttribute("customer",customer);
		
		return "customer-register";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@Valid @ModelAttribute("customer") CustomerModel customerModel,BindingResult bindingresult) {
		
		if(bindingresult.hasErrors()){
			return "customer-register";
		}else {
			
			Customer customer=new Customer();
			customer.setFirst_name(customerModel.getFname());
			customer.setLast_name(customerModel.getLname());
			customer.setAge(customerModel.getAge());
			customer.setEmail(customerModel.getEmail());
			customer.setAddress(customerModel.getAddress());
			
			
			customerService.saveCustomer(customer);
		}
		
		return "redirect:/homepage";
	}
}
