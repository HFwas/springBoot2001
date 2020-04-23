package com.thornBird.sbdt.modules.test.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thornBird.sbdt.modules.test.dao.CountryDao;
import com.thornBird.sbdt.modules.test.entity.Country;
import com.thornBird.sbdt.modules.test.service.CountryService;

@Service
public class CountruServiceImpl implements CountryService{
	@Autowired
	private CountryDao countryDao;
	
	@Override
	public Country getCountryByConutryId(int countryId){
		return countryDao.getCountryByConutryId(countryId);
	}

	@Override
	public Country getCountryByCountryName(String countryName) {
		
		return countryDao.getCountryByCountryName(countryName);
	}
	
	
}
