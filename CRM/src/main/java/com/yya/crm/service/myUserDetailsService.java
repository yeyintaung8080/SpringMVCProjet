package com.yya.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yya.crm.config.UserPrincipal;
import com.yya.crm.dao.UserRepository;
import com.yya.crm.entity.User;

@Service
public class myUserDetailsService implements UserDetailsService{

 
	@Autowired
	private UserRepository repo;
	
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		  User user=repo.findByName(username);
		 user.toString();
		  
		 if(user==null)
			 throw new UsernameNotFoundException("User 404");
		  
		return new UserPrincipal(user);
	}

}
