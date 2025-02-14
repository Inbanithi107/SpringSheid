package com.Techforge.SheildSpring.Core.Configuration;

import java.util.List;

import org.springframework.stereotype.Component;

import com.Techforge.SheildSpring.Components.CorsConfigurer;


@Component
public class SecurityBuilder {
	
	private List<CorsConfigurer> corsConfigurer;

	public List<CorsConfigurer> getCorsConfigurer() {
		return corsConfigurer;
	}

	public void setCorsConfigurer(List<CorsConfigurer> corsConfigurer) {
		this.corsConfigurer = corsConfigurer;
	}

	@Override
	public String toString() {
		return "SecurityBuilder [corsConfigurer=" + corsConfigurer + "]";
	}

	
	
	

}
