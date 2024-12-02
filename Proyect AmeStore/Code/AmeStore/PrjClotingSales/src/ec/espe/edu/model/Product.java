
package ec.espe.edu.model;

/**
 *
 * @author Lisbeth Tipan
 */
public class Product {
        private String name;
        private String category;
        private double price;
        private int currentStock;

    public Product(String name, String category, double price, int currentStock) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.currentStock = currentStock;
    }
   public void updateStock(int quantity) {
        this.currentStock += quantity; // Incrementa o decrementa el stock
    
   }

    public String getProduct() {
        return name + " - " + category;
    }

    public double calculatePrice() {
        return price * currentStock;
    
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(int currentStock) {
        this.currentStock = currentStock;
    }
    
}

