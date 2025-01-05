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
public class RegistrationProductTest {
    
    public RegistrationProductTest() {
    }

    @Test
    public void testGetId() {
        System.out.println("getId");
        RegistrationProduct instance = null;
        String expResult = "";
        String result = instance.getId();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetId() {
        System.out.println("setId");
        String id = "";
        RegistrationProduct instance = null;
        instance.setId(id);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetCategory() {
        System.out.println("getCategory");
        RegistrationProduct instance = null;
        String expResult = "";
        String result = instance.getCategory();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetCategory() {
        System.out.println("setCategory");
        String category = "";
        RegistrationProduct instance = null;
        instance.setCategory(category);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetName() {
        System.out.println("getName");
        RegistrationProduct instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        RegistrationProduct instance = null;
        instance.setName(name);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetSize() {
        System.out.println("getSize");
        RegistrationProduct instance = null;
        String expResult = "";
        String result = instance.getSize();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetSize() {
        System.out.println("setSize");
        String size = "";
        RegistrationProduct instance = null;
        instance.setSize(size);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetQuantity() {
        System.out.println("getQuantity");
        RegistrationProduct instance = null;
        int expResult = 0;
        int result = instance.getQuantity();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetQuantity() {
        System.out.println("setQuantity");
        int quantity = 0;
        RegistrationProduct instance = null;
        instance.setQuantity(quantity);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetColor() {
        System.out.println("getColor");
        RegistrationProduct instance = null;
        String expResult = "";
        String result = instance.getColor();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetColor() {
        System.out.println("setColor");
        String color = "";
        RegistrationProduct instance = null;
        instance.setColor(color);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        RegistrationProduct instance = null;
        double expResult = 0.0;
        double result = instance.getPrice();
        assertEquals(expResult, result, 0);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetPrice() {
        System.out.println("setPrice");
        double price = 0.0;
        RegistrationProduct instance = null;
        instance.setPrice(price);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        RegistrationProduct instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testReduceStock() throws Exception {
        System.out.println("reduceStock");
        int quantity = 0;
        RegistrationProduct instance = null;
        boolean expResult = false;
        boolean result = instance.reduceStock(quantity);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCollectProductDetails() throws Exception {
        System.out.println("collectProductDetails");
        Category manCategory = null;
        Category womanCategory = null;
        RegistrationProduct expResult = null;
        RegistrationProduct result = RegistrationProduct.collectProductDetails(manCategory, womanCategory);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
