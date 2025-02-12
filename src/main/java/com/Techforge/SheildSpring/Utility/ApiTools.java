package com.Techforge.SheildSpring.Utility;

import org.springframework.stereotype.Service;

import com.Techforge.SheildSpring.Core.Configuration.SecurityBuilder;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class ApiTools {
	
	 private final String ORIGIN = "Origin";
	
	public boolean verifyOrigin(SecurityBuilder builder, HttpServletRequest request) {
		for(String path : builder.getCorsConfigurer().getAllowedOrigins()) {
			
			if(path.equals(request.getHeader(ORIGIN))) {
				return true;
			}
		}
		return false;
	}

}
