package com.thornBird.sbdt.modules.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.thornBird.sbdt.modules.test.vo.ConfigBean;

@Controller
public class TestController {
	
	
	private static final Logger LOGGER= LoggerFactory.getLogger(TestController.class);
	
	
	@Value("${server.port}")
	private int port;
	@Value("${com.thorn.bird.name}")
	private String name;
	@Value("${com.thorn.bird.age}")
	private int age;
	@Value("${com.thorn.bird.desc}")
	private String desc;
	@Value("${com.thorn.bird.random}")
	private String random;
	
	@Autowired
	private ConfigBean configBean;
	
	/*
	 * http://127.0.0.1/test/log
	 */
	//TRACE<DEBUG<INFO<WARN<ERROR
	@RequestMapping("/test/log")
	@ResponseBody
	public String loggingTest(){
		LOGGER.trace("this is TRACE test");
		LOGGER.debug("this is DEBUG test");
		LOGGER.info("this is INFO test");
		LOGGER.warn("this is WARN test");
		LOGGER.error("this is ERROR test222");
		return "log test ";
	}
	
	/*
	 * http://127.0.0.1/test/config
	 */
	@RequestMapping("/test/config")
	@ResponseBody
	public String configTest(){
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append(port).append("---")
				.append(name).append("---")
				.append(age).append("---")
				.append(desc).append("---").append("---")
				.append(random).append("</br></br>");
		sBuffer.append(configBean.getAge()).append("---")
				.append(configBean.getDesc()).append("---")
				.append(configBean.getName()).append("---")
				.append(configBean.getPort()).append("---")
				.append(configBean.getRandom());
		return sBuffer.toString();
	}
	
	/*
	 * http://127.0.0.1/test/appDesc
	 */
	@RequestMapping("/test/appDesc")
	@ResponseBody
	public String getAppWordDesc(){
		return "hello world";
	}
}
