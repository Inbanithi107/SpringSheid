package com.Techforge.SheildSpring.Components;

public class JwtConfigurer {
	
	private String Secret_key;
	
	private int expire;
	
	private String pattern;

	public String getSecret_key() {
		return Secret_key;
	}

	public void setSecret_key(String secret_key) {
		Secret_key = secret_key;
	}

	public int getExpire() {
		return expire;
	}

	public void setExpire(int expire) {
		this.expire = expire;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	
	

}
