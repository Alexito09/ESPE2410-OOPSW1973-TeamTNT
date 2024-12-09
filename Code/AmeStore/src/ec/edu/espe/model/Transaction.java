package ec.edu.espe.model;

import java.util.Date;

/**
 *
 * @author USUARIO
 */
public class Transaction {
        private String productId;
        private String productName;
        private int quantitySold;
        private double totalPrice;

    public Transaction(String productId, String productName, int quantitySold, double totalPrice) {
        this.productId = productId;
        this.productName = productName;
        this.quantitySold = quantitySold;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Transaction{" + "productId=" + productId + ", productName=" + productName + ", quantitySold=" + quantitySold + ", totalPrice=" + totalPrice + '}';
    }

     
    public String getProductId() {
        return productId;
    }

    
    public void setProductId(String productId) {
        this.productId = productId;
    }

    
    public String getProductName() {
        return productName;
    }

  
    public void setProductName(String productName) {
        this.productName = productName;
    }

  
    public int getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    
    public double getTotalPrice() {
        return totalPrice;
    }

 
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
