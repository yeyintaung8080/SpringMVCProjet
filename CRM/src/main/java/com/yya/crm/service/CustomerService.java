package com.yya.crm.service;

import java.util.List;

import com.yya.crm.entity.Customer;

 

public interface CustomerService {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(Integer id);
	
	public List<Customer> getCustomers(String email);

	public void deleteCustomer(Integer id);
}
