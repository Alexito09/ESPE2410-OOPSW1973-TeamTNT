
package ec.espe.edu.model;

import java.util.Date;

/**
 *
 * @author Lisbeth Tipan 
 */
public class Transaction {
    private Product product;
     private int quantity;
     private String type;
     private Date timeDate;
     private String user;

    public Transaction(Product product, String type, int quantity, Date timeDate, String user) {
        this.product = product;
        this.quantity = quantity;
        this.type = type;
        this.timeDate = timeDate;
        this.user = user;
    }
public void registerEntry(int quantity) {
    this.quantity = quantity;
        product.updateStock(quantity);
        System.out.println("Entrada registrada: " + quantity);
     
    }

    public void registerOutput(int quantity) {
        if (quantity <= product.getCurrentStock()) {
            product.updateStock(-quantity);
            System.out.println("Salida registrada: " + quantity);

           
        } else {
            System.out.println("No hay suficiente stock para registrar la salida.");
        }
    }
    public Report generateReport() {
        return new Report("Transacción Reporte", timeDate, new Date(), null);
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getTimeDate() {
        return timeDate;
    }

    public void setTimeDate(Date timeDate) {
        this.timeDate = timeDate;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }


}
