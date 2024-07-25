package com.credmarg.assignment.service;

import com.credmarg.assignment.IO.LoginRequestIO;
import com.credmarg.assignment.IO.LoginResponseIO;

public interface ILoginService {
	public LoginResponseIO login(LoginRequestIO loginIO);
}
