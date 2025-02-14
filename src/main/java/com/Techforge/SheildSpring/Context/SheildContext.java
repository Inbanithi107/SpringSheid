package com.Techforge.SheildSpring.Context;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.Techforge.SheildSpring.Components.CorsConfigurer;
import com.Techforge.SheildSpring.Core.Configuration.SecurityBuilder;

@Configuration
public class SheildContext {
	
	private CorsConfigurer corsconfigured;
	
	private SecurityBuilder securityBuilder;
	
	private SheildContext context ;

	public CorsConfigurer getCorsconfigured() {
		return corsconfigured;
	}

	public void setCorsconfigured(CorsConfigurer corsconfigured) {
		this.corsconfigured = corsconfigured;
	}

	public SecurityBuilder getSecurityBuilder() {
		return securityBuilder;
	}

	public void setSecurityBuilder(SecurityBuilder securityBuilder) {
		this.securityBuilder = securityBuilder;
	}
	
	public void setContext(SheildContext context) {
		this.context = context;
	}

	public SheildContext getInstance() {
		if(this.context==null) {
			return new SheildContext();
		}else {
			return this.context;
		}
	}
	

}
