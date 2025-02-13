package com.Techforge.SheildSpring.Components;

import java.util.List;

import com.Techforge.SheildSpring.DTO.HttpMethod;



public class CorsConfigurer {
	
	private String AllowedOrigin;
	
	private List<HttpMethod> AllowedMethods;
	
	private List<String> AllowedHeaders;
	
	private String RequiredHeader;

	public String getAllowedOrigin() {
		return AllowedOrigin;
	}

	public void setAllowedOrigin(String allowedOrigin) {
		AllowedOrigin = allowedOrigin;
	}

	public List<HttpMethod> getAllowedMethods() {
		return AllowedMethods;
	}

	public void setAllowedMethods(List<HttpMethod> allowedMethods) {
		AllowedMethods = allowedMethods;
	}

	public List<String> getAllowedHeaders() {
		return AllowedHeaders;
	}

	public void setAllowedHeaders(List<String> allowedHeaders) {
		AllowedHeaders = allowedHeaders;
	}

	public String getRequiredHeader() {
		return RequiredHeader;
	}

	public void setRequiredHeader(String requiredHeader) {
		RequiredHeader = requiredHeader;
	}
	
	

}
