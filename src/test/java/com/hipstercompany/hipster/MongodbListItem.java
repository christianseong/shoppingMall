package com.hipstercompany.hipster;	

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.hipstercompany.hipster.util.MongoDBDatasource;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class MongodbListItem {

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		MongoDBDatasource data = new MongoDBDatasource();
		
		MongoClientURI uri = new MongoClientURI(
				"mongodb+srv://christian:christian@cluster0-5cnsr.mongodb.net/shoppingmall_db?retryWrites=true&w=majority");
		MongoClient mongoClient = new MongoClient(uri);

		// Connect Database and show Collection List 예시) shoppingmall_db
		DB database = mongoClient.getDB("shoppingmall_db");
		
		DBCollection collection = database.getCollection("product");
		
		//원하는 필드값만 뽑을 수 있음
		BasicDBObject allQuery = new BasicDBObject();
		BasicDBObject query = new BasicDBObject();
		query.put("pd_brand",1);
		query.put("pd_name",1);
		query.put("pd_price",1);
		query.put("pd_sex",1);
		
		HashMap<String,String[]> map = new HashMap<String,String[]>();
		
		DBCursor cursor = collection.find(allQuery,query);
		
		String pd_price[] =new String [cursor.count()]; 
		String pd_brand[] =new String [cursor.count()]; 
		//System.out.println( collection.find(allQuery,query).getClass().getName());
		
		  JSONObject jsonobj = null;
		  int i =0;
		  while(cursor.hasNext()) {
			  
			  BasicDBObject obj = (BasicDBObject)cursor.next();
			  jsonobj = new JSONObject();
			  //arry 값은 BasicDBList img = (BasicDBList) obj.get("")
			  jsonobj.put("pd_price", obj.getString("pd_price"));
			  jsonobj.put("pd_brand",obj.getString("pd_brand"));
			  
			  
			  pd_brand[i]=(String)jsonobj.get("pd_brand");
			  pd_price[i]=(String) jsonobj.get("pd_price");
			  i++;
			 
		  }
		  map.put("pd_price", pd_price);
		  map.put("pd_brand", pd_brand);
		 System.out.println(map.get("pd_price")[0]);
		 System.out.println(map.get("pd_price")[1]);
		 System.out.println(map.get("pd_price")[2]);
		 
		 System.out.println(map.get("pd_brand")[0]);
		 System.out.println(map.get("pd_brand")[1]);
		
		/*
		 * String json
		 * ="{\"_id\": {\"$oid\": \"5ee810d2f241554875d3ca37\"}, \"pd_brand\": \"TWN\", \"pd_name\": \"[패키지]아이스버그 반팔 STST3279 + 스플래쉬 반팔 STST3278 \", \"pd_sex\": \"남\", \"pd_price\": {\"$numberLong\": \"47800\"}}"
		 * ;
		 * 
		 * JSONParser jsonParse = new JSONParser(); JSONObject jsonObj =
		 * (JSONObject)jsonParse.parse(json); JSONArray array =
		 * (JSONArray)jsonObj.get("pd_brand");
		 * 
		 * System.out.println(jsonObj.get("pd_price"));
		 * System.out.println(jsonObj.get("pd_brand"));
		 * System.out.println(jsonObj.get("pd_name"));
		 * 
		 * 
		 * HashMap<String,Object> map = new HashMap<String,Object>();
		 */
		 
	}

}
