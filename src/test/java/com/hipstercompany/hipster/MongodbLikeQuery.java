package com.hipstercompany.hipster;

import java.util.ArrayList;
import java.util.List;

import com.hipstercompany.hipster.util.MongoDBDatasource;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class MongodbLikeQuery {
	public static void main(String[] args) {
		MongoDBDatasource data = new MongoDBDatasource();

		MongoClientURI uri = new MongoClientURI(
				"mongodb+srv://christian:christian@cluster0-5cnsr.mongodb.net/shoppingmall_db?retryWrites=true&w=majority");
		MongoClient mongoClient = new MongoClient(uri);

		// Connect Database and show Collection List 예시) shoppingmall_db
		DB database = mongoClient.getDB("shoppingmall_db");

		DBCollection collection = database.getCollection("product");
		
		
		BasicDBObject allQuery = new BasicDBObject();
		//BasicDBObject query = new BasicDBObject();
		
		
		
		//mysql 에서 like와 
		String tagName = "여";

		List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
		
		obj.add(new BasicDBObject("pd_brand",java.util.regex.Pattern.compile(tagName)));
		obj.add(new BasicDBObject("pd_sex",java.util.regex.Pattern.compile(tagName)));
		
		
		//query.append("pd_brand",java.util.regex.Pattern.compile(tagName));
		//query.put("pd_name",java.util.regex.Pattern.compile(tagName));
		//query.append("pd_sex",java.util.regex.Pattern.compile(tagName));
		//query.put("pd_color",java.util.regex.Pattern.compile(tagName));
		//query.put("pd_size",java.util.regex.Pattern.compile(tagName));
		
		
		allQuery.put("$or",obj);
		

		DBCursor db =  collection.find(allQuery);

		while(db.hasNext()) {
			System.out.println(db.next());
		}
		
		

	}
}
