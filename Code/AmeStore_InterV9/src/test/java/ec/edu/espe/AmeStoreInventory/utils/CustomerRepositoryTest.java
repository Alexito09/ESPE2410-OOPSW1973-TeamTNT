/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espe.AmeStoreInventory.utils;

import ec.edu.espe.AmeStoreInventory.model.Customer;
import java.util.List;
import org.bson.Document;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author User
 */
public class CustomerRepositoryTest {
    
    public CustomerRepositoryTest() {
    }

    /**
     * Test of save method, of class CustomerRepository.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        Customer customer = null;
        CustomerRepository instance = null;
        instance.save(customer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class CustomerRepository.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        String id = "";
        Customer updatedData = null;
        CustomerRepository instance = null;
        instance.update(id, updatedData);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class CustomerRepository.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        String id = "";
        CustomerRepository instance = null;
        boolean expResult = false;
        boolean result = instance.delete(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class CustomerRepository.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        CustomerRepository instance = null;
        List<Document> expResult = null;
        List<Document> result = instance.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findById method, of class CustomerRepository.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        String id = "";
        CustomerRepository instance = null;
        Document expResult = null;
        Document result = instance.findById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
