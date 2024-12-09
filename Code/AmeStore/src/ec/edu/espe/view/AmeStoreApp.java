package ec.edu.espe.view;

import ec.edu.espe.model.Category;
import ec.edu.espe.model.ClothingItem;
import ec.edu.espe.model.RegistrationProduct;
import java.util.List;
import java.util.Scanner;
import utils.ProductManager;

/**
 *
 * @author Mateo Topon
 */
public class AmeStoreApp {
   public static void main(String[] args) {
    
        Category manCategory = new Category("man");
        Category womanCategory = new Category("woman");

        manCategory.addClothingItem(new ClothingItem("shirt", 20.00));
        manCategory.addClothingItem(new ClothingItem("pants", 30.00));
        manCategory.addClothingItem(new ClothingItem("shoes", 50.00));
        manCategory.addClothingItem(new ClothingItem("jacket", 40.00));

        womanCategory.addClothingItem(new ClothingItem("dress", 25.00));
        womanCategory.addClothingItem(new ClothingItem("blouse", 15.00));
        womanCategory.addClothingItem(new ClothingItem("skirt", 20.00));
        womanCategory.addClothingItem(new ClothingItem("shoes", 40.00));

        Scanner scanner = new Scanner(System.in);
        ProductManager manager = new ProductManager();
        int option;

        do {
            // Mostrar opciones del menú
            System.out.println("======== AME STOREAPP ========");
            System.out.println("======== MAIN MENU ========");
            System.out.println("1. Option 1: Register product");
           System.out.println("2. Option 2: Process sale");
            System.out.println("3. Option 3: Show transaction history");
            System.out.println("4. Option 4: Exit");
            System.out.print("Select an option: ");
            option = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (option) {
                case 1:
                    RegistrationProduct newProduct = RegistrationProduct.collectProductDetails(manCategory, womanCategory);
                    
                    if (newProduct != null) {
                        manager.saveToJsonFile(newProduct, "Clothes.json");
                    }
                    break;
                    
                case 2:
                       manager.processSale(scanner);

       
                    break;
                    
                case 3:
                  manager.showTransactionHistory();
                    break;
                    
                    case 4:
                        System.out.println("Exit");
                    break;
                    
                default:
                    System.out.println("Invalid option. Please select an option from 1 to 3.");
            }
            System.out.println(); 
        } while (option != 4);

        scanner.close();
    }

    public AmeStoreApp() {
    }
}
