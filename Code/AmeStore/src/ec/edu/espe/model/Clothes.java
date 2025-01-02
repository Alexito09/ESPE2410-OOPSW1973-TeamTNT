package ec.edu.espe.model;

/**
 * Derived class for specific clothes
 */
public class Clothes extends ClothingItem {
    private String idProduct;
    private String category;
    private String size;
    private String color;
    private int amount;

    public Clothes(String idProduct, String name, String category, String size, String color, double price, int amount) {
        super(name, price); // Llama al constructor de la clase padre
        this.idProduct = idProduct;
        this.category = category;
        this.size = size;
        this.color = color;
        this.amount = amount;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Clothes{" +
                "idProduct='" + idProduct + '\'' +
                ", category='" + category + '\'' +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", amount=" + amount +
                ", name='" + getName() + '\'' + 
                ", price=" + getPrice() +
                '}';
    }
}
