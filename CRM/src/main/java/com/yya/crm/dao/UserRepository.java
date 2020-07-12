package com.yya.crm.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.yya.crm.entity.User;

public interface UserRepository{
	User findByName(String username);
}
