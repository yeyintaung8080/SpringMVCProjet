package com.yya.crm.dao;

import java.util.List;

import com.yya.crm.entity.Customer;

public interface CustomerDao {

	public List<Customer> getCustomers();
	
	public Customer getCustomers(Integer id);
	
	public void saveCustomer(Customer customer);
	
	public void deleteCustomer(Integer id);
	
	public List<Customer> getCustomers(String email);
}
