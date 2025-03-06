/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espe.AmeStoreInventory.utils;

import org.bson.Document;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author User
 */
public class InvoiceRepositoryTest {
    
    public InvoiceRepositoryTest() {
    }

    /**
     * Test of save method, of class InvoiceRepository.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        Document invoice = null;
        InvoiceRepository instance = null;
        boolean expResult = false;
        boolean result = instance.save(invoice);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
