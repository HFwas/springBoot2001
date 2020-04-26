package com.thornBird.sbdt.filter;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebFilter(filterName="parameterFilter",urlPatterns="/**")
public class ParameterFilter implements Filter {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(ParameterFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		LOGGER.debug("init ParameterFilter");
		Filter.super.init(filterConfig);
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO
		LOGGER.debug("ParameterFilter   ing");
		HttpServletRequest httpServlet = (HttpServletRequest) request;
		
		chain.doFilter(request, response);
	}
	
	@Override
	public void destroy() {
		LOGGER.debug("destroy ParameterFilter");
		Filter.super.destroy();
	}

}
