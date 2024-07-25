package com.credmarg.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.credmarg.assignment.IO.AdminIO;
import com.credmarg.assignment.service.IEmployeeService;

@RestController
@RequestMapping("app/emp/")
public class EmployeeController {
	
	@Autowired
	private IEmployeeService employeeService;

	
	@PostMapping("/save")
	public EmployeeIO createEmployee(@RequestBody EmployeeIO employee) {
		EmployeeIO employeeIO = employeeService.saveEmployee(employee);
		return employeeIO;
	}
	
	@GetMapping("/getAllEmployee")
	public List<EmployeeIO> getAllEmployee() {
		List<EmployeeIO> employeeList = employeeService.getAllEmployee();
		return employeeList;
	}

	
}
