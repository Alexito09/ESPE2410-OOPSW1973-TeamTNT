package ec.edu.espe.model;

import java.util.Scanner;

public class RegistrationProduct {
    private String id;
    private String category;
    private String size;
    private int quantity;
    private String color;
    private double price;

    public RegistrationProduct(String id, String category, String size, int quantity, String color, double price) {
        this.id = id;
        this.category = category;
        this.size = size;
        this.quantity = quantity;
        this.color = color;
        this.price = price;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
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
               ", size='" + size + '\'' +
               ", quantity=" + quantity +
               ", color='" + color + '\'' +
               ", price=" + price +
               '}';
    }

    public static RegistrationProduct collectProductDetails() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Save clothing order data to JSON file");
        System.out.println("Enter the details of the order:");

        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        System.out.print("Man or woman: ");
        String category = scanner.nextLine();

        System.out.print("S, M, L, XL: ");
        String size = scanner.nextLine();

        System.out.print("Color type: ");
        String color = scanner.nextLine();

        System.out.print("The price is: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        int quantity = 0;
        System.out.print("How many units do you want: ");
        if (scanner.hasNextInt()) {
            quantity = scanner.nextInt();
        } else {
            System.out.println("Complete");
            scanner.next(); // Clear the invalid input
        }

        return new RegistrationProduct(name, category, size, quantity, color, price);
    }
}
