package com.thornBird.sbdt.modules.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.omg.CORBA.INTERNAL;
import org.springframework.stereotype.Repository;

import com.thornBird.sbdt.modules.test.entity.City;

//@Repository
@Mapper
public interface CityDao {
	
	@Select("select * from m_city where country_id = #{countryId}")
	List<City> getCitiesByCountryId(int countryId);
	
	List<City> getCitiesByCountryId2(int countryId);
}
