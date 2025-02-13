package com.Techforge.SheildSpring.Utility;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Techforge.SheildSpring.Components.CorsConfigurer;
import com.Techforge.SheildSpring.Context.SheildContext;
import com.Techforge.SheildSpring.Core.Configuration.SecurityBuilder;
import com.Techforge.SheildSpring.DTO.HttpMethod;

import ch.qos.logback.core.joran.spi.HttpUtil.RequestMethod;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class ApiTools {
	
	 private final String ORIGIN = "Origin";
	 
	 private SecurityBuilder securityBuilder;
	 
	 @Autowired
	 private SheildContext context;
	 
	 public void init(SecurityBuilder builder) {
		 this.securityBuilder = builder;
	 }
	
	public boolean verifyOrigin(HttpServletRequest request) {
		for(CorsConfigurer cors : securityBuilder.getCorsConfigurer()) {
			
			String path = cors.getAllowedOrigin();
			
			if(path.equals("*")) {
				return true;
			}
			
			if(path.equals(request.getHeader(ORIGIN))) {
				context.setCorsconfigured(cors);
				return true;
			}
		}
		return false;
	}
	
	public boolean verifyMethod(HttpServletRequest request) {
		
		String requestMethod = request.getMethod();
		
		if(context.getCorsconfigured().getAllowedMethods()==null || context.getCorsconfigured().getAllowedMethods().equals(Arrays.asList(HttpMethod.ALL))) {
			return true;
		}
		
		for(HttpMethod method : context.getCorsconfigured().getAllowedMethods()) {
			if(requestMethod.equals(method.toString())) {
				return true;
			}
		}
		return false;
		
	}

}
