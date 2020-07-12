package com.yya.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	@GetMapping("/showLoginPage")
	public String showMyLoginPage() {
		
		return "plain-login";
	}
	
	@GetMapping("/access-danied")
	public String showAccessDenied() {
		
		return "access-danied";
	}
	
	 
	
}
