/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espe.AmeStoreInventory.controller;

import ec.edu.espe.AmeStoreInventory.model.Product;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author User
 */
public class ProductControllerTest {
    
    public ProductControllerTest() {
    }

    /**
     * Test of isValidProductId method, of class ProductController.
     */
    @Test
    public void testIsValidProductId() {
        System.out.println("isValidProductId");
        String id = "";
        ProductController instance = new ProductController();
        boolean expResult = false;
        boolean result = instance.isValidProductId(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createProduct method, of class ProductController.
     */
    @Test
    public void testCreateProduct() {
        System.out.println("createProduct");
        String id = "";
        String name = "";
        String description = "";
        String category = "";
        String size = "";
        String quantityString = "";
        String priceString = "";
        ProductController instance = new ProductController();
        Product expResult = null;
        Product result = instance.createProduct(id, name, description, category, size, quantityString, priceString);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveOrUpdateProduct method, of class ProductController.
     */
    @Test
    public void testSaveOrUpdateProduct() {
        System.out.println("saveOrUpdateProduct");
        Product product = null;
        ProductController instance = new ProductController();
        instance.saveOrUpdateProduct(product);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadProducts method, of class ProductController.
     */
    @Test
    public void testLoadProducts_0args() {
        System.out.println("loadProducts");
        ProductController instance = new ProductController();
        instance.loadProducts();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchProduct method, of class ProductController.
     */
    @Test
    public void testSearchProduct() {
        System.out.println("searchProduct");
        String searchCriteria = "";
        ProductController instance = new ProductController();
        instance.searchProduct(searchCriteria);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteProduct method, of class ProductController.
     */
    @Test
    public void testDeleteProduct() {
        System.out.println("deleteProduct");
        int selectedRow = 0;
        DefaultTableModel tableModel = null;
        JTable table = null;
        ProductController instance = new ProductController();
        boolean expResult = false;
        boolean result = instance.deleteProduct(selectedRow, tableModel, table);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveProduct method, of class ProductController.
     */
    @Test
    public void testSaveProduct() {
        System.out.println("saveProduct");
        JTextField idFldText = null;
        JTextField nameFldText = null;
        JTextField descriptionFldText = null;
        JTextField categoryFldText = null;
        JTextField sizeFldText = null;
        JTextField quantityFldText = null;
        JTextField priceFldText = null;
        DefaultTableModel tableModel = null;
        ProductController instance = new ProductController();
        instance.saveProduct(idFldText, nameFldText, descriptionFldText, categoryFldText, sizeFldText, quantityFldText, priceFldText, tableModel);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadProducts method, of class ProductController.
     */
    @Test
    public void testLoadProducts_DefaultTableModel() {
        System.out.println("loadProducts");
        DefaultTableModel tableModel = null;
        ProductController instance = new ProductController();
        instance.loadProducts(tableModel);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
