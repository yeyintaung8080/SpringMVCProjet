package com.yya.crm.config;

import java.io.IOException;
import java.security.Principal;
 

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;


import com.yya.crm.model.SessionUserInfo;

@Component
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {

	@Autowired HttpSession session; //autowiring session
 
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse res, Authentication auth)
			throws IOException, ServletException {
		
		session=req.getSession(true);
		
		SessionUserInfo userInfo = new SessionUserInfo();
		String userName;
		
		
        if(auth.getPrincipal() instanceof Principal) {
             userName = ((Principal)auth.getPrincipal()).getName();
             
        }else {
            userName = auth.getName();
        }
        System.out.println(userName);
        userInfo.setSession_id(session.getId());
        userInfo.setName(userName);
        
        
        
        session.setAttribute("SessionUserInfo", userInfo);
		

        res.sendRedirect("homepage");
	}

}
