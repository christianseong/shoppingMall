package com.hipstercompany.hipster;

import java.text.ParseException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
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
	public void testJsonParsing(){
		
		String jsonData = "{\"Persons\":[{\"name\":\"�����\",\"age\":\"30\",\"��α�\":\"ktko.tistory.com\",\"gender\":\"����\"}, {\"name\":\"��ȫ��\",\"age\":\"31\",\"��α�\":\"����\",\"gender\":\"����\"}, {\"name\":\"������\",\"age\":\"30\",\"��α�\":\"����\",\"gender\":\"����\"}], \"Books\":[{\"name\":\"javascript�Ǹ���\",\"price\":\"10000\"},{\"name\":\"java�Ǹ���\",\"price\":\"15000\"}]}";
		try { 
			JSONParser jsonParse = new JSONParser(); 
			JSONObject jsonObj = (JSONObject)jsonParse.parse(jsonData);  
			JSONArray personArray = (JSONArray) jsonObj.get("Persons");
			for(int i=0; i < personArray.size(); i++) { 
				System.out.println("======== person : " + i + " ========");
				JSONObject personObject = (JSONObject) personArray.get(i); 
				System.out.println(personObject.get("name")); 
				System.out.println(personObject.get("age")); } 
				JSONArray booksArray = (JSONArray) jsonObj.get("Books");
				
		
			for(int i=0; i < booksArray.size(); i++) { 
				System.out.println("======== person : " + i + " ========"); 
				JSONObject bookObject = (JSONObject) booksArray.get(i);
				System.out.println(bookObject.get("name")); 
				System.out.println(bookObject.get("price")); } 
			}catch (org.json.simple.parser.ParseException e) { e.printStackTrace(); }}
}
