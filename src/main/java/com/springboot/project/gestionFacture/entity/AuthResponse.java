package com.springboot.project.gestionFacture.entity;

import java.util.Date;

public class AuthResponse {
	private final User user;
	private final String jwt;
	private final Date expirationDate;
	public AuthResponse(User user,String jwt) {
		this.jwt=jwt;
		this.user=user;
		this.expirationDate=new Date(System.currentTimeMillis()+3600000);
	}
	public String getJwt() {
		return jwt;
	}
	public User getUser() {
		return user;
	}
	public Date getExpirationDate() {
		return expirationDate;
	}
	
}
