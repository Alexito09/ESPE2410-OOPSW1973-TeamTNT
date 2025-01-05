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
public class ClothesTest {
    
    public ClothesTest() {
    }

    @Test
    public void testGetIdProduct() {
        System.out.println("getIdProduct");
        Clothes instance = null;
        String expResult = "";
        String result = instance.getIdProduct();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetIdProduct() {
        System.out.println("setIdProduct");
        String idProduct = "";
        Clothes instance = null;
        instance.setIdProduct(idProduct);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetCategory() {
        System.out.println("getCategory");
        Clothes instance = null;
        String expResult = "";
        String result = instance.getCategory();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetCategory() {
        System.out.println("setCategory");
        String category = "";
        Clothes instance = null;
        instance.setCategory(category);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetSize() {
        System.out.println("getSize");
        Clothes instance = null;
        String expResult = "";
        String result = instance.getSize();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetSize() {
        System.out.println("setSize");
        String size = "";
        Clothes instance = null;
        instance.setSize(size);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetColor() {
        System.out.println("getColor");
        Clothes instance = null;
        String expResult = "";
        String result = instance.getColor();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetColor() {
        System.out.println("setColor");
        String color = "";
        Clothes instance = null;
        instance.setColor(color);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetAmount() {
        System.out.println("getAmount");
        Clothes instance = null;
        int expResult = 0;
        int result = instance.getAmount();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetAmount() {
        System.out.println("setAmount");
        int amount = 0;
        Clothes instance = null;
        instance.setAmount(amount);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        Clothes instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
