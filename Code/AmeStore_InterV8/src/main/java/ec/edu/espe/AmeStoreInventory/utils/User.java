package ec.edu.espe.AmeStoreInventory.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author TEAM TNT
 * 
 */
public class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = DigestUtils.sha256Hex(password);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = DigestUtils.sha256Hex(password);
    }

    public void saveToDatabase() {
        try (com.mongodb.client.MongoClient mongoClient = com.mongodb.client.MongoClients.create("")) {
            com.mongodb.client.MongoDatabase database = mongoClient.getDatabase("");
            com.mongodb.client.MongoCollection<org.bson.Document> collection = database.getCollection("");

            org.bson.Document userDocument = new org.bson.Document("username", username)
                                              .append("password", password);
            collection.insertOne(userDocument);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("Error saving user.");
        }
    }
}


