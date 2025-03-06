/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espe.AmeStoreInventory.model;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author User
 */
public class InvoiceTest {
    
    public InvoiceTest() {
    }

    /**
     * Test of getId method, of class Invoice.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Invoice instance = null;
        String expResult = "";
        String result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Invoice.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        String id = "";
        Invoice instance = null;
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCustomerName method, of class Invoice.
     */
    @Test
    public void testGetCustomerName() {
        System.out.println("getCustomerName");
        Invoice instance = null;
        String expResult = "";
        String result = instance.getCustomerName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCustomerName method, of class Invoice.
     */
    @Test
    public void testSetCustomerName() {
        System.out.println("setCustomerName");
        String customerName = "";
        Invoice instance = null;
        instance.setCustomerName(customerName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCustomerAddress method, of class Invoice.
     */
    @Test
    public void testGetCustomerAddress() {
        System.out.println("getCustomerAddress");
        Invoice instance = null;
        String expResult = "";
        String result = instance.getCustomerAddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCustomerAddress method, of class Invoice.
     */
    @Test
    public void testSetCustomerAddress() {
        System.out.println("setCustomerAddress");
        String customerAddress = "";
        Invoice instance = null;
        instance.setCustomerAddress(customerAddress);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCustomerPhone method, of class Invoice.
     */
    @Test
    public void testGetCustomerPhone() {
        System.out.println("getCustomerPhone");
        Invoice instance = null;
        String expResult = "";
        String result = instance.getCustomerPhone();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCustomerPhone method, of class Invoice.
     */
    @Test
    public void testSetCustomerPhone() {
        System.out.println("setCustomerPhone");
        String customerPhone = "";
        Invoice instance = null;
        instance.setCustomerPhone(customerPhone);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItems method, of class Invoice.
     */
    @Test
    public void testGetItems() {
        System.out.println("getItems");
        Invoice instance = null;
        List<InvoiceItem> expResult = null;
        List<InvoiceItem> result = instance.getItems();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setItems method, of class Invoice.
     */
    @Test
    public void testSetItems() {
        System.out.println("setItems");
        List<InvoiceItem> items = null;
        Invoice instance = null;
        instance.setItems(items);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSubtotal method, of class Invoice.
     */
    @Test
    public void testGetSubtotal() {
        System.out.println("getSubtotal");
        Invoice instance = null;
        double expResult = 0.0;
        double result = instance.getSubtotal();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSubtotal method, of class Invoice.
     */
    @Test
    public void testSetSubtotal() {
        System.out.println("setSubtotal");
        double subtotal = 0.0;
        Invoice instance = null;
        instance.setSubtotal(subtotal);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIva method, of class Invoice.
     */
    @Test
    public void testGetIva() {
        System.out.println("getIva");
        Invoice instance = null;
        double expResult = 0.0;
        double result = instance.getIva();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIva method, of class Invoice.
     */
    @Test
    public void testSetIva() {
        System.out.println("setIva");
        double iva = 0.0;
        Invoice instance = null;
        instance.setIva(iva);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotal method, of class Invoice.
     */
    @Test
    public void testGetTotal() {
        System.out.println("getTotal");
        Invoice instance = null;
        double expResult = 0.0;
        double result = instance.getTotal();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTotal method, of class Invoice.
     */
    @Test
    public void testSetTotal() {
        System.out.println("setTotal");
        double total = 0.0;
        Invoice instance = null;
        instance.setTotal(total);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Invoice.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Invoice instance = null;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Invoice.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Invoice instance = null;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
