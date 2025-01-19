package utils;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 *
 * @author Andres Sandoval
 */
public class MongoDBConection {
   
    private static MongoClient mongoClient = null;

    public static MongoDatabase conectar() {
        if (mongoClient == null) {
            mongoClient = MongoClients.create("mongodb+srv://aesandoval:aesandoval@cluster0.5z3gp.mongodb.net/");
        }
        return mongoClient.getDatabase("AmeStoreDatabase");
    }
    
    public static MongoCollection<Document> getCollection(String AmeStore){
        return conectar().getCollection(AmeStore);
    }
}



