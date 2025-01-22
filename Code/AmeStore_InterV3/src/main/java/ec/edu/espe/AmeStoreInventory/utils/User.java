/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.AmeStoreInventory.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author USER
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
        try (com.mongodb.client.MongoClient mongoClient = com.mongodb.client.MongoClients.create("mongodb+srv://<tu_usuario>:<tu_contraseña>@<tu_cluster>.mongodb.net")) {
            com.mongodb.client.MongoDatabase database = mongoClient.getDatabase("tu_base_de_datos");
            com.mongodb.client.MongoCollection<org.bson.Document> collection = database.getCollection("usuarios");

            org.bson.Document userDocument = new org.bson.Document("username", username)
                                              .append("password", password);
            collection.insertOne(userDocument);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("Error al guardar el usuario.");
        }
    }
}


