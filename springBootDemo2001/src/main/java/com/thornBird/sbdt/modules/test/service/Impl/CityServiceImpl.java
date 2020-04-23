package com.thornBird.sbdt.modules.test.service.Impl;

import java.awt.event.ItemEvent;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
		/*list.stream().map( item -->{
				item.setCityName
		});*/
		return new PageInfo<City>(list);
	}

	
}
