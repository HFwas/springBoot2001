package com.thornBird.sbdt.modules.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.omg.CORBA.INTERNAL;
import org.springframework.stereotype.Repository;

import com.thornBird.sbdt.modules.common.Result;
import com.thornBird.sbdt.modules.test.entity.City;

import net.sf.jsqlparser.statement.truncate.Truncate;

//@Repository
@Mapper
public interface CityDao {
	
	@Select("select * from m_city where country_id = #{countryId}")
	List<City> getCitiesByCountryId(int countryId);
	
	List<City> getCitiesByCountryId2(int countryId);
	
	@Insert("insert into m_city (city_name, local_city_name, country_id, date_created) "
			+ "values (#{cityName}, #{localCityName}, #{countryId}, #{dateCreated})")
	@Options(useGeneratedKeys = true, keyColumn = "city_id" , keyProperty="cityId")
	void insertCity(City city);
}
