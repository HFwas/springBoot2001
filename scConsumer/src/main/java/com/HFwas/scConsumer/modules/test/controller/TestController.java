package com.HFwas.scConsumer.modules.test.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class TestController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	/*
	 * http://127.0.0.1:8762/api/testDesc1
	 */
	@RequestMapping("/testDesc1")
	public String testConsumer(){
		String string = restTemplate.getForObject("http://PRODUCT/api/testDesc", String.class);
		return  string+"===========";
	}
}
