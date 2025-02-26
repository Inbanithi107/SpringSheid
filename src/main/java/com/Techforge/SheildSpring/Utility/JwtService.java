package com.Techforge.SheildSpring.Utility;

import java.util.Date;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import com.Techforge.SheildSpring.DTO.UserDetails;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	
	private String SECRET_KEY;
	
	private int expiration;
	
	public JwtService(String SECRET_KEY, int expiration) {
		this.SECRET_KEY = SECRET_KEY;
		this.expiration = expiration;
	}
	
	public void init(String secret_key, int expire) {
		this.SECRET_KEY = secret_key;
		this.expiration = expire;
	}
	
	public JwtService() {
		
	}
	
	public SecretKey getSigningKey() {
		
		byte[] keyBytes = Decoders.BASE64URL.decode(SECRET_KEY);
		return Keys.hmacShaKeyFor(keyBytes);
		
	}
	
	public Claims extrartAllClaims(String token) {
		
		return Jwts.parser().verifyWith(getSigningKey()).build().parseSignedClaims(token).getPayload();
		
	}
	
	public <T> T extractClaim(String token, Function<Claims, T> resolver) {
		
		Claims claims = extrartAllClaims(token);
		
		return resolver.apply(claims);
		
	}
	
	public String generateToken(UserDetails userDetails) {
		
		String username = userDetails.getUsername();
		
		String token = Jwts.builder().subject(username).issuedAt(new Date(System.currentTimeMillis())).expiration(new Date(System.currentTimeMillis()+expiration)).signWith(getSigningKey()).compact();
		
		return token;
		
	}
	
	private Date extractExpiration(String token) {
		
		return extractClaim(token, Claims::getExpiration);
		
	}
	
	private boolean isTokenExpired(String token) {
		
		return extractExpiration(token).before(new Date());
		
	}
	
	public boolean isValid(String token, UserDetails userDetails) {
		
		String username = extractClaim(token, Claims::getSubject);
		
		return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
		
	}
	
	public String getUsername(String token) {
		return extractClaim(token, Claims::getSubject);
	}

}
