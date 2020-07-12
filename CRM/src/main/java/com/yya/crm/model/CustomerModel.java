package com.yya.crm.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class CustomerModel {
	
	private Integer id;//hidden
	
	@NotNull(message="is required")
	private String fname;
	
	@NotNull(message="is required")
	private String lname;
	
	@NotNull(message="is required")
	@Min(value=18,message="invalid")//constraint number values
	@Max(value=130,message="invalid")//constraint number values
	private Integer age;
	
	@NotNull(message="is required")
	private String email;
	
	@NotNull(message="is required")
	private String address;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "CustomerModel [fname=" + fname + ", lname=" + lname + ", age=" + age + ", email=" + email + ", address="
				+ address + "]";
	}

	
}
