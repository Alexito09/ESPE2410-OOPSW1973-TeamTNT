/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espe.AmeStoreInventorySystem.view;

import javax.swing.table.DefaultTableModel;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author User
 */
public class FrmDeleteProductTest {
    
    public FrmDeleteProductTest() {
    }

    /**
     * Test of main method, of class FrmDeleteProduct.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        FrmDeleteProduct.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadProducts method, of class FrmDeleteProduct.
     */
    @Test
    public void testLoadProducts() {
        System.out.println("loadProducts");
        DefaultTableModel tableModel = null;
        FrmDeleteProduct instance = new FrmDeleteProduct();
        instance.loadProducts(tableModel);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
