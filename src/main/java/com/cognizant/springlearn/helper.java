package com.cognizant.springlearn;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class helper {
	
	@Before("execution(* com.cognizant.springlearn.service.EmployeeServices.employeeList())")
	public void log() {
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("###################### Welcome ##############33");
	}
}
