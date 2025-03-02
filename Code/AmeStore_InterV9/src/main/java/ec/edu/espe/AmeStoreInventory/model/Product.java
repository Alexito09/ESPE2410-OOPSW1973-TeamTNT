package ec.edu.espe.AmeStoreInventory.model;

import java.util.Scanner;

/**
 *
 * @author TEMA TNT
 */
public class Product {
    private String id;
    private String name;
    private String description;
    private String category;
     private String size;
    private Integer quantity;
    private double price;
   
    private Scanner scanner = new Scanner(System.in);

    public Product(String id, String name, String description, String category, String size, Integer quantity, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.size = size;
        this.quantity = quantity;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

}

