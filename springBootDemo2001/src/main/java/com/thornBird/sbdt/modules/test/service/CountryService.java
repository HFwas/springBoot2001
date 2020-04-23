package com.thornBird.sbdt.modules.test.service;

import org.springframework.stereotype.Service;

import com.thornBird.sbdt.modules.test.entity.Country;

@Service
public interface CountryService {

	Country getCountryByConutryId(int countryId);
	
	Country getCountryByCountryName(String countryName);
}
