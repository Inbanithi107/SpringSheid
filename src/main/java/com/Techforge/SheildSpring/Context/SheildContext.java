package com.Techforge.SheildSpring.Context;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.Techforge.SheildSpring.Components.CorsConfigurer;

@Configuration
public class SheildContext {
	
	private CorsConfigurer corsconfigured;

	public CorsConfigurer getCorsconfigured() {
		return corsconfigured;
	}

	public void setCorsconfigured(CorsConfigurer corsconfigured) {
		this.corsconfigured = corsconfigured;
	}
	
	

}
