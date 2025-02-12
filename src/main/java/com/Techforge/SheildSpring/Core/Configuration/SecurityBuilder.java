package com.Techforge.SheildSpring.Core.Configuration;

import org.springframework.stereotype.Component;

import com.Techforge.SheildSpring.Components.CorsConfigurer;


@Component
public class SecurityBuilder {
	
	private CorsConfigurer corsConfigurer;

	public CorsConfigurer getCorsConfigurer() {
		return corsConfigurer;
	}

	public void setCorsConfigurer(CorsConfigurer corsConfigurer) {
		this.corsConfigurer = corsConfigurer;
	}
	
	

}
