package com.hipstercompany.hipster;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Base64;

public class SerializeTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		MemberTest member =new MemberTest("º∫¿Á»£","christian199@naver.com",24);
		byte[] serializedMember;
		try(ByteArrayOutputStream baos =new ByteArrayOutputStream()){
			try(ObjectOutputStream oos = new ObjectOutputStream(baos)){
				oos.writeObject(member);
				
				serializedMember= baos.toByteArray();
				
			}
		}
		
		System.out.println(Base64.getEncoder().encodeToString(serializedMember));
		
		
		String base64Member = Base64.getEncoder().encodeToString(serializedMember);
		byte[] serialized = Base64.getDecoder().decode(base64Member);
		
		try(ByteArrayInputStream bais =new ByteArrayInputStream(serializedMember)){
			try(ObjectInputStream ois = new ObjectInputStream(bais)){
				
				Object objectMember = ois.readObject();
				MemberTest membertest = (MemberTest)objectMember;
				
				System.out.println(membertest);
				
			}
		}
		
	}

}
