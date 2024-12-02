package ec.edu.espe.model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author USUARIO
 */
public class RegistrationProduct {
  private String id;
    private String category;
    private String size;
    private int quantity;
    private String color;
    private double price;

    public RegistrationProduct(String name, String category, String size, int quiantity, String color, double price) {
        this.id = name;
        this.category = category;
        this.size = size;
        this.quantity = quiantity;
        this.color = color;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getQuiantity() {
        return quantity;
    }

    public void setQuiantity(int quiantity) {
        this.quantity = quiantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public void saveToJsonFile(String fileName) {
        String jsonContent = this.toString();
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(jsonContent);
            System.out.println("Registration to save " + fileName);
        } catch (IOException e) {
            System.out.println("Error product: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "RegistrationProductJava{" + "name=" + id + ", category=" + category + ", size=" + size + ", quantity=" + quantity + ", color=" + color + ", price=" + price + '}';
    }

public static void registrationProduct() {
    
        Scanner scanner = new Scanner(System.in);

        System.out.println("Save clothing order data to json file");
        System.out.println("Enter the details of the order:");

        
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        System.out.print("man or woman: ");
        String category = scanner.nextLine();

        System.out.print("S-L-M-XL: ");
        String size = scanner.nextLine();

        System.out.print("color type: ");
        String color = scanner.nextLine();
        
        System.out.print("The price is: ");
        double price = scanner.nextInt();
        scanner.nextLine();

        System.out.print("How many units do you want:");
        int quantity = scanner.nextInt();
        
        
        RegistrationProduct RegistrationProductJava = new RegistrationProduct(name, category, size, quantity, color, price);

        
        RegistrationProductJava.saveToJsonFile(".json");

        scanner.close();
    }
}
