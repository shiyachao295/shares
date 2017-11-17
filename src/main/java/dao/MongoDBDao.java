package dao;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * @Auther syc.
 * @Date 2017/11/17 17:02.
 */
public class MongoDBDao implements DBBase {

    public static MongoDatabase database;

    static {
        // 连接到 mongodb 服务
        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );

        // 连接到数据库
        database = mongoClient.getDatabase("test");
    }

    public void save(String table, Document document) {
        MongoCollection<Document> collection = database.getCollection(table);
        collection.insertOne(document);
    }

    @Deprecated
    public void update(String table, Document document) {

    }

    public <T> T get(String table, ) {
        MongoCollection<Document> collection = database.getCollection(table);
        FindIterable<Document> findIterable = collection.find();
        MongoCursor<Document> mongoCursor = findIterable.iterator();
    }

    public static MongoDatabase database() {
        return database;
    }
}
