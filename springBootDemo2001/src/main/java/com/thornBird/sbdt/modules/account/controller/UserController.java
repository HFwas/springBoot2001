package com.thornBird.sbdt.modules.account.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thornBird.sbdt.modules.account.entity.User;
import com.thornBird.sbdt.modules.account.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/*
	 * 127.0.0.1/api/user/1
	 */
	@RequestMapping("/user/{userId}")
	public User getUserByUserId(@PathVariable int userId) {
		return userService.getUserByUserId(userId);
	}
	
	/*
	 * 127.0.0.1/api/user?userName=程咬金&password=123
	 */
	@RequestMapping("/user")
	public User getUserByUser(@RequestParam(required= false) String userName,
			@RequestParam(required = false) String password) {
		return userService.getUserByUser(userName, password);
	}
	
	/*
	 * 127.0.0.1/api/user
	 */
	@PostMapping(value="/user",consumes="application/json")
	public User insertUserByUser(@RequestBody User user) {
		return userService.insertUserByUser(user);
	}
	
}
