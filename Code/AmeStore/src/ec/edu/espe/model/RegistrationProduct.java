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

    // Constructor
    public RegistrationProduct(String id, String category, String name, String size, int quantity, String color, double price) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.size = size;
        this.quantity = quantity;
        this.color = color;
        this.price = price;
    }

    // Getters and Setters
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
            return true; // Reducción exitosa
        }
        return false; // Stock insuficiente
    } //agregeeeeeee estos

    // Método para mostrar las prendas y precios sin pedir el precio
    public static  RegistrationProduct collectProductDetails(Category manCategory, Category womanCategory) {
        Scanner scanner = new Scanner(System.in);

        // Obtener ID del producto
        System.out.println("=== Register Product ===");
        System.out.print("Enter product ID: ");
        String id = scanner.nextLine();

        // Obtener categoría
        System.out.print("Enter category (man or woman): ");
        String category = scanner.nextLine();

        // Mostrar prendas según la categoría
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
        } else {
            System.out.println("Invalid category.");
            return null;
        }

        // Solicitar nombre del producto (y tomar el precio de la prenda seleccionada)
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        // Buscar la prenda seleccionada y obtener su precio
        ClothingItem selectedItem = null;
        if (category.equalsIgnoreCase("man")) {
            selectedItem = manCategory.getClothingItemByName(name);
        } else if (category.equalsIgnoreCase("woman")) {
            selectedItem = womanCategory.getClothingItemByName(name);
        }

        // Si la prenda no se encuentra, mostrar mensaje de error
        if (selectedItem == null) {
            System.out.println("Item not found.");
            return null;
        }

        // El precio se toma automáticamente de la prenda seleccionada
        double price = selectedItem.getPrice();
        System.out.println("The price of the " + name + " is: $" + price);

        // Solicitar tamaño
        System.out.print("Enter size (S, M, L, XL): ");
        String size = scanner.nextLine();

        // Solicitar color
        System.out.print("Enter color: ");
        String color = scanner.nextLine();

        // Solicitar cantidad
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

        // Crear y retornar el objeto RegistrationProduct con el precio tomado automáticamente
        return new RegistrationProduct(id, category, name, size, quantity, color, price);
    }
}