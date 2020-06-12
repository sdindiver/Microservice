package com.front.exceptions.resolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

public class FrontEndExceptionResolver implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		ModelAndView model = new ModelAndView();
        model.setView(new MappingJackson2JsonView());

		if(ex instanceof HttpMessageNotReadableException) {
	        model.addObject("exception", "Invalid Json");
	        return model;
		}
        model.addObject("exception", "Unknown Reason");

		return model;
		
	}

}
