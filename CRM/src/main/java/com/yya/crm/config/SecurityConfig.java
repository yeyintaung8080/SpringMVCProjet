package com.yya.crm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
 

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailService;
	
	@Autowired
	AuthenticationSuccessHandler authenticationSuccessHandler;
	
	@Bean
	 public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		provider.setUserDetailsService(this.userDetailService);
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		return provider;
		 
	 }

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	http.authorizeRequests()
		 
		 .antMatchers("/homepage").hasRole("MEMBER")
		 .antMatchers("/admin/**").hasRole("ADMIN")
		 .antMatchers("/manager/**").hasRole("MANAGER")
		 .and()
		 .formLogin()
		 	.loginPage("/showLoginPage")
		 		.loginProcessingUrl("/authenticateUser")
		 		.permitAll().successHandler(authenticationSuccessHandler)
		 .and()
		 .logout()
			 .invalidateHttpSession(true)
			 .permitAll()
		 .and()
			 .logout()
			 .invalidateHttpSession(true)
			 .permitAll()
		 .and()
			 .exceptionHandling().accessDeniedPage("/access-danied");
	}
	
	
}
