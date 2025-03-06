/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espe.AmeStoreInventory.controller;

import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author User
 */
public class InvoiceControllerTest {
    
    public InvoiceControllerTest() {
    }

    /**
     * Test of addProductToTable method, of class InvoiceController.
     */
    @Test
    public void testAddProductToTable() {
        System.out.println("addProductToTable");
        JSpinner spnQuantity = null;
        InvoiceController instance = null;
        instance.addProductToTable(spnQuantity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateTotal method, of class InvoiceController.
     */
    @Test
    public void testCalculateTotal() {
        System.out.println("calculateTotal");
        InvoiceController instance = null;
        double[] expResult = null;
        double[] result = instance.calculateTotal();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateProductComboBox method, of class InvoiceController.
     */
    @Test
    public void testUpdateProductComboBox() {
        System.out.println("updateProductComboBox");
        String searchCriteria = "";
        InvoiceController instance = null;
        instance.updateProductComboBox(searchCriteria);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateSpinnerQuantity method, of class InvoiceController.
     */
    @Test
    public void testUpdateSpinnerQuantity() {
        System.out.println("updateSpinnerQuantity");
        JSpinner spnQuantity = null;
        InvoiceController instance = null;
        instance.updateSpinnerQuantity(spnQuantity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchCustomer method, of class InvoiceController.
     */
    @Test
    public void testSearchCustomer() {
        System.out.println("searchCustomer");
        JTextField txtid = null;
        JTextField txtCustomer = null;
        JTextField txtDirection = null;
        JTextField txtNumber = null;
        JFrame parentFrame = null;
        InvoiceController instance = null;
        instance.searchCustomer(txtid, txtCustomer, txtDirection, txtNumber, parentFrame);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveInvoice method, of class InvoiceController.
     */
    @Test
    public void testSaveInvoice() {
        System.out.println("saveInvoice");
        InvoiceController instance = null;
        instance.saveInvoice();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
