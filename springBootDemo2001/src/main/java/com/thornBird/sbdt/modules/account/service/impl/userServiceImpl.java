package com.thornBird.sbdt.modules.account.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thornBird.sbdt.modules.account.dao.UserDao;
import com.thornBird.sbdt.modules.account.entity.User;
import com.thornBird.sbdt.modules.account.service.UserService;


@Service
public class userServiceImpl implements UserService {

	@Autowired
	private UserDao  userDao;
	
	@Override
	public User getUserByUserId(int userId) {
		return userDao.getUserByUserId(userId);
	}

	@Override
	public User getUserByUser(String userName, String password) {
		return userDao.getUserByUser(userName, password);
	}


	@Override
	public User insertUserByUser(User user) {
		return userDao.insertUserByUser(user);
	}

	

}
