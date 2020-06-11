package com.hipstercompany.hipster.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.util.JSON;

public class MongoDBDatasource {
	public static void main(String[] args) {

		// mongodb_insert(getCollection());
		// mongodb_update(getCollection());
		// mongodb_find(getCollection());
	}

	// DB ����
	public static DB getDatabase() {
		// Connect to MongoDB
		MongoClientURI uri = new MongoClientURI(
				"mongodb+srv://christian:christian@cluster0-5cnsr.mongodb.net/shoppingmall_db?retryWrites=true&w=majority");
		MongoClient mongoClient = new MongoClient(uri);

		// Connect Database and show Collection List ����) shoppingmall_db
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

	// Collection ����
	public static DBCollection getCollection() {
		return getDatabase().getCollection("member");
	}

	// Mongodb insert
	public static void mongodb_insert(DBCollection dbCollection) {
		// MongoDB insert document Ȱ�뿹��
		// 1�� BasicDBObject�� Ȱ���� insert
		BasicDBObject document = new BasicDBObject();
		document.put("mem_id", "test01");

		// 1�� Insert Data
		dbCollection.insert(document);

		// 2�� BasicDBObjectBuilder�� Ȱ���� insert Ư¡ 2�� �̻� ���� �� �ִ�.
		BasicDBObjectBuilder documentBuilder = BasicDBObjectBuilder.start().add("mem_id", "test02").add("mem_name",
				"test02");
		BasicDBObjectBuilder documentBuilderDetail = BasicDBObjectBuilder.start().add("mem_sex", "men")
				.add("mem_favorite", "movie").add("hobby", "movie");
		documentBuilder.add("mem_personality", documentBuilderDetail.get());

		// 2�� Insert Data
		dbCollection.insert(documentBuilder.get());

		// 3�� BasicDBObject �� Map�� ȥ��
		Map<String, Object> documentMap = new HashMap<String, Object>();
		documentMap.put("one", "data03");
		documentMap.put("two", "Map");

		Map<String, Object> documentMapDetail = new HashMap<String, Object>();
		documentMapDetail.put("three-one", 97);
		documentMapDetail.put("three-two", "Map");
		documentMapDetail.put("three-three", true);

		documentMap.put("three", documentMapDetail);

		// 3�� Insert Data
		dbCollection.insert(new BasicDBObject(documentMap));

		// 4�� json�� �̿��� insert
		String json = "{'one':'data04','two':'json','three':{'three-one':96,'three-two':'json'}}";
		DBObject dbObject = (DBObject) JSON.parse(json);

		// 4�� Insert Data
		dbCollection.insert(dbObject);

		// insert Ȯ�� �ڵ�
		DBCursor cursorBuilder = dbCollection.find();
		while (cursorBuilder.hasNext()) {
			System.out.println(cursorBuilder.next());
		}
	}

	// Mongodb update
	public static void mongodb_update(DBCollection dbCollection) {

		// $set���� �ϳ��� document ���� ���� �� ��
		BasicDBObject updateQuery = new BasicDBObject();
		updateQuery.put("Testting new number", 123124);
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("mem_id", "test01");

		BasicDBObject updateObject = new BasicDBObject();
		updateObject.put("$set", updateQuery);

		dbCollection.update(searchQuery, updateObject);

		// $Set���� ���� ���� ������Ʈ updateMulti�� ��� �Ѵ�
		BasicDBObject searchQuery2 = new BasicDBObject();
		searchQuery.append("mem_id", "test01");

		BasicDBObject updateQuery2 = new BasicDBObject();
		updateQuery.append("$set", new BasicDBObject().append("change", "new change"));

		dbCollection.updateMulti(searchQuery2, updateQuery2);
	}

	// Mongodb delete
	public static void mongodb_delete(DBCollection dbCollection) {

	}

	// Mondodb find
	public static void mongodb_find(DBCollection dbCollection) {
		// 1.��ü ��ť��ũ ã��
		System.out.println("1. Find all matched documents");
		DBCursor cursor = dbCollection.find();
		while (cursor.hasNext()) {
			System.out.println(cursor.next());
		}
		// 2.��ť��Ʈ ù ��° ��
		System.out.println("\n1-2. Find first matched document");
		DBObject dbObject = dbCollection.findOne();
		System.out.println(dbObject);

		// 3.�ʵ� �ϳ��� �� ��� ��� (collection find �޼ҵ忡 2���� �Ķ���͸� ������ ��)
		System.out.println("\n1-3. Get 'name' field only");
		BasicDBObject allQuery = new BasicDBObject();
		BasicDBObject fields = new BasicDBObject();
		fields.put("mem_id", "test01"); // �� ��° �Ķ���ʹ� � ���� �͵� ������°� ����
		DBCursor cursor2 = dbCollection.find(allQuery, fields);
		while (cursor2.hasNext()) {
			System.out.println(cursor2.next());
		}
		// 4.�ʵ� ���� ��� (collection find �޼ҵ忡 1���� �Ķ���͸� ������ ��)
		System.out.println("\n2. Find where number = 5");
		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("mem_id", "test01");
		DBCursor cursor3 = dbCollection.find(whereQuery);
		while (cursor3.hasNext()) {
			System.out.println(cursor3.next());
		}

		// 5.���� ������ �־ �´� �� ã��
		System.out.println("\n2-2. Find where mem_id in test01 data03");
		BasicDBObject inQuery = new BasicDBObject();
		List<String> list = new ArrayList<String>();
		list.add("data03");
		list.add("test01");
		// $in�� �������� �����Ϳ� �´� ���� ã��
		inQuery.put("mem_id", new BasicDBObject("$in", list));
		DBCursor cursor4 = dbCollection.find(inQuery);
		while (cursor4.hasNext()) {
			System.out.println(cursor4.next());
		}

		// 6. ���� ũ�� ������ $gt $lt
		System.out.println("\n2-3. Find where 5 > number > 2");
		BasicDBObject gtQuery = new BasicDBObject();
		gtQuery.put("number", new BasicDBObject("$gt", 2).append("$lt", 5));
		DBCursor cursor5 = dbCollection.find(gtQuery);
		while (cursor5.hasNext()) {
			System.out.println(cursor5.next());
		}

		// 7. ���� ������ �ƴҶ� $ne
		System.out.println("\n2-4. Find where number != 4");
		BasicDBObject neQuery = new BasicDBObject();
		neQuery.put("number", new BasicDBObject("$ne", 4));
		DBCursor cursor6 = dbCollection.find(neQuery);
		while (cursor6.hasNext()) {
			System.out.println(cursor6.next());
		}

		// 8. �ΰ��� ������ �־�� �Ҷ� ArrayList�� ���� �־
		System.out.println("\n3. Find when number = 2 and name = 'mkyong-2' example");
		BasicDBObject andQuery = new BasicDBObject();
		List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
		obj.add(new BasicDBObject("number", 2));
		obj.add(new BasicDBObject("name", "mkyong-2"));
		andQuery.put("$and", obj);
		System.out.println(andQuery.toString());
		DBCursor cursor7 = dbCollection.find(andQuery);
		while (cursor7.hasNext()) {
			System.out.println(cursor7.next());
		}

		// 9. ����ǥ�������� ã�� $regex $options(�ɼ��� �ɾ��� �� ���� i�� �ҹ��� �빮�� �������)
		System.out.println("\n4. Find where name = 'Mky.*-[1-3]', case sensitive example");
		BasicDBObject regexQuery = new BasicDBObject();
		regexQuery.put("name", new BasicDBObject("$regex", "Mky.*-[1-3]").append("$options", "i"));
		System.out.println(regexQuery.toString());
		DBCursor cursor8 = dbCollection.find(regexQuery);
		while (cursor8.hasNext()) {
			System.out.println(cursor8.next());
		}
	}

}