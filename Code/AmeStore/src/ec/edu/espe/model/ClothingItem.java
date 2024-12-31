package ec.edu.espe.model;

/**
 * Autor Alexander Ullco
 */
public class ClothingItem {
    private String name;
    private double price;

    public ClothingItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ClothingItem{" + "name=" + name + ", price=" + price + '}';
    }
}
