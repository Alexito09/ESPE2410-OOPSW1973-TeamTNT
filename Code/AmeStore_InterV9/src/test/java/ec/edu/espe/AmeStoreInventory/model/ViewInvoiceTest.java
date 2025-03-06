/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espe.AmeStoreInventory.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author User
 */
public class ViewInvoiceTest {
    
    public ViewInvoiceTest() {
    }

    /**
     * Test of createMessage method, of class ViewInvoice.
     */
    @Test
    public void testCreateMessage() {
        System.out.println("createMessage");
        ViewInvoice instance = null;
        String expResult = "";
        String result = instance.createMessage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
