package ec.edu.espe.model;

import ec.edu.espe.model.Category;
import ec.edu.espe.model.ClothingItem;
import java.util.Scanner;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import utils.ProductManager;

public class RegistrationProduct {
   private String id;
    private String category;
    private String name;
    private String size;
    private int quantity;
    private String color;
    private double price;

     public RegistrationProduct(String id, String category, String name, String size, int quantity, String color, double price) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.size = size;
        this.quantity = quantity;
        this.color = color;
        this.price = price;
    }

     public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return "RegistrationProduct{" +
               "id='" + id + '\'' +
               ", category='" + category + '\'' +
               ", name='" + name + '\'' +
               ", size='" + size + '\'' +
               ", quantity=" + quantity +
               ", color='" + color + '\'' +
               ", price=" + price +
               '}';
    }
    public boolean reduceStock(int quantity) {
        if (this.quantity >= quantity) {
            this.quantity -= quantity;
            return true;  
        }
        return false;  
    }  

     public static  RegistrationProduct collectProductDetails(Category manCategory, Category womanCategory) {
        Scanner scanner = new Scanner(System.in);

         System.out.println("=== Register Product ===");
        String id;
    while (true) {
    System.out.print("Enter product ID: ");
    id = scanner.nextLine();
    if (id.matches("[a-zA-Z0-9]+")) {
        break;
    } else {
        System.out.println("Invalid ID. Please enter only letters and numbers.");
    }
}
        String category;
            while (true) {
                    System.out.print("Enter category (man or woman): ");
                    category = scanner.nextLine().trim().toLowerCase();
                    if (category.equals("man") || category.equals("woman")) {
        break;
    } else {
        System.out.println("Invalid category. Please enter 'man' or 'woman'.");
    }
}


         if (category.equalsIgnoreCase("man")) {
    System.out.println("Available clothing items for men:");
    for (ClothingItem item : manCategory.getClothingItems()) {
        System.out.println(item.getName() + " - $" + item.getPrice());
    }
} else if (category.equalsIgnoreCase("woman")) {
    System.out.println("Available clothing items for women:");
    for (ClothingItem item : womanCategory.getClothingItems()) {
        System.out.println(item.getName() + " - $" + item.getPrice());
    }
}


        ClothingItem selectedItem = null;
        String name;
        while (true) {
    System.out.print("Enter product name: ");
    name = scanner.nextLine().trim();
    if (category.equalsIgnoreCase("man")) {
        selectedItem = manCategory.getClothingItemByName(name);
    } else if (category.equalsIgnoreCase("woman")) {
        selectedItem = womanCategory.getClothingItemByName(name);
    }
    if (selectedItem != null) {
        break;
    } else {
        System.out.println("Item not found in the selected category. Please try again.");
    }
}



        double price = selectedItem.getPrice();
        System.out.println("The price of the " + name + " is: $" + price);

         String size;
           while (true) {
            System.out.print("Enter size (S, M, L, XL): ");
             size = scanner.nextLine().trim().toUpperCase();
            if (size.equals("S") || size.equals("M") || size.equals("L") || size.equals("XL")) {
        break;
       } else {
        System.out.println("Invalid size. Please enter 'S', 'M', 'L', or 'XL'.");
        }
    }

        String color;
        while (true) {
        System.out.print("Enter color: ");
         color = scanner.nextLine().trim();
         if (color.matches("[a-zA-Z]+")) {
        break;
    } else {
        System.out.println("Invalid color...");
    }
}


         int quantity;
        while (true) {
         System.out.print("Enter quantity: ");
         if (scanner.hasNextInt()) {
        quantity = scanner.nextInt();
        if (quantity > 0) {
            break;
        } else {
            System.out.println("Quantity must be a positive number. Please try again.");
        }
    } else {
        System.out.println("Invalid input. Please enter a valid number for quantity.");
        scanner.next(); 
    }
}


         return new RegistrationProduct(id, category, name, size, quantity, color, price);

    }
}