package com.yya.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yya.crm.dao.CustomerDao;
import com.yya.crm.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	// need to inject customer dao
	@Autowired
	private CustomerDao customerDao;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		 
		return customerDao.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		customerDao.saveCustomer(customer);
	}

	@Override
	@Transactional
	public Customer getCustomer(Integer id) {
		return customerDao.getCustomers(id);
	}

	@Override
	@Transactional
	public void deleteCustomer(Integer id) {
		customerDao.deleteCustomer(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Customer> getCustomers(String email) {
		// TODO Auto-generated method stub
		return customerDao.getCustomers(email);
	}

}
