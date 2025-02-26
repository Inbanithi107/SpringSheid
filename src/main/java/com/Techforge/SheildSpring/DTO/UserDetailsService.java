package com.Techforge.SheildSpring.DTO;

public interface UserDetailsService {
	
	UserDetails loadByUsername(String username);

}
