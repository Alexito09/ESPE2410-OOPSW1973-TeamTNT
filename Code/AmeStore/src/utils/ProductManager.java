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
 * @author G6
 */

public class ProductManager {

 private List<RegistrationProduct> productList;
    private List<Transaction> transactionHistory;

    
    public ProductManager() {
        this.productList = readFromJsonFile("clothes.json");
        this.transactionHistory = new ArrayList<>();
    }


    public void processSale(Scanner scanner) {
        System.out.println("===========================     Available Products     ==========================");
        if (productList.isEmpty()) {
            System.out.println("No products available. Please register products first.");
            return;
        }

        
        for (RegistrationProduct product : productList) {
            System.out.println(product);
        }
        RegistrationProduct product = null;
        while (product == null) {
        System.out.print("Enter product ID to sell: ");
        String productId = scanner.nextLine();

        if (productId.equalsIgnoreCase("Exit")) {
            System.out.println("Sale process canceled. Returning to main menu.");
            return;
        }

        product = findProductById(productId);

        if (product == null) {
            System.out.println("Product not found. Please try again.");
        }
    } 
     
            System.out.println("Selected product: " + product);
            System.out.print("Enter quantity to sell: ");
            int quantityToSell = scanner.nextInt();
            scanner.nextLine(); 

            if (product.reduceStock(quantityToSell)) {
                double totalPrice = quantityToSell * product.getPrice();
                transactionHistory.add(new Transaction(product.getId(), product.getName(), quantityToSell, totalPrice));
                System.out.println("Sale successful, Remaining stock: " + product.getQuantity());
            } else {
                System.out.println("Error: Not enough stock available.");
            }

    
        
    }

    public void showTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions recorded yet.");
            return;
        }

        System.out.println("==========================       Transaction History     ==========================");
          int counter = 1;
           for (Transaction transaction : transactionHistory) {
        System.out.println(counter + ". " + transaction);
        counter++;
    }
}

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
        this.productList = readFromJsonFile(fileName);
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
    public void deleteProductById(Scanner scanner) {
    if (productList.isEmpty()) {
        System.out.println("No products available. Please register products first.");
        return;
    }

    System.out.println("==== Available Products ===");
    for (RegistrationProduct product : productList) {
        System.out.println(product);
    }

    System.out.print("Enter the product ID to delete: ");
    String productId = scanner.nextLine();

    RegistrationProduct product = findProductById(productId);

    if (product != null) {
        System.out.println("Product found: " + product);
        System.out.print("Are you sure you want to delete this product? (yes/no): ");
        String confirmation = scanner.nextLine();

        if (confirmation.equalsIgnoreCase("yes")) {
            productList.remove(product);
            updateJsonFile("clothes.json");
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Product deletion canceled.");
        }
    } else {
        System.out.println("Product not found.");
    }
}

private void updateJsonFile(String fileName) {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    try (FileWriter fileWriter = new FileWriter(fileName)) {
        gson.toJson(productList, fileWriter);
    } catch (IOException e) {
        System.out.println("Error updating the JSON file: " + e.getMessage());
    }
}
}
