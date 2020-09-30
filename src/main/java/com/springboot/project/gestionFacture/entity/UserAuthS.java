package com.springboot.project.gestionFacture.entity;

public class UserAuthS {
	private static User authUser;
	
	public static User getAuthUser() {
		return authUser;
	}

	public static void setAuthUser(User authUser) {
		UserAuthS.authUser = authUser;
	}
	
}
