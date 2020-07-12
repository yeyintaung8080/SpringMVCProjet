package com.yya.crm.model;

import java.util.ArrayList;

public class SessionUserInfo {
	private String session_id;
	private String name;
	private ArrayList<String> roles;
	
	public String getSession_id() {
		return session_id;
	}
	public void setSession_id(String session_id) {
		this.session_id = session_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<String> getRoles() {
		return roles;
	}
	public void setRoles(ArrayList<String> roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "SessionUserInfo [session_id=" + session_id + ", name=" + name + ", roles=" + roles + "]";
	}
	
	
}
