package com.thornBird.sbdt.modules.account.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.thornBird.sbdt.modules.account.entity.User;

@Service
public interface UserService {
	
	User getUserByUserId(int userId);
	
	User getUserByUser(String userName,String password);
	
	User insertUserByUser(User user);
	
	
}
