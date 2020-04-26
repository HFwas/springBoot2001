package com.thornBird.sbdt.modules.test.service.Impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.thornBird.sbdt.modules.common.Result;
import com.thornBird.sbdt.modules.common.Result.ResultEnum;
import com.thornBird.sbdt.modules.test.dao.CityDao;
import com.thornBird.sbdt.modules.test.entity.City;
import com.thornBird.sbdt.modules.test.service.CityService;


@Service
public class CityServiceImpl implements CityService{
	
	@Autowired
	private CityDao cityDao;
	
	@Override
	public List<City> getCitiesByCountryId(int countryId) {
		List<City> cities =cityDao.getCitiesByCountryId(countryId);
		return cities;
	}

	@Override
	public PageInfo<City> getCitiesByPage(int currentPage, int pageSize, int countryId) {
		PageHelper.startPage(currentPage, pageSize);
		List<City> list = cityDao.getCitiesByCountryId(countryId);
		/*list.stream().map( item ->{
			item.setCityName( item.getCityName() +" -- ");
			return item;
		}).collect(Collectors.toList());*/
		return new PageInfo<City>(list);
	}

	@Override
	public City getCityByName(String cityName, String localCityName) {
		List<City> cities = Optional.ofNullable(cityDao.getCityByName2(cityName, localCityName))
				.orElse(Collections.emptyList());
		return cities.isEmpty() ? null: cities.get(0);
	}

	@Override
	public Result<City> insertCity(City city) {
		Result<City> result = new Result<>(ResultEnum.SUCCESS.status,"insert success!");
		try {
			cityDao.insertCity(city);
			result.setObject(city);
		} catch (Exception e) {
			result.setStatus(ResultEnum.FAILD.status);
			result.setMessage(e.getMessage());
		}
		return result;
	}

	@Override
//	
	public Result<City> updateCity(City city) {
		Result<City> result = new Result<>(ResultEnum.SUCCESS.status,"update success!");
		try {
			cityDao.updateCity(city);
			result.setObject(city);
			int i= 1/ 0;
		} catch (Exception e) {
			result.setStatus(ResultEnum.FAILD.status);
			result.setMessage(e.getMessage());
		}
		return result;
	}

	@Override
	public Result<Object> deleteCity(int cityId) {
		Result<Object> result = new Result<>(ResultEnum.SUCCESS.status,"Delete success!");
		try {
			cityDao.deleteCity(cityId);
		} catch (Exception e) {
			result.setStatus(ResultEnum.FAILD.status);
			result.setMessage(e.getMessage());
		}
		return result;
	}
	

	
}
