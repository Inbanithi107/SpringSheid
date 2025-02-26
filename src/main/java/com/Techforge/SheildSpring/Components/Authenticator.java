package com.Techforge.SheildSpring.Components;

import java.security.PublicKey;

import com.Techforge.SheildSpring.DTO.UserDetails;

public class Authenticator {
	
	private byte[] token;
	
	private PublicKey publicKey;
	
	private UserDetails userDetails;

	public byte[] getToken() {
		return token;
	}

	public void setToken(byte[] token) {
		this.token = token;
	}

	public PublicKey getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(PublicKey publicKey) {
		this.publicKey = publicKey;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	
	

}
