package com.Techforge.SheildSpring.Filter;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.Techforge.SheildSpring.Core.Configuration.SecurityBuilder;
import com.Techforge.SheildSpring.DTO.UserDetails;
import com.Techforge.SheildSpring.Utility.JwtService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	private final JwtService service;
	
	private final SecurityBuilder builder;
	
	public JwtAuthenticationFilter(JwtService service) {
		
		this.service = service;
		this.builder = new SecurityBuilder();
		
	}
	
	public JwtAuthenticationFilter() {
		this.service = new JwtService();
		this.builder = new SecurityBuilder();
		
	}
	
	public JwtAuthenticationFilter(SecurityBuilder builder) {
		this.service = new JwtService();
		this.builder = builder;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		
		service.init(builder.getJwtConfigurer().getSecret_key(), builder.getJwtConfigurer().getExpire());
		
		if(request.getRequestURI().startsWith(builder.getJwtConfigurer().getPattern())) {
			
			String AuthHeader = request.getHeader("Authorization");
			String token = AuthHeader.substring(7);
			if(token==null) {
				return;
			}else {
				String username = service.getUsername(token);
				if(username==null) {
					return;
				}
				
			}
			
		}
		
		filterChain.doFilter(request, response);
		
		
		
	}

}
