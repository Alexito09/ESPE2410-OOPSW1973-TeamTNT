/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espe.AmeStoreInventory.controller;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author User
 */
public class CustomerControllerTest {
    
    public CustomerControllerTest() {
    }

    /**
     * Test of validateIdentityCard method, of class CustomerController.
     */
    @Test
    public void testValidateIdentityCard() {
        System.out.println("validateIdentityCard");
        String id = "";
        CustomerController instance = null;
        boolean expResult = false;
        boolean result = instance.validateIdentityCard(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validateEmail method, of class CustomerController.
     */
    @Test
    public void testValidateEmail() {
        System.out.println("validateEmail");
        String email = "";
        CustomerController instance = null;
        boolean expResult = false;
        boolean result = instance.validateEmail(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validateName method, of class CustomerController.
     */
    @Test
    public void testValidateName() {
        System.out.println("validateName");
        String name = "";
        CustomerController instance = null;
        boolean expResult = false;
        boolean result = instance.validateName(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validatePhone method, of class CustomerController.
     */
    @Test
    public void testValidatePhone() {
        System.out.println("validatePhone");
        String phone = "";
        CustomerController instance = null;
        boolean expResult = false;
        boolean result = instance.validatePhone(phone);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCustomer method, of class CustomerController.
     */
    @Test
    public void testAddCustomer() {
        System.out.println("addCustomer");
        String id = "";
        String name = "";
        String address = "";
        String email = "";
        String phone = "";
        CustomerController instance = null;
        boolean expResult = false;
        boolean result = instance.addCustomer(id, name, address, email, phone);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of IdentityCardValidation method, of class CustomerController.
     */
    @Test
    public void testIdentityCardValidation() {
        System.out.println("IdentityCardValidation");
        String IdentityCard = "";
        CustomerController instance = null;
        boolean expResult = false;
        boolean result = instance.IdentityCardValidation(IdentityCard);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateCustomer method, of class CustomerController.
     */
    @Test
    public void testUpdateCustomer() {
        System.out.println("updateCustomer");
        String id = "";
        String name = "";
        String address = "";
        String email = "";
        String phone = "";
        JTable tblCustomers = null;
        CustomerController instance = null;
        instance.updateCustomer(id, name, address, email, phone, tblCustomers);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteCustomer method, of class CustomerController.
     */
    @Test
    public void testDeleteCustomer() {
        System.out.println("deleteCustomer");
        int selectedRow = 0;
        JTable tblCustomers = null;
        DefaultTableModel model = null;
        CustomerController instance = null;
        boolean expResult = false;
        boolean result = instance.deleteCustomer(selectedRow, tblCustomers, model);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadAllCustomers method, of class CustomerController.
     */
    @Test
    public void testLoadAllCustomers() {
        System.out.println("loadAllCustomers");
        JTable tblCustomers = null;
        CustomerController instance = null;
        instance.loadAllCustomers(tblCustomers);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
