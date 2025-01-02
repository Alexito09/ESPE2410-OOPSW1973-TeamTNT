package utils;

import ec.edu.espe.model.RegistrationProduct;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import ec.edu.espe.exceptions.InsufficientStockException;
import ec.edu.espe.exceptions.InvalidProductIDException;
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
 * @author Team TNT
 */

public class ProductManager {
private String customerName;    // Declare these fields  
    private String customerId;  
    private String customerEmail;  
    private String customerPhone;  
    private String customerAddress;
    private List<RegistrationProduct> productList;
    private List<Transaction> transactionHistory;
    private List<Object> objectList;

    
    public ProductManager() {
        this.objectList = new ArrayList<>();
        this.productList = readFromJsonFile("clothes.json");
        this.transactionHistory = new ArrayList<>();
    }


public void processSale(Scanner scanner) {
    List<Transaction> customerTransactions = new ArrayList<>();
    boolean addMoreProducts = true;
    boolean firstTime = true;

    while (addMoreProducts) {
        if (firstTime) {
            System.out.println("===========================     Available Products     ==========================");
            if (productList.isEmpty()) {
                System.out.println("No products available. Please register products first.");
                return;
            }

            for (RegistrationProduct product : productList) {
                System.out.println(product);
            }
            firstTime = false;
        }

        RegistrationProduct product = null;
        while (product == null) {
            System.out.print("Enter product ID to sell: ");
            String productId = scanner.nextLine();
          
            if (productId.equalsIgnoreCase("Exit")) {
                System.out.println("Sale process canceled. Returning to main menu.");
                return;
            }
            try{
            product = findProductById(productId);
            
              if (product == null) {
               throw new InvalidProductIDException("Id not found");
              }
               
            }catch(InvalidProductIDException e){
                System.err.println("Error"+ e.getMessage());
            }
        }

        System.out.println("Selected product: " + product);
        System.out.print("Enter quantity to sell: ");
        int quantityToSell = scanner.nextInt();
        scanner.nextLine(); 

        try {
            // Intentamos reducir el stock
            if (product.reduceStock(quantityToSell)) {
                double totalPrice = quantityToSell * product.getPrice();

                Transaction transaction = new Transaction(
                        product.getId(),
                        product.getName(),
                        quantityToSell,
                        totalPrice,
                        customerName,
                        customerId,
                        customerEmail,
                        customerPhone,
                        customerAddress
                );
                saveToJsonObjectFile(transaction, "transaction.json");
                customerTransactions.add(transaction);

                System.out.println("Sale successful, Remaining stock: " + product.getQuantity());
            }
        } catch (InsufficientStockException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.print("Do you want to add another product to this transaction? (yes/no): ");
        String response = scanner.nextLine();
        addMoreProducts = response.equalsIgnoreCase("yes");
    }

    transactionHistory.addAll(customerTransactions);
    System.out.println("Transaction completed successfully!");
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
    public List<Transaction> getTransactionHistory() {
    return transactionHistory;
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
   public void saveToJsonObjectFile(Object newObject, String fileName) {
          List<Object> objects = readFromJson(fileName);
  

          objects.add(newObject);
  
          Gson gson = new GsonBuilder().setPrettyPrinting().create();
          try (FileWriter fileWriter = new FileWriter(fileName)) {

              gson.toJson(objects, fileWriter);
              System.out.println("Registro guardado en " + fileName);
          } catch (IOException e) {
              System.out.println("Error al guardar el objeto: " + e.getMessage());
          }
          
          this.objectList = objects;
      }
  
    public List<Object> readFromJson(String fileName) {
        Gson gson = new Gson();
        List<Object> objects = new ArrayList<>();

        try (FileReader fileReader = new FileReader(fileName)) {    
            Type objectListType = new TypeToken<List<Object>>() {}.getType();
             
            objects = gson.fromJson(fileReader, objectListType);
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo JSON: " + e.getMessage());
        }

        return objects != null ? objects : new ArrayList<>();
      }

    public List<Object> getObjectList() {
        return this.objectList;
    }
}
