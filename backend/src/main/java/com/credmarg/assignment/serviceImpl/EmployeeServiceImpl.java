package com.credmarg.assignment.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

import com.credmarg.assignment.controller.EmployeeIO;
import com.credmarg.assignment.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private InMemoryUserDetailsManager inMemoryUserDetailsManager;
	
	@Autowired
    private PasswordEncoder passwordEncoder;

	private Map<String, EmployeeIO> employeeDetailsMap = new HashMap<>();
	private Map<String, List<EmployeeIO>> adminEmployeeMap = new HashMap<>();

	@Override
	public EmployeeIO saveEmployee(EmployeeIO employee) {
		UserDetails user = User.withUsername(employee.getEmail()).password("{noop}"+employee.getPassword())
				.authorities("EMPLOYEE").build();
		inMemoryUserDetailsManager.createUser(user);
		employeeDetailsMap.put(employee.getEmail(), employee);
		return employee;
	}

	public void alignAdmin(EmployeeIO employee, String adminName) {
		employee.setAdminName(adminName);
        adminEmployeeMap.putIfAbsent(adminName, new ArrayList<>());
        adminEmployeeMap.get(adminName).add(employee);
	}

	@Override
	public List<EmployeeIO> getAllEmployee() {
		String adminName  = SecurityContextHolder.getContext().getAuthentication().getName();
		return adminEmployeeMap.getOrDefault(adminName, new ArrayList<>());
	}

}
