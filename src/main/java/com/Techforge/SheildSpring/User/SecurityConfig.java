package com.Techforge.SheildSpring.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.Techforge.SheildSpring.Components.CorsConfigurer;
import com.Techforge.SheildSpring.Core.Configuration.SecurityBuilder;
import com.Techforge.SheildSpring.DTO.HttpMethod;

@Configuration
public class SecurityConfig {
	
	@Autowired
	private SecurityBuilder builder;
	
	@Bean
	public SecurityBuilder secure() {
		CorsConfigurer configurer = new CorsConfigurer();
		configurer.setAllowedOrigin("http://localhost:5173");
		configurer.setAllowedMethods(Arrays.asList(HttpMethod.ALL));
		CorsConfigurer config2 = new CorsConfigurer();
		config2.setAllowedOrigin("http://localhost:3000");
		builder.setCorsConfigurer(Arrays.asList(configurer,config2));
		return builder;
	}

}
