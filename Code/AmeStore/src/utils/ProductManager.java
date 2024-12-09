package utils;

import ec.edu.espe.model.RegistrationProduct;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import ec.edu.espe.model.Transaction;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Andres Sandoval
 */

public class ProductManager {

 private List<RegistrationProduct> productList;
    private List<Transaction> transactionHistory;

    // Constructor que inicializa las listas
    public ProductManager() {
        this.productList = new ArrayList<>();
        this.transactionHistory = new ArrayList<>();
    }


    // Método para procesar una venta
    public void processSale(Scanner scanner) {
        if (productList.isEmpty()) {
            System.out.println("No products available. Please register products first.");
            return;
        }

        // Mostrar los productos disponibles
        System.out.println("=== Available Products ===");
        for (RegistrationProduct product : productList) {
            System.out.println(product);
        }

        // Solicitar ID del producto a vender
        System.out.print("Enter product ID to sell: ");
        String productId = scanner.nextLine();

        // Buscar el producto por ID
        RegistrationProduct product = findProductById(productId);

        if (product != null) {
            System.out.println("Selected product: " + product);
            System.out.print("Enter quantity to sell: ");
            int quantityToSell = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            if (product.reduceStock(quantityToSell)) {
                double totalPrice = quantityToSell * product.getPrice();
                // Registrar la transacción
                transactionHistory.add(new Transaction(productId, product.getName(), quantityToSell, totalPrice));
                System.out.println("Sale successful! Remaining stock: " + product.getQuantity());
            } else {
                System.out.println("Error: Not enough stock available.");
            }
        } else {
            System.out.println("Product not found.");
        }
    }

    // Mostrar el historial de transacciones
    public void showTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions recorded yet.");
            return;
        }

        System.out.println("=== Transaction History ===");
        for (Transaction transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    // Método para encontrar un producto por su ID
    private RegistrationProduct findProductById(String id) {
        for (RegistrationProduct product : productList) {
            if (product.getId().equalsIgnoreCase(id)) {
                return product;
            }
        }
        return null;
    }


    public void saveToJsonFile(RegistrationProduct newProduct, String fileName) {
        List<RegistrationProduct> products = readFromJsonFile(fileName);
        products.add(newProduct);
        
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            gson.toJson(products, fileWriter);
            System.out.println("Registration saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving product: " + e.getMessage());
        }
    }

    public  List<RegistrationProduct> readFromJsonFile(String fileName) {
        List<RegistrationProduct> products = new ArrayList<>();
        Gson gson = new Gson();
        File file = new File(fileName);
        if (file.exists()) {
            try (FileReader reader = new FileReader(file)) {
                Type productListType = new TypeToken<ArrayList<RegistrationProduct>>() {}.getType();
                products = gson.fromJson(reader, productListType);
            } catch (IOException e) {
                System.out.println("Error reading existing products: " + e.getMessage());
            }
        }
        return products;
    }
}
