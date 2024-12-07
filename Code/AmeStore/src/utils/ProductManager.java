package utils;

import ec.edu.espe.model.RegistrationProduct;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andres Sandoval
 */

public class ProductManager {

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

    public List<RegistrationProduct> readFromJsonFile(String fileName) {
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
