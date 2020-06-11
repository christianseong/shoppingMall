package com.hipstercompany.hipster.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.operation.*;
import com.mongodb.util.JSON;

public class MongoDBDatasource {
	public static void main(String[] args) {

		// mongodb_insert(getCollection());
		// mongodb_update(getCollection());
	}

	// DB 연결
	public static DB getDatabase() {
		// Connect to MongoDB
		MongoClientURI uri = new MongoClientURI(
				"mongodb+srv://christian:christian@cluster0-5cnsr.mongodb.net/shoppingmall_db?retryWrites=true&w=majority");
		MongoClient mongoClient = new MongoClient(uri);

		// Connect Database and show Collection List 예시) shoppingmall_db
		DB database = mongoClient.getDB("shoppingmall_db");

		return database;

		/*
		 * //View Database List List<String> databases = mongoClient.getDatabaseNames();
		 * 
		 * System.out.println("=======Database List======="); int dbnum =1; for(String
		 * dbName :databases) { System.out.println(dbnum+"."+dbName); dbnum++; }
		 * System.out.println(); Set<String> collections =
		 * database.getCollectionNames();
		 * System.out.println("Databse: "+"shoppingmall_db"); int colNum=1; for(String
		 * colName: collections) {
		 * System.out.println("Collection Number "+colNum+" is "+colName); colNum++; }
		 */
	}

	// Collection 연결
	public static DBCollection getCollection() {
		return getDatabase().getCollection("member");
	}

	// Mongodb insert
	public static void mongodb_insert(DBCollection dbCollection) {
		// MongoDB insert document 활용예시
		// 1번 BasicDBObject를 활용한 insert
		BasicDBObject document = new BasicDBObject();
		document.put("mem_id", "test01");

		// 1번 Insert Data
		dbCollection.insert(document);

		// 2번 BasicDBObjectBuilder를 활용한 insert 특징 2개 이상 넣을 수 있다.
		BasicDBObjectBuilder documentBuilder = BasicDBObjectBuilder.start().add("mem_id", "test02").add("mem_name",
				"test02");
		BasicDBObjectBuilder documentBuilderDetail = BasicDBObjectBuilder.start().add("mem_sex", "men")
				.add("mem_favorite", "movie").add("hobby", "movie");
		documentBuilder.add("mem_personality", documentBuilderDetail.get());

		// 2번 Insert Data
		dbCollection.insert(documentBuilder.get());

		// 3번 BasicDBObject 와 Map의 혼용
		Map<String, Object> documentMap = new HashMap<String, Object>();
		documentMap.put("one", "data03");
		documentMap.put("two", "Map");

		Map<String, Object> documentMapDetail = new HashMap<String, Object>();
		documentMapDetail.put("three-one", 97);
		documentMapDetail.put("three-two", "Map");
		documentMapDetail.put("three-three", true);

		documentMap.put("three", documentMapDetail);

		// 3번 Insert Data
		dbCollection.insert(new BasicDBObject(documentMap));

		// 4번 json을 이용한 insert
		String json = "{'one':'data04','two':'json','three':{'three-one':96,'three-two':'json'}}";
		DBObject dbObject = (DBObject) JSON.parse(json);

		// 4번 Insert Data
		dbCollection.insert(dbObject);

		// insert 확인 코드
		DBCursor cursorBuilder = dbCollection.find();
		while (cursorBuilder.hasNext()) {
			System.out.println(cursorBuilder.next());
		}
	}

	// Mongodb update
	public static void mongodb_update(DBCollection dbCollection) {

		// $set으로 하나의 document 값을 수정 할 때
		BasicDBObject updateQuery = new BasicDBObject();
		updateQuery.put("Testting new number", 123124);
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("mem_id", "test01");

		BasicDBObject updateObject = new BasicDBObject();
		updateObject.put("$set", updateQuery);

		dbCollection.update(searchQuery, updateObject);

		// $Set으로 다중 선택 업데이트 updateMulti를 써야 한다
		BasicDBObject searchQuery2 = new BasicDBObject();
		searchQuery.append("mem_id", "test01");

		BasicDBObject updateQuery2 = new BasicDBObject();
		updateQuery.append("$set", new BasicDBObject().append("change", "new change"));

		dbCollection.updateMulti(searchQuery2, updateQuery2);
	}
}