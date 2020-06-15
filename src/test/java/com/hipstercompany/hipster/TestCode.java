package com.hipstercompany.hipster;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Base64;

import org.junit.Test;

import com.hipstercompany.hipster.util.Mem_Level;

public class TestCode {
	@Test
	public void testEnum() {
		String name =Mem_Level.Bronze.getName();
		int level = Mem_Level.Bronze.getLevel();
		System.out.println(name);
		System.out.println(level);
	}
	
	@Test
	public void serialTest() throws IOException {
		MemberTest member =new MemberTest("º∫¿Á»£","christian199@naver.com",24);
		byte[] serializedMember;
		try(ByteArrayOutputStream baos =new ByteArrayOutputStream()){
			try(ObjectOutputStream oos = new ObjectOutputStream(baos)){
				oos.writeObject(member);
				
				serializedMember= baos.toByteArray();
				
			}
		}
		
		System.out.println(Base64.getEncoder().encodeToString(serializedMember));
	}
}
