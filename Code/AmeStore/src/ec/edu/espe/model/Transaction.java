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

    /**
     * @return the productId
     */
    public String getProductId() {
        return productId;
    }

    /**
     * @param productId the productId to set
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return the quantitySold
     */
    public int getQuantitySold() {
        return quantitySold;
    }

    /**
     * @param quantitySold the quantitySold to set
     */
    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    /**
     * @return the totalPrice
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * @param totalPrice the totalPrice to set
     */
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
