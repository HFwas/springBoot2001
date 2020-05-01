package com.thornBird.sbdt.modules.account.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.thornBird.sbdt.modules.account.entity.User;

@Mapper
public interface UserDao {
	
	@Select("select * from user where user_id = #{userId}")
	User getUserByUserId(int userId);
	
	@Select("select * from user where user_name =#{userName} and password =#{password}")
	User getUserByUser(@Param("userName") String userName,@Param("password") String password);
	
	@Insert("insert into user (user_id, user_name, password, create_date) "
			+ "values (#{userId}, #{userName}, #{password}, #{createDate})")
	@Options(useGeneratedKeys = true, keyColumn = "user_id" , keyProperty="userId")
	User insertUserByUser(User user);
}
