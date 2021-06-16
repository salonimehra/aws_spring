package com.cognizant.springlearn.DAO;

import java.util.ArrayList;

import org.codehaus.plexus.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.service.EmployeeServices;

@ControllerAdvice
public class EmployeeDao {
	private ArrayList<Employee>EMPLOYEE_LIST=new ArrayList<Employee>();
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServices.class);
	
	public ArrayList<Employee> employeeList(){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		Employee employee1 = (Employee) context.getBean("employement1", Employee.class);
		EMPLOYEE_LIST.add(employee1);
		
		 context = new ClassPathXmlApplicationContext("employee.xml");
		Employee employee2 = (Employee) context.getBean("employement2", Employee.class);
		EMPLOYEE_LIST.add(employee2);
		
		 context = new ClassPathXmlApplicationContext("employee.xml");
		Employee employee3 = (Employee) context.getBean("employement3", Employee.class);
		EMPLOYEE_LIST.add(employee3);
		
		 context = new ClassPathXmlApplicationContext("employee.xml");
		Employee employee4 = (Employee) context.getBean("employement4", Employee.class);
		EMPLOYEE_LIST.add(employee4);
		
		return EMPLOYEE_LIST;
	}
}
