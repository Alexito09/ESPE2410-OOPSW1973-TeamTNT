/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ec.edu.espe.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class TransactionTest {
    
    public TransactionTest() {
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        Transaction instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetProductId() {
        System.out.println("getProductId");
        Transaction instance = null;
        String expResult = "";
        String result = instance.getProductId();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetProductId() {
        System.out.println("setProductId");
        String productId = "";
        Transaction instance = null;
        instance.setProductId(productId);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetProductName() {
        System.out.println("getProductName");
        Transaction instance = null;
        String expResult = "";
        String result = instance.getProductName();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetProductName() {
        System.out.println("setProductName");
        String productName = "";
        Transaction instance = null;
        instance.setProductName(productName);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetQuantitySold() {
        System.out.println("getQuantitySold");
        Transaction instance = null;
        int expResult = 0;
        int result = instance.getQuantitySold();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetQuantitySold() {
        System.out.println("setQuantitySold");
        int quantitySold = 0;
        Transaction instance = null;
        instance.setQuantitySold(quantitySold);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetTotalPrice() {
        System.out.println("getTotalPrice");
        Transaction instance = null;
        double expResult = 0.0;
        double result = instance.getTotalPrice();
        assertEquals(expResult, result, 0);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetTotalPrice() {
        System.out.println("setTotalPrice");
        double totalPrice = 0.0;
        Transaction instance = null;
        instance.setTotalPrice(totalPrice);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetCustomerName() {
        System.out.println("getCustomerName");
        Transaction instance = null;
        String expResult = "";
        String result = instance.getCustomerName();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetCustomerName() {
        System.out.println("setCustomerName");
        String customerName = "";
        Transaction instance = null;
        instance.setCustomerName(customerName);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetCustomerId() {
        System.out.println("getCustomerId");
        Transaction instance = null;
        String expResult = "";
        String result = instance.getCustomerId();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetCustomerId() {
        System.out.println("setCustomerId");
        String customerId = "";
        Transaction instance = null;
        instance.setCustomerId(customerId);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetCustomerEmail() {
        System.out.println("getCustomerEmail");
        Transaction instance = null;
        String expResult = "";
        String result = instance.getCustomerEmail();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetCustomerEmail() {
        System.out.println("setCustomerEmail");
        String customerEmail = "";
        Transaction instance = null;
        instance.setCustomerEmail(customerEmail);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetCustomerPhone() {
        System.out.println("getCustomerPhone");
        Transaction instance = null;
        String expResult = "";
        String result = instance.getCustomerPhone();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetCustomerPhone() {
        System.out.println("setCustomerPhone");
        String customerPhone = "";
        Transaction instance = null;
        instance.setCustomerPhone(customerPhone);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetCustomerAddress() {
        System.out.println("getCustomerAddress");
        Transaction instance = null;
        String expResult = "";
        String result = instance.getCustomerAddress();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetCustomerAddress() {
        System.out.println("setCustomerAddress");
        String customerAddress = "";
        Transaction instance = null;
        instance.setCustomerAddress(customerAddress);
        fail("The test case is a prototype.");
    }
    
}
