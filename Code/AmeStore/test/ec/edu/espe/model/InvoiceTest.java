/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ec.edu.espe.model;

import java.util.List;
import java.util.Scanner; 
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class InvoiceTest {
    
    public InvoiceTest() {
    }

    @Test
    public void testDisplayInvoice() {
        System.out.println("displayInvoice");
        Invoice instance = null;
        instance.displayInvoice();
        fail("The test case is a prototype.");
    }

    @Test
    public void testCreateInvoice() {
        System.out.println("createInvoice");
        Scanner scanner = null;
        List<Transaction> transactionHistory = null;
        Invoice expResult = null;
        Invoice result = Invoice.createInvoice(scanner, transactionHistory);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
