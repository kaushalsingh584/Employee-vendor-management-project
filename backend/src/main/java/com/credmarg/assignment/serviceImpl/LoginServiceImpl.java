package com.credmarg.assignment.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

import com.credmarg.assignment.IO.LoginRequestIO;
import com.credmarg.assignment.IO.LoginResponseIO;
import com.credmarg.assignment.service.ILoginService;

@Service
public class LoginServiceImpl implements ILoginService{

	@Autowired
	private InMemoryUserDetailsManager inMemoryUserDetailsManager;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	private static Logger log = LoggerFactory.getLogger(LoginServiceImpl.class);	
	
	@Override
	public LoginResponseIO login(LoginRequestIO loginIO) {
		
		LoginResponseIO loginResponseIO = new LoginResponseIO();
		try {
		UserDetails user = inMemoryUserDetailsManager.loadUserByUsername(loginIO.getUsername());
		if (user.getPassword().equals("{noop}"+loginIO.getPassword()))
		{
			loginResponseIO.setAuthenticated(true);
			loginResponseIO.setAuthority(user.getAuthorities().toString().substring(1,user.getAuthorities().toString().length()-1));
		}
		else
			loginResponseIO.setAuthenticated(false);
		}catch(UsernameNotFoundException e) {
			log.error(e.getMessage());
			loginResponseIO.setAuthenticated(false);
		}catch(Exception e) {
			log.error(e.getMessage());
			loginResponseIO.setAuthenticated(false);
		}
		return loginResponseIO;
	}

}
