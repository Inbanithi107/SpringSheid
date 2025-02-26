package com.Techforge.SheildSpring.Utility;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.ECGenParameterSpec;

import com.Techforge.SheildSpring.Components.Authenticator;
import com.Techforge.SheildSpring.Context.SecurityContextHolder;
import com.Techforge.SheildSpring.DTO.UserDetails;

public class TokenGenerator {
	
	private final SecurityContextHolder holder;
	
	public TokenGenerator(SecurityContextHolder contextHolder) {
		this.holder = contextHolder;
	}
	
	public TokenGenerator() {
		this.holder = new SecurityContextHolder();
		
	}
	
	public void generateToken(UserDetails details) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, SignatureException {
KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC");
		
		ECGenParameterSpec ecspec = new ECGenParameterSpec("secp256r1");
		
		keyPairGenerator.initialize(ecspec);
		
		KeyPair keypair = keyPairGenerator.generateKeyPair();
		
		PrivateKey privateKey = keypair.getPrivate();
		
		PublicKey publicKey = keypair.getPublic();
		
Signature signature = Signature.getInstance("SHA512withECDSA");
		
		signature.initSign(privateKey);
		
		signature.update(details.toString().getBytes());
		
		byte[] digitalsignature = signature.sign();
		
		Authenticator authenticator = new Authenticator();
		authenticator.setToken(digitalsignature);
		authenticator.setPublicKey(publicKey);
		authenticator.setUserDetails(details);
		holder.setAuthenticator(authenticator);
		
	}
	
	public boolean verifyToken() throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
		byte[] token = holder.getAuthenticator().getToken();
		PublicKey publicKey = holder.getAuthenticator().getPublicKey();
		UserDetails userDetails = holder.getAuthenticator().getUserDetails();
		
Signature signature = Signature.getInstance("SHA512withECDSA");
		
		signature.initVerify(publicKey);
		
		signature.update(userDetails.toString().getBytes());
		
		return signature.verify(token);
	}
	

}
