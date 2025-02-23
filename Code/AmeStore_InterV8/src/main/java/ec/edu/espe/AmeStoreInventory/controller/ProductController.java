package ec.edu.espe.AmeStoreInventory.controller;

import ec.edu.espe.AmeStoreInventory.model.Product;
import ec.edu.espe.AmeStoreInventory.utils.CloudDB;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;
/**
 *
 * @author TEMA TNT
 */
public class ProductController {
    private CloudDB cloudDB;
    private DefaultTableModel tableModel;
    
    public ProductController() {
        this.cloudDB = new CloudDB();
        this.tableModel = tableModel;
    }

    public boolean isValidProductId(String id) {
        return id.matches("\\d*") && id.startsWith("0");
    }

    public Product createProduct(String id, String name, String description, String quantityString, String category, String priceString, String size) {
        int quantity;
        float price;

        try {
            quantity = Integer.parseInt(quantityString);
        } catch (NumberFormatException e) {
            quantity = 0;
            JOptionPane.showMessageDialog(null, "Cantidad no válida. Se usará 0.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }

        try {
            price = Float.parseFloat(priceString);
        } catch (NumberFormatException e) {
            price = 0.0f;
            JOptionPane.showMessageDialog(null, "Precio no válido. Se usará 0.0.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }

        return new Product(id, name, description, quantity, category, price, size);
    }

    public void saveOrUpdateProduct(Product product) {
        try {
            if (cloudDB.productExists(product.getId())) {
                cloudDB.updateProduct(product);
                JOptionPane.showMessageDialog(null, "Producto actualizado exitosamente!");
            } else {
                cloudDB.uploadProductData(product);
                JOptionPane.showMessageDialog(null, "Producto añadido exitosamente!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al añadir producto: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void loadProducts() {
        tableModel.setRowCount(0);
        List<Document> products = cloudDB.getAllProducts();
        for (Document doc : products) {
            Object[] rowData = {
                doc.getString("id"),
                doc.getString("name"),
                doc.getString("description"),
                doc.getInteger("quantity"),
                doc.getString("size"),
                doc.getDouble("price"),
                doc.getString("category")
            };
            tableModel.addRow(rowData);
        }
    }

    public void searchProduct(String searchCriteria) {
        tableModel.setRowCount(0);
        List<Document> products = cloudDB.getAllProducts();
        for (Document doc : products) {
            if (doc.getString("name").toLowerCase().contains(searchCriteria.toLowerCase()) || 
                doc.getString("id").toLowerCase().contains(searchCriteria.toLowerCase())) {
                Object[] rowData = {
                    doc.getString("id"),
                    doc.getString("name"),
                    doc.getString("description"),
                    doc.getInteger("quantity"),
                    doc.getString("size"),
                    doc.getDouble("price"),
                    doc.getString("category")
                };
                tableModel.addRow(rowData);
            }
        }
    }

    public void deleteProduct(int selectedRow) {
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Por favor seleccione un producto para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String id = tableModel.getValueAt(selectedRow, 0).toString();
        try {
            cloudDB.deleteProduct(id);
            tableModel.removeRow(selectedRow);
            JOptionPane.showMessageDialog(null, "El producto se ha eliminado.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la eliminación: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
