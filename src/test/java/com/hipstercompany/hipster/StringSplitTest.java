package com.hipstercompany.hipster;

public class StringSplitTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String email = "christian199@naver.com";
		String array[] =new String[2];
		array=email.split("@");
		System.out.println(array[0]);
	}

}
