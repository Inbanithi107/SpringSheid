package com.Techforge.SheildSpring.Context;

import com.Techforge.SheildSpring.Components.Authenticator;

public class SecurityContextHolder {
	
	private Authenticator authenticator;

	public Authenticator getAuthenticator() {
		return authenticator;
	}

	public void setAuthenticator(Authenticator authenticator) {
		this.authenticator = authenticator;
	}

	public SecurityContextHolder() {
	}

	public SecurityContextHolder(Authenticator authenticator) {
		this.authenticator = authenticator;
	}
	
	

}
