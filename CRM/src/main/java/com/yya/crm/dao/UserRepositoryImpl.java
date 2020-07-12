package com.yya.crm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yya.crm.entity.User;

@Repository
public class UserRepositoryImpl implements UserRepository {
	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public User findByName(String username) {
		// get the current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();

				String hql = "FROM User u WHERE u.username = :name";
				Query query = currentSession.createQuery(hql);
				query.setParameter("name",username);
				List results = query.list();
				return (User) results.get(0);
	}

}
