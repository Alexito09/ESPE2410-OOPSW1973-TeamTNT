/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espe.AmeStoreInventory.utils;

import com.mongodb.client.MongoDatabase;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author User
 */
public class MongoDBConnectionManagerTest {
    
    public MongoDBConnectionManagerTest() {
    }

    /**
     * Test of getDatabase method, of class MongoDBConnectionManager.
     */
    @Test
    public void testGetDatabase() {
        System.out.println("getDatabase");
        MongoDBConnectionManager instance = new MongoDBConnectionManager();
        MongoDatabase expResult = null;
        MongoDatabase result = instance.getDatabase();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
