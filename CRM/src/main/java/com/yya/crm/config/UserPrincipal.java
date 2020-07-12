package com.yya.crm.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.yya.crm.entity.User;

public class UserPrincipal implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2838387798043853474L;
	
	private User user_acc;
	
	public UserPrincipal(User userAccount) {
		this.user_acc=userAccount;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		 List<GrantedAuthority> grantedAuths=new ArrayList<GrantedAuthority>();
		
		List<String> roleList=Arrays.asList(this.user_acc.getRole().split(","));
		
		roleList.forEach(r->{
			GrantedAuthority authority=new SimpleGrantedAuthority("ROLE_"+r);
			
			grantedAuths.add(authority);
		});
		return grantedAuths; 
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.user_acc.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.user_acc.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
