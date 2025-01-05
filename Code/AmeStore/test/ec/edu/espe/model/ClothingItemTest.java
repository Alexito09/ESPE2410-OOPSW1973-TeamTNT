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
public class ClothingItemTest {
    
    public ClothingItemTest() {
    }

    @Test
    public void testGetName() {
        System.out.println("getName");
        ClothingItem instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        ClothingItem instance = null;
        instance.setName(name);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        ClothingItem instance = null;
        double expResult = 0.0;
        double result = instance.getPrice();
        assertEquals(expResult, result, 0);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetPrice() {
        System.out.println("setPrice");
        double price = 0.0;
        ClothingItem instance = null;
        instance.setPrice(price);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        ClothingItem instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
