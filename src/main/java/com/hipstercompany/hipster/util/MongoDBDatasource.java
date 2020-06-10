package com.hipstercompany.hipster.util;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class MongoDBDatasource {
		public static void main(String [] args) {
			MongoClientURI uri = new MongoClientURI("mongodb+srv://christian:christian@cluster0-5cnsr.mongodb.net/shoppingmall_db?retryWrites=true&w=majority");
			MongoClient mongoClient = new MongoClient(uri);
			
			
			
			DB database = mongoClient.getDB("shoppingmall_db");
			
			List<String> databases = new ArrayList<String>();
			for (String databaseName :mongoClient.listDatabaseNames()) {
				databases.add(databaseName);
			}
			
			DBCollection dbCollection = (DBCollection) database.getCollection("member");
			
			DBCursor cursor = dbCollection.find();
			while(cursor.hasNext()) {
				System.out.println(cursor.next());
			}
		}
	
}