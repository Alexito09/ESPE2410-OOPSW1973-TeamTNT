package ec.edu.espe.view;

import ec.edu.espe.model.RegistrationProduct;
import static ec.edu.espe.model.RegistrationProduct.registrationProduct;
import java.util.Scanner;

/**
 *
 * @author USUARIO
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
            System.out.println("2. Option 2: buils");
            System.out.println("3. Option 3: Salir");
            System.out.println("================================");
            System.out.print("Selection one option : ");
            
            // Leer la opción del usuario
            option = scanner.nextInt();

            // Procesar la opción seleccionada
            
            switch (option) {
                case 1:
                    registrationProduct();
                    break;
                    
                case 2:
                    System.out.println("La fecha y hora actual es: " + java.time.LocalDateTime.now());
                    break;
                case 3:
                    System.out.println("¡Gracias por usar el programa! Hasta luego.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, selecciona una opción del 1 al 3.");
            }
            System.out.println(); // Espacio entre iteraciones
        } while (option != 3);

        scanner.close();
    }

    public AmeStoreApp() {
    }
}

