/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ec.edu.espe.model;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class CategoryTest {
    
    public CategoryTest() {
    }

    @Test
    public void testAddClothingItem() {
        System.out.println("addClothingItem");
        ClothingItem item = null;
        Category instance = null;
        instance.addClothingItem(item);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetName() {
        System.out.println("getName");
        Category instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetClothingItems() {
        System.out.println("getClothingItems");
        Category instance = null;
        ArrayList<ClothingItem> expResult = null;
        ArrayList<ClothingItem> result = instance.getClothingItems();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetClothingItemByName() {
        System.out.println("getClothingItemByName");
        String itemName = "";
        Category instance = null;
        ClothingItem expResult = null;
        ClothingItem result = instance.getClothingItemByName(itemName);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
