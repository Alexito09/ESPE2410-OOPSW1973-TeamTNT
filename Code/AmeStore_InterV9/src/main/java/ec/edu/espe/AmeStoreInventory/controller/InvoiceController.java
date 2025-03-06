
package ec.edu.espe.AmeStoreInventory.controller;

import ec.edu.espe.AmeStoreInventory.utils.CloudDB;
import ec.edu.espe.AmeStoreInventorySystem.view.FrmAddCustomer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;

public class InvoiceController{
    private CloudDB cloudDB;
    private DefaultTableModel tableModel;
    private JComboBox<String> cmbProductToAdd;
    private JTextField txtSubtotal;
    private JTextField txtIVA;
    private JTextField txtTotal;
    private JTextField txtid;
private JTextField txtCustomer;
private JTextField txtDirection;
private JTextField txtNumber;
private JTextField txtSearchProduct;
private JTable tblProductsAdded;
private JFrame parentFrame;

    public InvoiceController(CloudDB cloudDB, DefaultTableModel tableModel, JComboBox<String> cmbProductToAdd, JTextField txtSubtotal, JTextField txtIVA, JTextField txtTotal, JTextField txtid, JTextField txtCustomer, JTextField txtDirection, JTextField txtNumber, JTextField txtSearchProduct, JTable tblProductsAdded, JFrame parentFrame) {
        this.cloudDB = cloudDB;
        this.tableModel = tableModel;
        this.cmbProductToAdd = cmbProductToAdd;
        this.txtSubtotal = txtSubtotal;
        this.txtIVA = txtIVA;
        this.txtTotal = txtTotal;
        this.txtid = txtid;
        this.txtCustomer = txtCustomer;
        this.txtDirection = txtDirection;
        this.txtNumber = txtNumber;
        this.txtSearchProduct = txtSearchProduct;
        this.tblProductsAdded = tblProductsAdded;
        this.parentFrame = parentFrame;
    }







   




    
    public void addProductToTable(JSpinner spnQuantity) {
        String selectedProduct = (String) cmbProductToAdd.getSelectedItem();
            if (selectedProduct != null && !selectedProduct.equals("No encontrado")) {
            List<Document> products = cloudDB.getAllProducts();
            for (Document doc : products) {
            if (selectedProduct.equals(doc.getString("name"))) {
                int quantity = (int) spnQuantity.getValue();
           
                Double price = doc.getDouble("price");
            if (price == null) {
                
                JOptionPane.showMessageDialog(null, "Error: Precio no encontrado para el producto.", "Error", JOptionPane.ERROR_MESSAGE);
                break;
            }

            double subtotal = price * quantity;
            double total = subtotal; 

            
            Object[] rowData = {
                quantity,
                doc.getString("name"),
                price,
                subtotal,
                total
            };
            tableModel.addRow(rowData);

            
            calculateTotal();
            break;
        }
    }
}
    }
    public double[] calculateTotal() {
    double subtotal = 0.0;
    double ivaRate = 0.15;
    double iva;
    double total;

    for (int i = 0; i < tableModel.getRowCount(); i++) {
        Object value = tableModel.getValueAt(i, 3);
        
        if (value instanceof Double) {
            subtotal += (Double) value;
        } else {
            try {
                if (value instanceof String) {
                    subtotal += Double.parseDouble((String) value);
                }
            } catch (NumberFormatException e) {
                System.out.println("Error al convertir el valor en la fila " + i + " a Double: " + e.getMessage());
            }
        }
    }

    iva = subtotal * ivaRate;
    total = subtotal + iva;
    
    return new double[]{subtotal, iva, total};
}
     public void updateProductComboBox(String searchCriteria) {
        cmbProductToAdd.removeAllItems();
        List<Document> products = cloudDB.getAllProducts();
        for (Document doc : products) {
            if (doc.getString("name").toLowerCase().contains(searchCriteria.toLowerCase()) || 
                doc.getString("id").toLowerCase().contains(searchCriteria.toLowerCase())) {
                cmbProductToAdd.addItem(doc.getString("name"));
            }
        }
        if (cmbProductToAdd.getItemCount() == 0) {
            cmbProductToAdd.addItem("No encontrado");
        }
    }
    public void updateSpinnerQuantity(JSpinner spnQuantity) {
    String selectedProduct = (String) cmbProductToAdd.getSelectedItem();
    if (selectedProduct != null && !selectedProduct.equals("No encontrado")) {
        List<Document> products = cloudDB.getAllProducts();
        for (Document doc : products) {
            if (selectedProduct.equals(doc.getString("name"))) {
                int quantity = doc.getInteger("quantity");
                SpinnerNumberModel model = new SpinnerNumberModel(1, 1, quantity, 1);
                spnQuantity.setModel(model);
                spnQuantity.setValue(1);
                break;
            }
        }
    } else {
        SpinnerNumberModel model = new SpinnerNumberModel(0, 0, 0, 1);
        spnQuantity.setModel(model);
        spnQuantity.setValue(0);
    }
}


public void searchCustomer(JTextField txtid, JTextField txtCustomer, JTextField txtDirection, JTextField txtNumber, JFrame parentFrame) {
    String id = txtid.getText();
    Document customer = cloudDB.findCustomerByID(id);

    if (customer != null) {
        txtCustomer.setText(customer.getString("name"));
        txtDirection.setText(customer.getString("address"));
        txtNumber.setText(customer.getString("phone"));
    } else {
        int response = JOptionPane.showConfirmDialog(
            parentFrame,
            "Cliente no encontrado. ¿Desea agregar un nuevo cliente?",
            "Cliente no encontrado",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );
        if (response == JOptionPane.YES_OPTION) {
            FrmAddCustomer frmAddCustomer = new FrmAddCustomer();
            frmAddCustomer.setVisible(true);
        }
    }
}
public void saveInvoice() {

    
    String customerId = txtid.getText();
    String customerName = txtCustomer.getText();
    String customerAddress = txtDirection.getText();
    String customerPhone = txtNumber.getText();
    if (customerId.isEmpty()) {
        JOptionPane.showMessageDialog(parentFrame, "Porfavor ingresa un numero de cédula.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    List<Document> items = new ArrayList<>();
    for (int i = 0; i < tblProductsAdded.getRowCount(); i++) {
        int quantity = (int) tblProductsAdded.getValueAt(i, 0);
        String productName = (String) tblProductsAdded.getValueAt(i, 1);
        double price = (double) tblProductsAdded.getValueAt(i, 2);
        double subtotal = (double) tblProductsAdded.getValueAt(i, 3);
        double total = (double) tblProductsAdded.getValueAt(i, 4);

        Document item = new Document("quantity", quantity)
                .append("productName", productName)
                .append("price", price)
                .append("subtotal", subtotal)
                .append("total", total);
                
        items.add(item);
    }
Date currentDate = new Date();
    Document invoice = new Document("customerId", customerId)
            .append("customerName", customerName)
            .append("customerAddress", customerAddress)
            .append("customerPhone", customerPhone)
            .append("items", items)
            .append("subtotal", Double.valueOf(txtSubtotal.getText()))
            .append("iva", Double.valueOf(txtIVA.getText()))
            .append("total", Double.parseDouble(txtTotal.getText()))
                .append("date", currentDate); 
    System.out.println("Invoice to be saved: " + invoice.toJson());

    boolean success = cloudDB.saveInvoice(invoice); 
    if (success) {
        JOptionPane.showMessageDialog(parentFrame, "Factura guardada con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        
        
        InvoiceExport detailsView = new InvoiceExport(invoice);
        detailsView.setVisible(true);
  
        txtid.setText("");
        txtCustomer.setText("");
        txtDirection.setText("");
        txtNumber.setText("");
        txtSubtotal.setText("");
        txtIVA.setText("");
        txtTotal.setText("");
        txtSearchProduct.setText("");
        
        DefaultTableModel model = (DefaultTableModel) tblProductsAdded.getModel();
        model.setRowCount(0);
        
        
         cmbProductToAdd.setSelectedIndex(-1);
       
        for (int i = 0; i < tblProductsAdded.getRowCount(); i++) {
            
            ((DefaultTableModel) tblProductsAdded.getModel()).removeRow(0);
        }
    } else {
        JOptionPane.showMessageDialog(parentFrame, "Error al guardar la factura.", "Error", JOptionPane.ERROR_MESSAGE);
    }
 }
}



