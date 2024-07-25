package com.credmarg.assignment.service;

import java.util.List;

import com.credmarg.assignment.controller.EmployeeIO;

public interface IEmployeeService {

	public EmployeeIO saveEmployee(EmployeeIO employee);
	
	public List<EmployeeIO> getAllEmployee();
}
