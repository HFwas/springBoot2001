package com.HFwas.scProduct.modules.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {
	
	@RequestMapping("/testDesc")
	public String productDesc(){
		return "Product Desc";
	}
}
