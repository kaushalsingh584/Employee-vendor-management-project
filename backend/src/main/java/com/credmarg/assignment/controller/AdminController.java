package com.credmarg.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.credmarg.assignment.IO.AdminIO;
import com.credmarg.assignment.service.IAdminService;

@RestController
@RequestMapping("app/admin")
public class AdminController {
	
	@Autowired
	private IAdminService adminService;
	
	@PostMapping("/save")
	public AdminIO createAdmin(@RequestBody AdminIO adminIO) {
		AdminIO admin = adminService.saveAdmin(adminIO);
		return admin;
	}
	
	@GetMapping("/getAllAdmin")
	public UserDetails getAllAdmin() {
		UserDetails adminList = adminService.getAllAdmins();
		return adminList;
	}
	
	@GetMapping("/{username}")
	public AdminIO getAdminbyUsername(@PathVariable String username) {
		AdminIO admin = adminService.getAdminbyUsername(username);
		return admin;
	}

}
