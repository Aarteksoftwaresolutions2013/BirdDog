package com.birddog.configuration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.birddog.util.IConstant;

/**
 * 
 * @author Aartek
 *
 */
public class LoggingInterceptor implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
					throws Exception {

		if (SecurityContextHolder.getContext().getAuthentication().getPrincipal()
						.equals(IConstant.USER_ROLE_AMONYMOUSE)) {

			response.sendRedirect(IConstant.HOME);

			return false;
		}

		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
					ModelAndView modelAndView) throws Exception {
		
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
					throws Exception {
		
	}
}
