package com.thornBird.sbdt.modules.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.thornBird.sbdt.modules.test.entity.City;

@Service
public interface CityService {
	
	
	List<City> getCitiesByCountryId(int countryId);
	
	PageInfo<City> getCitiesByPage(int currentPage,int pageSize,int countryId);
}
