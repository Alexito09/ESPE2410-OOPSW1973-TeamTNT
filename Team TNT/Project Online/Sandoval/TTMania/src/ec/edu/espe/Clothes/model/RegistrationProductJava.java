package ec.edu.espe.Clothes.model;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Alexander Ullco
 */
public class RegistrationProductJava {

    private String name;
    private String category;
    private String size;
    private int quantity;
    private String color;
    private double price;

    public RegistrationProductJava(String name, String category, String size, int quiantity, String color, double price) {
        this.name = name;
        this.category = category;
        this.size = size;
        this.quantity = quiantity;
        this.color = color;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "RegistrationProductJava{" + "name=" + name + ", category=" + category + ", size=" + size + ", quantity=" + quantity + ", color=" + color + ", price=" + price + '}';
    }
}
