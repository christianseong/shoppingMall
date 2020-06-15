package com.hipstercompany.hipster.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.hipstercompany.hipster.util.MongoDBDatasource;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;



@Component
public class UserDao {
	
	
	private MongoDBDatasource mongo;
	
	public UserDao() {
		
	}
	
	public UserDao(MongoDBDatasource mongo) {
		this.mongo=mongo;
	}
	
	
	public void addUser(String mem_email) {
		System.out.println("dao test    " + mem_email);
		
		DBCollection collection =mongo.getCollection();
		
		Map<String, Object> documentMap = new HashMap<String, Object>();
		documentMap.put("mem_id", mem_email);
		
		collection.insert(new BasicDBObject(documentMap));
		
	}
	
	public void getObjectID(String mem_email) {
		
	}
	
	
	public int checkUserId(String mem_email) {
		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("mem_id", mem_email);
		DBCollection collection = mongo.getCollection();
		
		DBCursor cursor3 = collection.find(whereQuery);
		
		int count =cursor3.count();
		
		return count;

	}
}
