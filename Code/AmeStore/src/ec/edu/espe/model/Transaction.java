package ec.edu.espe.model;

import java.util.Date;

/**
 *
 * @author Team TNT
 */
public class Transaction {
        private String productId;
        private String productName;
        private int quantitySold;
        private double totalPrice;
        private String customerName;   
    private String customerId;  
    private String customerEmail;  
    private String customerPhone;  
    private String customerAddress;  

        public Transaction(String productId, String productName, int quantitySold, double totalPrice, String customerName, String customerId, String customerEmail, String customerPhone, String customerAddress) {
            this.productId = productId;
            this.productName = productName;
            this.quantitySold = quantitySold;
            this.totalPrice = totalPrice;
            this.customerName = customerName;
            this.customerId = customerId;
            this.customerEmail = customerEmail;
            this.customerPhone = customerPhone;
            this.customerAddress = customerAddress;
        }

   @Override  
    public String toString() {  
        return String.format(  
        "Product ID: %s | Product Name: %s | Quantity Sold: %d | Total Price: $%.2f | ",  
                productId,   
        productName,   
        quantitySold,   
        totalPrice,   
        customerName,   
        customerId,  
        customerEmail,     
        customerPhone,       
        customerAddress       
    );  
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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

}
     
   