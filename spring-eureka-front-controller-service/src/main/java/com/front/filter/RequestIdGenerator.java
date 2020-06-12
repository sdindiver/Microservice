package com.front.filter;

import java.util.UUID;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;


@Component
public class RequestIdGenerator extends OncePerRequestFilter {

    private  String responseHeader;
    private  String requestHeader= "requestId";;
    @Override
    protected void doFilterInternal(final HttpServletRequest request, final HttpServletResponse response, final FilterChain chain)
        throws java.io.IOException, ServletException {
        try {
            String token;
            if (!StringUtils.isEmpty(requestHeader) && !StringUtils.isEmpty(request.getHeader(requestHeader))) {
                token = request.getHeader(requestHeader);
            } else {
                token = UUID.randomUUID().toString().toUpperCase().replace("-", "");
            }
            String clientIpAddress = request.getRemoteAddr();
            if(clientIpAddress != null) {
            	token = clientIpAddress+"_"+token;
            }
            RequestIdThreadLocal.getThreadLocal().set(token);
            if (!StringUtils.isEmpty(responseHeader)) {
                response.addHeader(responseHeader, token);
            }
            chain.doFilter(request, response);
        } finally {
        	response.setHeader("x-requestId", RequestIdThreadLocal.getThreadLocal().get());
            RequestIdThreadLocal.getThreadLocal().remove();
        }
    }
}