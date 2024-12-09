package ec.edu.espe.model;

/**
 *
 * @author USUARIO
 */
public class Clothes {
    private String idProduct;
    private String name;
    private String category;
    private String size;
    private String color;
    private double price;
    private int amount;

    @Override
    public String toString() {
        return "Clothes{" + "idProduct=" + idProduct + ", name=" + name + ", category=" + category + ", size=" + size + ", color=" + color + ", price=" + price + ", amount=" + amount + '}';
    }

    public Clothes(String idProduct, String name, String category, String size, String color, double price, int amount) {
        this.idProduct = idProduct;
        this.name = name;
        this.category = category;
        this.size = size;
        this.color = color;
        this.price = price;
        this.amount = amount;
    }

   
    public String getIdProduct() {
        return idProduct;
    }

    
    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
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


    public int getAmount() {
        return amount;
    }


    public void setAmount(int amount) {
        this.amount = amount;
    }
}
