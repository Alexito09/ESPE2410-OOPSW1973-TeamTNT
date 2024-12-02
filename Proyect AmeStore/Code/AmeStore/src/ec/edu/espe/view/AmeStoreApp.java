package ec.edu.espe.view;

import ec.edu.espe.model.RegistrationProduct;
import static ec.edu.espe.model.RegistrationProduct.registrationProduct;
import java.util.Scanner;

/**
 *
 * @author Mateo Topon
 */
public class AmeStoreApp {
    
    public static void main (String[] args) {
    
   
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            // Mostrar opciones del menú
            System.out.println("======== AME STOREAPP ========");
            System.out.println("======== MAIN MENU ========");
            System.out.println("1. Option 1: registration product");
            System.out.println("2. Option 2: sale");
            System.out.println("3. Option 3: Exit");
            System.out.println("================================");
            System.out.print("Selection an option : ");
            
            option = scanner.nextInt();
            
            switch (option) {
                case 1:
                    registrationProduct();
                    continue;
                    
                case 2:
                    ;
                    break;
                case 3:
                    System.out.println("¡Thanks for using the program! See you later.");
                    break;
                default:
                    System.out.println("Invalid option. Please select an option from 1 to 3.");
            }
            System.out.println(); 
        } while (option != 3);

        scanner.close();
    }

    public AmeStoreApp() {
    }
}

