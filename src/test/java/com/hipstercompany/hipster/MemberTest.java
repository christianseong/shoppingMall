package com.hipstercompany.hipster;

import java.io.Serializable;

public class MemberTest implements Serializable{
	private String name;
	private String email;
	private int age;
	
	
	public MemberTest(String name, String email, int age) {
		super();
		this.name = name;
		this.email = email;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return String.format("Member{name='%s', email='%s', age='%s'}", name, email, age);
	}
	

}
