package com.yya.crm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yya.crm.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query ... sort by first name
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by first_name", Customer.class);

		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();
		 
		// return the results
		return customers;
	}

	@Override
	public Customer getCustomers(Integer id) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using the primary key
		Customer theCustomer = currentSession.get(Customer.class, id);

		return theCustomer;
	}

	@Override
	public void saveCustomer(Customer customer) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save/upate the customer
		currentSession.saveOrUpdate(customer);
	}

	@Override
	public void deleteCustomer(Integer id) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", id);

		theQuery.executeUpdate();
	}

	@Override
	public List<Customer> getCustomers(String email) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query ... sort by first name
		Query<Customer> theQuery = currentSession.createQuery("from Customer where email=:email", Customer.class);
		theQuery.setParameter("email", email);
		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();
		return customers;
	}

}
