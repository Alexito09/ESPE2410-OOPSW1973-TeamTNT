package ec.edu.espe.view;

import ec.edu.espe.model.Category;
import ec.edu.espe.model.ClothingItem;
import ec.edu.espe.model.RegistrationProduct;
import java.util.Scanner;
import utils.ProductManager;

/**
 *
 * @author Mateo Topon
 */
public class AmeStoreApp {
   public static void main(String[] args) {
    
        // Crear instancias de categorías
        Category manCategory = new Category("man");
        Category womanCategory = new Category("woman");

        // Agregar prendas a la categoría "man"
        manCategory.addClothingItem(new ClothingItem("shirt", 20.00));
        manCategory.addClothingItem(new ClothingItem("pants", 30.00));
        manCategory.addClothingItem(new ClothingItem("shoes", 50.00));
        manCategory.addClothingItem(new ClothingItem("jacket", 40.00));

        // Agregar prendas a la categoría "woman"
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
            System.out.println("2. Option 2: Sale");
            System.out.println("3. Option 3: Exit");
            System.out.println("================================");
            System.out.print("Select an option: ");
            
            option = scanner.nextInt();
            
            switch (option) {
                case 1:
                    // Llamar a collectProductDetails pasándole las categorías man y woman
                    RegistrationProduct newProduct = RegistrationProduct.collectProductDetails(manCategory, womanCategory);
                    
                    if (newProduct != null) {
                        // Guardar el producto en el archivo JSON
                        manager.saveToJsonFile(newProduct, "Clothes.json");
                    }
                    break;
                    
                case 2:
                    // Opciones para la venta (por implementar)
                    System.out.println("Sale functionality will be implemented here.");
                    break;
                    
                case 3:
                    System.out.println("Thanks for using the program! See you later.");
                    break;
                    
                default:
                    System.out.println("Invalid option. Please select an option from 1 to 3.");
            }
            System.out.println(); 
        } while (option != 3);

        scanner.close();
    }

    public AmeStoreApp() {
        // Constructor vacío
    }
}
