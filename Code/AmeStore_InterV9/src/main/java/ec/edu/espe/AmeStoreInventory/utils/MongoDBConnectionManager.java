package ec.edu.espe.AmeStoreInventory.utils;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author Andres Sandoval
 */
public class MongoDBConnectionManager {
    private static final String CONNECTION_STRING = "mongodb+srv://daullcu:daullcu@cluster0.dxj9m.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
    private static final String DATABASE_NAME = "BaseAmeStore";
    private MongoClient mongoClient;
    private MongoDatabase database;

    public MongoDBConnectionManager() {
        try {
            ConnectionString connString = new ConnectionString(CONNECTION_STRING);
            MongoClientSettings settings = MongoClientSettings.builder()
                    .applyConnectionString(connString)
                    .serverApi(ServerApi.builder().version(ServerApiVersion.V1).build())
                    .build();
            mongoClient = MongoClients.create(settings);
            database = mongoClient.getDatabase(DATABASE_NAME);
        } catch (MongoException e) {
            throw new RuntimeException("Error initializing MongoDB: " + e.getMessage());
        }
    }

    public MongoDatabase getDatabase() {
        return database;
    }
}

