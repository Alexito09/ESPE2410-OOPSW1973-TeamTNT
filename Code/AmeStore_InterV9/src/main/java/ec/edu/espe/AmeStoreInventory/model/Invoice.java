package ec.edu.espe.AmeStoreInventory.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author TEAM TNT
 * 
 */
public class Invoice {
    private String id;
    private String customerName;
    private String customerAddress;
    private String customerPhone;
    private List<InvoiceItem> items;
    private double subtotal;
    private double iva;
    private double total;
    private Date fecha;

    public Invoice(String id, String customerName, String customerAddress, String customerPhone, List<InvoiceItem> items, double subtotal, double iva, double total, Date fecha) {
        this.id = id;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPhone = customerPhone;
        this.items = items;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
        this.fecha = fecha;
    }

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public List<InvoiceItem> getItems() {
        return items;
    }

    public void setItems(List<InvoiceItem> items) {
        this.items = items;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Invoice other = (Invoice) obj;
        if (Double.doubleToLongBits(this.subtotal) != Double.doubleToLongBits(other.subtotal)) {
            return false;
        }
        if (Double.doubleToLongBits(this.iva) != Double.doubleToLongBits(other.iva)) {
            return false;
        }
        if (Double.doubleToLongBits(this.total) != Double.doubleToLongBits(other.total)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.customerName, other.customerName)) {
            return false;
        }
        if (!Objects.equals(this.customerAddress, other.customerAddress)) {
            return false;
        }
        if (!Objects.equals(this.customerPhone, other.customerPhone)) {
            return false;
        }
        return Objects.equals(this.items, other.items);
    }

    
    

}
    
