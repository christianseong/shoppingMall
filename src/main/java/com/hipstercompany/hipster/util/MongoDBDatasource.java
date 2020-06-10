package com.hipstercompany.hipster.util;

import java.util.List;
import java.util.Set;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class MongoDBDatasource {
		public static void main(String [] args) {
			
			//Connect to MongoDB
			MongoClientURI uri = new MongoClientURI("mongodb+srv://christian:christian@cluster0-5cnsr.mongodb.net/shoppingmall_db?retryWrites=true&w=majority");
			MongoClient mongoClient = new MongoClient(uri);
			
			//View Database List
			List<String> databases = mongoClient.getDatabaseNames();
			
			System.out.println("=======Database List=======");
			int dbnum =1;
			for(String dbName :databases) {
				System.out.println(dbnum+"."+dbName);
				dbnum++;
			}
			System.out.println();
			//Connect Database and show Collection List ¿¹½Ã) shoppingmall_db 
			DB database = mongoClient.getDB("shoppingmall_db");
			Set<String> collections = database.getCollectionNames();
			System.out.println("Databse: "+"shoppingmall_db");
			int colNum=1;
			for(String colName: collections) {
				System.out.println("Collection Number "+colNum+" is "+colName);
				colNum++;
			}
			
			
			DBCollection dbCollection = (DBCollection) database.getCollection("member");
			
			DBCursor cursor = dbCollection.find();
			while(cursor.hasNext()) {
				System.out.println(cursor.next());
			}
		}
	
}