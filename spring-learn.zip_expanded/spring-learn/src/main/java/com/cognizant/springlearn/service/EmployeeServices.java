package com.cognizant.springlearn.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;


import com.cognizant.springlearn.DAO.EmployeeDao;
import com.cognizant.springlearn.model.Employee;


@Service
public class EmployeeServices {
	
	@Autowired
	private EmployeeDao employeeDao;
	private ArrayList<Employee>list=new ArrayList<Employee>();
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServices.class);
	
	@Transactional
	public ArrayList<Employee> employeeList(){
		return employeeDao.employeeList();
	}
}
