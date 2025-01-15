package ec.edu.espe.view;

import ec.edu.espe.exceptions.InsufficientStockException;
import ec.edu.espe.exceptions.InvalidCategoryException;
import ec.edu.espe.model.Category;
import ec.edu.espe.model.ClothingItem;
import ec.edu.espe.model.Invoice;
import ec.edu.espe.model.RegistrationProduct;
import java.util.List;
import java.util.Scanner;
import utils.ProductManager;

/**
 *
 * @author Team TNT
 */
public class AmeStoreApp {
   public static void main(String[] args) throws InsufficientStockException {
    
        Category manCategory = new Category("man");
        Category womanCategory = new Category("woman");

    manCategory.addClothingItem(new ClothingItem("shirt", 20.00));
    manCategory.addClothingItem(new ClothingItem("pants", 30.00));
    manCategory.addClothingItem(new ClothingItem("suit", 50.00));
    manCategory.addClothingItem(new ClothingItem("jacket", 40.00));
    manCategory.addClothingItem(new ClothingItem("hat", 15.00));
    manCategory.addClothingItem(new ClothingItem("belt", 12.00));
    manCategory.addClothingItem(new ClothingItem("gloves", 18.00));
    manCategory.addClothingItem(new ClothingItem("Boxer shorts", 25.00));
    manCategory.addClothingItem(new ClothingItem("scarf", 5.00));
    manCategory.addClothingItem(new ClothingItem("sweater", 35.00));


    womanCategory.addClothingItem(new ClothingItem("dress", 25.00));
    womanCategory.addClothingItem(new ClothingItem("blouse", 15.00));
    womanCategory.addClothingItem(new ClothingItem("skirt", 18.00));
    womanCategory.addClothingItem(new ClothingItem("baggy jeans", 20.00));
    womanCategory.addClothingItem(new ClothingItem("pyjamas", 18.00));
    womanCategory.addClothingItem(new ClothingItem("sweater", 12.00));
    womanCategory.addClothingItem(new ClothingItem("jacket", 45.00));
    womanCategory.addClothingItem(new ClothingItem("leggings", 22.00));
    womanCategory.addClothingItem(new ClothingItem("T-shirt", 12.00));
    womanCategory.addClothingItem(new ClothingItem("panties", 10.00));


        Scanner scanner = new Scanner(System.in);
        ProductManager manager = new ProductManager();
        int option;

        do {
            System.out.println("Welcome Back");
            System.out.println("======== AME STOREAPP ========");
            System.out.println("======== MAIN MENU ========");
            System.out.println("Option 1: Register product");
            System.out.println("Option 2: Process Sale");
            System.out.println("Option 3: Delete Product");
            System.out.println("Option 4: Show Transaction History");
            System.out.println("Option 5: Generate Invoice");
            System.out.println("Option 6: Exit");
            System.out.print("Please select an option: ");
            option = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (option) {
                case 1:
    boolean registrationCompleted = false;
    while (!registrationCompleted) {
        try {

            RegistrationProduct newProduct = RegistrationProduct.collectProductDetails(manCategory, womanCategory);
            if (newProduct != null) {
                manager.saveToJsonFile(newProduct, "Clothes.json");
                System.out.println("Product registered successfully: " + newProduct);
                registrationCompleted = true; // Salir del bucle al completar el registro
            }
        } catch (InvalidCategoryException e) {
            System.err.println("Error: " + e.getMessage()); 
        } catch (InsufficientStockException e) {
            System.err.println("Error: " + e.getMessage());
            registrationCompleted = true; 
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
            registrationCompleted = true; 
        }
    }
    break;
                case 2:
                       manager.processSale(scanner);

       
                    break;
                    
                case 3:
                        manager.deleteProductById(scanner);
                   
                    break;
                    
                case 4:
                         manager.showTransactionHistory();
                    break;
                    
                 case 5:
                if (manager.getTransactionHistory().isEmpty()) {
                        System.out.println("No transactions available to generate an invoice.");
                    } else {
                        Invoice invoice = Invoice.createInvoice(scanner, manager.getTransactionHistory());
                        if (invoice != null) {
                            invoice.displayInvoice();
                        }
                    }
                    break; 
                case 6:
                        System.out.println("Exiting the program. Thank you for using AME StoreApp!");
                    break;
                    
                default:
                    System.out.println("Invalid option. Please select an option from 1 to 5.");
            }
            System.out.println(); 
        } while (option != 6);

        scanner.close();
    }

    public AmeStoreApp() {
    }
       
}