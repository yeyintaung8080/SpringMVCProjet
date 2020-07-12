package com.yya.crm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_account")
public class User {

	@Id
	@Column(name="uid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="user_name")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="role")
	private String role;
	
	public User() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserAccount [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role
				+ ", getId()=" + getId() + ", getUsername()=" + getUsername() + ", getRole()=" + getRole()
				+ ", getPassword()=" + getPassword() + "]";
	}
 
	
	
}
