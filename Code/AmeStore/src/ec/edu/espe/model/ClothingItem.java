package ec.edu.espe.model;

/**
 *
 * @author Team TNT
 */
public class ClothingItem {
    private String name;
   private double price;

    public ClothingItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "ClothingItem{" + "name=" + name + ", price=" + price + '}';
    }

 
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

    int getStock() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    boolean reduceStock(int quantity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
