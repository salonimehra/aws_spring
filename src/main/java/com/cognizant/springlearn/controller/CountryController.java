package com.cognizant.springlearn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.RequestBody;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.SpringLearnApplication;
import com.cognizant.springlearn.service.CountryService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
public class CountryController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);
	
	@Autowired(required=true)
	CountryService countryService;
	
	@RequestMapping(value = "/country",method = RequestMethod.GET)
	public Country getCountryIndia() {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = (Country) context.getBean("country", Country.class);
		LOGGER.debug("Country : {}", country.toString());
		return country;
	}
	
	@GetMapping("/countries")
	public List<Country> getAllCountries() {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

		ArrayList<Country> bean = (ArrayList<Country>) context.getBean("countryList");
		ArrayList<Country>countryList = bean;

		LOGGER.debug("Country : {}", countryList.toString());
		return countryList;
	}
	
	@PostMapping("/countries/{code}")
	public Country getCountry(@PathVariable String code) {
		 return countryService.getCountry(code);
	}
	
	@PutMapping("/countries-update/{code}")
	public List<Country> removeCountry(@PathVariable String code,@Valid @RequestBody Country country){
		// Create validator factory
//		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//		Validator validator = factory.getValidator();
//		// Validation is done against the annotations defined in country bean
//		Set<ConstraintViolation<Country>> violations = validator.validate(country);
//		List<String> errors = new ArrayList<String>();
//		// Accumulate all errors in an ArrayList of type String
//		for (ConstraintViolation<Country> violation : violations) {
//			errors.add(violation.getMessage());
//		}
//		// Throw exception so that the user of this web service receives appropriate error message
//		if (violations.size() > 0) {
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errors.toString());
//		}
		List<Country>countryList= getAllCountries();
		countryList.add(country);
		return countryList;
	}
 
	
}
