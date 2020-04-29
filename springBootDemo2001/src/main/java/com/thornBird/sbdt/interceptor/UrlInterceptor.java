package com.thornBird.sbdt.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class UrlInterceptor implements HandlerInterceptor {
	
	private final  static Logger Logger = LoggerFactory.getLogger(UrlInterceptor.class);

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		Logger.debug("after=======");
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		Logger.debug("post==========");
		
		if (modelAndView == null || modelAndView.getViewName().startsWith("/redirect")) {
			return ;
		}	
		
		String uri= request.getServletPath();
		String template= (String) modelAndView.getModelMap().get("template");
		if (StringUtils.isBlank(template)) {
			// template == null || template == ""
			if (uri.startsWith("/")) {
				uri = uri.substring(1);
			}
			//// ////////////
			modelAndView.getModelMap().put("template", uri);
		}
		
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Logger.debug("pre==========");
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	
}
