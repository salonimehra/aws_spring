package com.cognizant.springlearn;

import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.service.EmployeeServices;


//import com.sun.tools.classfile.StackMap_attribute.stack_map_frame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class SpringLearnApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(SpringLearnApplication.class, args);
		displayDate();
		displayCountry();
		displayCountries();
		
	}
	/*public static void displayDate() {
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
		try {
			Date date=format.parse("31/12/2018");
			System.out.println(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}*/
	
	public static void displayDate() {

		LOGGER.info("START");

		//..

		LOGGER.debug("10/12/1998");

		//..

		LOGGER.info("END");

		}
	
	public static void displayCountry() {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

		Country country = (Country) context.getBean("country", Country.class);

		LOGGER.debug("Country : {}", country.toString());
	}
	
	public static void displayCountries() {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

		ArrayList<Country> bean = (ArrayList<Country>) context.getBean("countryList");
		ArrayList<Country>countryList = bean;

		LOGGER.debug("Country : {}", countryList.toString());
	}
	
}
