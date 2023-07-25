package com.messaging;

public class LoginResponse {
	
	private boolean login;
	
	private User user;

	
	/*
	 * getters and setters;
	 */
	public boolean isLogin() {
		return login;
	}

	public void setLogin(boolean login) {
		this.login = login;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
