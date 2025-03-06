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
public class InvoiceItemTest {
    
    public InvoiceItemTest() {
    }

    /**
     * Test of getQuantity method, of class InvoiceItem.
     */
    @Test
    public void testGetQuantity() {
        System.out.println("getQuantity");
        InvoiceItem instance = new InvoiceItem();
        int expResult = 0;
        int result = instance.getQuantity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setQuantity method, of class InvoiceItem.
     */
    @Test
    public void testSetQuantity() {
        System.out.println("setQuantity");
        int quantity = 0;
        InvoiceItem instance = new InvoiceItem();
        instance.setQuantity(quantity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProductName method, of class InvoiceItem.
     */
    @Test
    public void testGetProductName() {
        System.out.println("getProductName");
        InvoiceItem instance = new InvoiceItem();
        String expResult = "";
        String result = instance.getProductName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProductName method, of class InvoiceItem.
     */
    @Test
    public void testSetProductName() {
        System.out.println("setProductName");
        String productName = "";
        InvoiceItem instance = new InvoiceItem();
        instance.setProductName(productName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrice method, of class InvoiceItem.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        InvoiceItem instance = new InvoiceItem();
        double expResult = 0.0;
        double result = instance.getPrice();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPrice method, of class InvoiceItem.
     */
    @Test
    public void testSetPrice() {
        System.out.println("setPrice");
        double price = 0.0;
        InvoiceItem instance = new InvoiceItem();
        instance.setPrice(price);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSubtotal method, of class InvoiceItem.
     */
    @Test
    public void testGetSubtotal() {
        System.out.println("getSubtotal");
        InvoiceItem instance = new InvoiceItem();
        double expResult = 0.0;
        double result = instance.getSubtotal();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSubtotal method, of class InvoiceItem.
     */
    @Test
    public void testSetSubtotal() {
        System.out.println("setSubtotal");
        double subtotal = 0.0;
        InvoiceItem instance = new InvoiceItem();
        instance.setSubtotal(subtotal);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
