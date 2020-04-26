package com.thornBird.sbdt.config;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.thornBird.sbdt.filter.ParameterFilter;

@Configuration
@AutoConfigureAfter({WebMvcAutoConfiguration.class})
public class WebMvcConfig {
	
	@Bean
	public FilterRegistrationBean<ParameterFilter>  filterRegistration(){
		FilterRegistrationBean<ParameterFilter> filterRegistrationBean =new FilterRegistrationBean<>();
		filterRegistrationBean.setFilter( new ParameterFilter());
		return filterRegistrationBean;
	}
		
	
}
