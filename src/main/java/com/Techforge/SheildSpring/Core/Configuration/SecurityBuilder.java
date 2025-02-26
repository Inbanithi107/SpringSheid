package com.Techforge.SheildSpring.Core.Configuration;

import java.util.List;

import org.springframework.stereotype.Component;

import com.Techforge.SheildSpring.Components.CorsConfigurer;
import com.Techforge.SheildSpring.Components.JwtConfigurer;


@Component
public class SecurityBuilder {
	
	private List<CorsConfigurer> corsConfigurer;
	
	private JwtConfigurer jwtConfigurer;

	public List<CorsConfigurer> getCorsConfigurer() {
		return corsConfigurer;
	}

	public void setCorsConfigurer(List<CorsConfigurer> corsConfigurer) {
		this.corsConfigurer = corsConfigurer;
	}

	public JwtConfigurer getJwtConfigurer() {
		return jwtConfigurer;
	}

	public void setJwtConfigurer(JwtConfigurer jwtConfigurer) {
		this.jwtConfigurer = jwtConfigurer;
	}

	@Override
	public String toString() {
		return "SecurityBuilder [corsConfigurer=" + corsConfigurer + "]";
	}

	
	
	

}
