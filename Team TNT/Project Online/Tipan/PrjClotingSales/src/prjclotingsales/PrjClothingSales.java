package prjclotingsales;

import ec.espe.edu.model.Product;
import ec.espe.edu.model.Report;
import ec.espe.edu.model.Transaction;
import java.util.Date;

/**
 *
 * @author Lisbeth Tipan
 */
public class PrjClothingSales {

    /**
     * @param args the command line arguments
     */



    public static void main(String[] args) {
        Product producto = new Product("short", "black", 1200.50, 20);
     System.out.println("Producto: " + producto.getProduct());
Transaction transaction = new Transaction(producto, "Entrada", 8, new Date(), "Usuario1");
        transaction.registerEntry(9);
        System.out.println("Stock actual: " + producto.getCurrentStock());

        transaction.registerOutput(8);
        System.out.println("Stock actual: " + producto.getCurrentStock());

     
    }
}


    

