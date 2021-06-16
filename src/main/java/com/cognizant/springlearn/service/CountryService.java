package com.cognizant.springlearn.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;


@Service
public class CountryService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);
	
	public Country getCountry(String code){
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		ArrayList<Country> bean = (ArrayList<Country>) context.getBean("countryList");
		ArrayList<Country> countryList = bean;
		LOGGER.debug("Country : {}", countryList.toString());
		for(Country country: countryList) {
			if(country.getCode().equalsIgnoreCase(code))
			return(country);
		}
		throw new CountryNotFoundException();
	}
}
