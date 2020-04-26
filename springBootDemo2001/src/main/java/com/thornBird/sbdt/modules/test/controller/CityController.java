package com.thornBird.sbdt.modules.test.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.thornBird.sbdt.modules.common.Result;
import com.thornBird.sbdt.modules.test.entity.City;
import com.thornBird.sbdt.modules.test.service.CityService;

@RestController
@RequestMapping("/api")
public class CityController {
	
	@Autowired
	private CityService cityService;
	
	/*
	 * 127.0.0.1/api/cities?countryId=
	 */
	@RequestMapping("/cities/{countryId}")
	public List<City> getCitiesByCountryId(@PathVariable int countryId) {
		return cityService.getCitiesByCountryId(countryId);
	}
	
	/*
	 * 127.0.0.1/api/cities?currentPage=1&pageSize=10&countryId=522
	 */
	@RequestMapping("/cities")
	public PageInfo<City> getCitiesByPage(@RequestParam int currentPage, 
			@RequestParam int pageSize, @RequestParam int countryId) {
		return cityService.getCitiesByPage(currentPage, pageSize, countryId);
	}
	
	/*
	 * 127.0.0.1/api/city?cityName=Shanghai
	 */
	@RequestMapping("/city")
	City getCityByName(@RequestParam(required = false) String cityName,
			@RequestParam(required = false) String  localCityName){
		return cityService.getCityByName(cityName, localCityName);
	}
	
	/*
	 * 127.0.0.1/city
	 */
	@PostMapping(value="/city",consumes="application/json")
	public Result<City> insertCity(@RequestBody City city) {
		return cityService.insertCity(city);
	}
	
	/*
	 * 127.0.0.1/api/city
	 */
	@PutMapping(value="/city",consumes="application/x-www-form-urlencoded")
	public Result<City> updateCity(@ModelAttribute City city) {
		return cityService.updateCity(city);
	}
	
	@DeleteMapping("/city/{cityId}")
	public Result<Object> deleteCity(@PathVariable int cityId) {
		return cityService.deleteCity(cityId);
	}
	
}
