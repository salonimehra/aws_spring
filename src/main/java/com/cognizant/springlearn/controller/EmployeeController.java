package com.cognizant.springlearn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.service.EmployeeServices;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class EmployeeController {
	@Autowired
	private EmployeeServices employeeServices;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeServices.employeeList();
	}
	
}
