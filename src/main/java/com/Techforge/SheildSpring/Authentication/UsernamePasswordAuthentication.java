package com.Techforge.SheildSpring.Authentication;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;

import com.Techforge.SheildSpring.DTO.UserDetails;
import com.Techforge.SheildSpring.Utility.TokenGenerator;

public class UsernamePasswordAuthentication {
	
	private UserDetails userDetails;
	TokenGenerator tokenGenerator = new TokenGenerator();
	public UsernamePasswordAuthentication(UserDetails details) {
		this.userDetails = details;
		try {
			tokenGenerator.generateToken(details);
		} catch (InvalidKeyException | NoSuchAlgorithmException | InvalidAlgorithmParameterException
				| SignatureException e) {
			e.printStackTrace();
		}
		
	}
	
	

}
