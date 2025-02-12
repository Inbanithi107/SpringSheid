package com.Techforge.SheildSpring.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.Techforge.SheildSpring.Components.CorsConfigurer;
import com.Techforge.SheildSpring.Core.Configuration.SecurityBuilder;

@Configuration
public class SecurityConfig {
	
	@Autowired
	private SecurityBuilder builder;
	
	@Bean
	public SecurityBuilder secure() {
		CorsConfigurer configurer = new CorsConfigurer();
		List<String> allowed = new ArrayList<>();
		allowed.add("http://localhost:5173");
		configurer.setAllowedOrigins(Arrays.asList("http://localhost:5173"));
		builder.setCorsConfigurer(configurer);
		return builder;
	}

}
