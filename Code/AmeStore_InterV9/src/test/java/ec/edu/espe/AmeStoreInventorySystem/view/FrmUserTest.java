/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espe.AmeStoreInventorySystem.view;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author User
 */
public class FrmUserTest {
    
    public FrmUserTest() {
    }

    /**
     * Test of main method, of class FrmUser.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        FrmUser.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of transformPassword method, of class FrmUser.
     */
    @Test
    public void testTransformPassword() {
        System.out.println("transformPassword");
        String password = "";
        String expResult = "";
        String result = FrmUser.transformPassword(password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveUser method, of class FrmUser.
     */
    @Test
    public void testSaveUser() {
        System.out.println("saveUser");
        FrmUser instance = new FrmUser();
        instance.saveUser();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
