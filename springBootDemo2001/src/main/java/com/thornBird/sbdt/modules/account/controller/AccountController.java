package com.thornBird.sbdt.modules.account.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {
	
	/*
	 * 127.0.0.1/account/login
	 */
	@RequestMapping("/login")
	public String loginPage(){
		return "indexSimple";
	}
	/*
	 * 127.0.0.1/account/register
	 */
	@RequestMapping("/register")
	public String registerPage(){
		return "indexSimple";
	}
}
