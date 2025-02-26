package com.Techforge.SheildSpring.Filter;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.Techforge.SheildSpring.Context.SecurityContextHolder;
import com.Techforge.SheildSpring.Utility.TokenGenerator;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthenticationFilter extends OncePerRequestFilter{
	
	private final SecurityContextHolder contextHolder;
	
	private final TokenGenerator generator;
	

	public AuthenticationFilter(SecurityContextHolder contextHolder, TokenGenerator generator) {
		this.contextHolder = contextHolder;
		this.generator = generator;
	}



	public AuthenticationFilter() {
		this.contextHolder = new SecurityContextHolder();
		this.generator = new TokenGenerator();
	}



	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		
		try {
			if(generator.verifyToken()) {
				filterChain.doFilter(request, response);
			}
		} catch (InvalidKeyException | NoSuchAlgorithmException | SignatureException | IOException
				| ServletException e) {
			e.printStackTrace();
		}
		
		return;
		
	}

}
