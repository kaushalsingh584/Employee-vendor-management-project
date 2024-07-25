package com.credmarg.assignment.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.credmarg.assignment.IO.AdminIO;

public interface IAdminService {
	
	public AdminIO saveAdmin(AdminIO admin);
	
	public UserDetails getAllAdmins();

	public AdminIO getAdminbyUsername(String username);
	

}
