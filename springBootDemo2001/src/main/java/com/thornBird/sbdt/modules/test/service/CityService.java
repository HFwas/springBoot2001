package com.thornBird.sbdt.modules.test.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.thornBird.sbdt.modules.common.Result;
import com.thornBird.sbdt.modules.test.entity.City;

@Service
public interface CityService {
	
	
	List<City> getCitiesByCountryId(int countryId);
	
	PageInfo<City> getCitiesByPage(int currentPage,int pageSize,int countryId);
	
	City getCityByName(String cityName,String  localCityName);
	
	Result<City> insertCity(City city);
	
	Result<City> updateCity(City city);
	
	Result<Object> deleteCity(int cityId);
}
