package com.thornBird.sbdt.modules.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thornBird.sbdt.modules.test.entity.Country;
import com.thornBird.sbdt.modules.test.service.CountryService;

@RestController
@RequestMapping("/api")
public class CountryController {

	@Autowired
	private CountryService countryService;
	
	@RequestMapping("/country/{countryId}")
	public Country getCountryByConutryId(@PathVariable int countryId){
		return countryService.getCountryByConutryId(countryId);
	}
	
	@RequestMapping("/country")
	public Country getCountryByCountryName(@RequestParam String countryName) {
		return countryService.getCountryByCountryName(countryName);
	}
	
}
