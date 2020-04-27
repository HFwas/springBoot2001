package com.thornBird.sbdt.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebFilter(filterName="parameterFilter",urlPatterns="/**")
public class ParameterFilter implements Filter {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(ParameterFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		
		HttpServletRequestWrapper wrapper = new HttpServletRequestWrapper(httpServletRequest) {
			
			@Override
			public String getParameter(String name) {
				String value = httpServletRequest.getParameter(name);
				if (StringUtils.isNotBlank(value)) {
					//value != null && value != ""
					return value.replaceAll("fuck", "***");
				}
				return super.getParameter(name);
			}
			
			@Override
			public String[] getParameterValues(String name) {
				String[] values = httpServletRequest.getParameterValues(name);
				if (values != null && values.length >0) {
					/*
					 * replaceAll参数是regex，即基于规则表达式的替换
					 */
					values[0] = values[0].replaceAll("fuck", "***");
					return values;
				}
				return super.getParameterValues(name);
			}
		};
		chain.doFilter(wrapper, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		LOGGER.debug("init ParameterFilter");
		Filter.super.init(filterConfig);
	}
	
	@Override
	public void destroy() {
		LOGGER.debug("destory ParameterFilter");
		Filter.super.destroy();
	}
}
