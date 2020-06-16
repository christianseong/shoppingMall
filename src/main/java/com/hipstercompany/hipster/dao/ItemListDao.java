package com.hipstercompany.hipster.dao;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hipstercompany.hipster.util.MongoDBDatasource;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

@Component
public class ItemListDao {
	MongoDBDatasource mongodb;

	public ItemListDao() {

	}

	public ItemListDao(MongoDBDatasource mongo) {
		this.mongodb = mongo;
	}
	//product 연결 코드 시작
	MongoDBDatasource data = new MongoDBDatasource();

	MongoClientURI uri = new MongoClientURI(
			"mongodb+srv://christian:christian@cluster0-5cnsr.mongodb.net/shoppingmall_db?retryWrites=true&w=majority");
	MongoClient mongoClient = new MongoClient(uri);

	// Connect Database and show Collection List 예시) shoppingmall_db
	DB database = mongoClient.getDB("shoppingmall_db");

	DBCollection collection = database.getCollection("product");
	//product 연결 코드 끝
	
	//상의 메인 가져오기
	public HashMap<String, Object> getTopMain() {
		BasicDBObject allQuery = new BasicDBObject();
		BasicDBObject query = new BasicDBObject();
		query.put("pd_brand", 1);
		query.put("pd_name", 1);
		query.put("pd_price", 1);
		query.put("pd_sex", 1);
		query.put("pd_image_thumnail",1);

		HashMap<String, Object> map = new HashMap<String, Object>();
		DBCursor cursor = collection.find(allQuery, query);

		int cursor_count = cursor.count();
		String pd_price[] = new String[cursor.count()];
		String pd_brand[] = new String[cursor.count()];
		String pd_name[] = new String[cursor.count()];
		String pd_sex[] = new String[cursor.count()];
		String pd_image_thumnail[] = new String[cursor.count()];

		JSONObject jsonobj = null;
		int i = 0;
		while (cursor.hasNext()) {

			BasicDBObject obj = (BasicDBObject) cursor.next();
			jsonobj = new JSONObject();
			// arry 값은 BasicDBList img = (BasicDBList) obj.get("")
			jsonobj.put("pd_price", obj.getString("pd_price"));
			jsonobj.put("pd_brand", obj.getString("pd_brand"));
			
			jsonobj.put("pd_name", obj.getString("pd_name"));
			jsonobj.put("pd_sex", obj.getString("pd_sex"));
			jsonobj.put("pd_image_thumnail", obj.getString("pd_image_thumnail"));

			pd_brand[i] = (String) jsonobj.get("pd_brand");
			pd_price[i] = (String) jsonobj.get("pd_price");
			pd_name[i] = (String) jsonobj.get("pd_name");
			pd_sex[i] = (String) jsonobj.get("pd_sex");
			pd_image_thumnail[i]= (String) jsonobj.get("pd_image_thumnail");
			i++;

		}
		map.put("cursor_count",cursor_count);
		map.put("pd_price", pd_price);
		map.put("pd_brand", pd_brand);
		map.put("pd_name", pd_price);
		map.put("pd_sex", pd_brand);
		map.put("pd_image_thumnail", pd_image_thumnail);
		return map;
	}

}
