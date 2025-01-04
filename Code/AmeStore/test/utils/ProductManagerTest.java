package utils;

import ec.edu.espe.model.RegistrationProduct;
import ec.edu.espe.model.Transaction;
import java.util.List;
import java.util.Scanner;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Team TNT
 */
public class ProductManagerTest {
    
    public ProductManagerTest() {
    }

    @Test
    public void testProcessSale() {
        System.out.println("processSale");
        Scanner scanner = new Scanner(System.in);
        ProductManager instance = new ProductManager();
        instance.processSale(scanner);
        fail("The test case is a prototype.");
    }

    @Test
    public void testShowTransactionHistory() {
        System.out.println("showTransactionHistory");
        ProductManager instance = new ProductManager();
        instance.showTransactionHistory();
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetTransactionHistory() {
        System.out.println("getTransactionHistory");
        ProductManager instance = new ProductManager();
        List<Transaction> expResult = null;
        List<Transaction> result = instance.getTransactionHistory();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSaveToJsonFile() {
        System.out.println("saveToJsonFile");
        RegistrationProduct newProduct = null;
        String fileName = "";
        ProductManager instance = new ProductManager();
        instance.saveToJsonFile(newProduct, fileName);
        fail("The test case is a prototype.");
    }

    @Test
    public void testReadFromJsonFile() {
        System.out.println("readFromJsonFile");
        String fileName = "";
        ProductManager instance = new ProductManager();
        List<RegistrationProduct> expResult = null;
        List<RegistrationProduct> result = instance.readFromJsonFile(fileName);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDeleteProductById() {
        System.out.println("deleteProductById");
        Scanner scanner = new Scanner(System.in);
        ProductManager instance = new ProductManager();
        instance.deleteProductById(scanner);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSaveToJsonObjectFile() {
        System.out.println("saveToJsonObjectFile");
        Object newObject = null;
        String fileName = "";
        ProductManager instance = new ProductManager();
        instance.saveToJsonObjectFile(newObject, fileName);
        fail("The test case is a prototype.");
    }

    @Test
    public void testReadFromJson() {
        System.out.println("readFromJson");
        String fileName = "";
        ProductManager instance = new ProductManager();
        List<Object> expResult = null;
        List<Object> result = instance.readFromJson(fileName);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetObjectList() {
        System.out.println("getObjectList");
        ProductManager instance = new ProductManager();
        List<Object> expResult = null;
        List<Object> result = instance.getObjectList();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
