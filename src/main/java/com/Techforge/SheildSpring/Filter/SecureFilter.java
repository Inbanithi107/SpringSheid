package com.Techforge.SheildSpring.Filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.Techforge.SheildSpring.Core.Configuration.SecurityBuilder;
import com.Techforge.SheildSpring.DTO.ErrorResponse;
import com.Techforge.SheildSpring.Exception.OriginException;
import com.Techforge.SheildSpring.Utility.ApiTools;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecureFilter extends OncePerRequestFilter{
	
	private final String ORIGIN_MESSAGE = "This origin is not allowed to access the api";
	
	private final String METHOD_MESSAGE = "This origin is not allowed to the requested method";
	
	@Autowired
	private SecurityBuilder securityBuilder;
	
	@Autowired
	private ApiTools tools;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		tools.init(securityBuilder);
		
		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		if(tools.verifyOrigin(request)) {//1 context initializer
			if(tools.verifyMethod(request)) {//2 method verifier
				filterChain.doFilter(request, response);
			}else {//2
				response.setStatus(403);
				ErrorResponse errresponse = new ErrorResponse(METHOD_MESSAGE, 403);
				response.getWriter().write("<h1>"+errresponse.toString()+"</h1>");
			}
		}else {//1
			response.setStatus(403);
			ErrorResponse errresponse = new ErrorResponse(ORIGIN_MESSAGE, 403);
			response.getWriter().write("<h1>"+errresponse.toString()+"</h1>");
		}
		
	}

}
