package com.hipstercompany.hipster.member;


public class User {

	private String user_email="";
	

	public User(String user_email) {
		super();
		this.user_email = user_email;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	
	
}
