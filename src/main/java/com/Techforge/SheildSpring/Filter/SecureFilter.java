package com.Techforge.SheildSpring.Filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.Techforge.SheildSpring.Context.SheildContext;
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
	
	private final String HEADER_MESSAGE = "Required header is not availbale in your request";
	
	
	private final SecurityBuilder securityBuilder;
	
	private final ApiTools tools;
	
	public SecureFilter(SecurityBuilder builder) {
		this.securityBuilder=builder;
		this.tools = new ApiTools();
	}
	
	public SecureFilter(ApiTools tools) {
		this.securityBuilder = new SecurityBuilder();
		this.tools = tools;
	}

	
	
	public SecureFilter() {
		this.securityBuilder = new SecurityBuilder();
		this.tools = new ApiTools();
		
	}
	

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		tools.init(securityBuilder);
		
		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		response.setHeader("Access-Control-Allow-Headers", "*");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            return;
        }
		if(tools.verifyOrigin(request)) {//1 context initializer
			if(tools.verifyMethod(request)) {//2 method verifier
				if(tools.verifyRequiredheaders(request)) {//3 required header
					filterChain.doFilter(request, response);
				}else {
					response.setStatus(403);
					ErrorResponse errorsponse = new ErrorResponse(HEADER_MESSAGE, 403);
					response.getWriter().write("<h1>"+errorsponse.toString()+"</h1>");
				}
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
