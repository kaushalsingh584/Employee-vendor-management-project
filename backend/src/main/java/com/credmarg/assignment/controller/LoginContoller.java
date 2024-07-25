package com.credmarg.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.credmarg.assignment.IO.LoginRequestIO;
import com.credmarg.assignment.IO.LoginResponseIO;
import com.credmarg.assignment.service.ILoginService;

@RestController
@RequestMapping("app/")
public class LoginContoller {
	
	@Autowired
	private ILoginService loginService;
	
	@PostMapping("/login")
	public LoginResponseIO login(@RequestBody LoginRequestIO loginRequest) {
		LoginResponseIO loginResponseIO = loginService.login(loginRequest);
		return loginResponseIO;
	}

}
