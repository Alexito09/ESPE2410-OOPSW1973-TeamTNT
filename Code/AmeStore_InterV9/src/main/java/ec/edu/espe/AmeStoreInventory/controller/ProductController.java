package ec.edu.espe.AmeStoreInventory.controller;

import ec.edu.espe.AmeStoreInventory.model.Product;
import ec.edu.espe.AmeStoreInventory.utils.CloudDB;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
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
        this.tableModel = new DefaultTableModel(); 
    }

    public boolean isValidProductId(String id) {
        return id.matches("\\d+") && id.startsWith("0"); 
    }

    public Product createProduct(String id, String name, String description,  String category,  String size ,String quantityString,String priceString) {
      
        if (id.isEmpty() || name.isEmpty() || description.isEmpty()  || category.isEmpty() || size.isEmpty()|| quantityString.isEmpty()|| priceString.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios. Por favor, complételos.", "Error", JOptionPane.ERROR_MESSAGE);
            return null; 
        }


        if (!isValidProductId(id)) {
            JOptionPane.showMessageDialog(null, "El ID del producto debe ser numérico y comenzar con '0'.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        Integer quantity;
        Double price;

        try {
            quantity = Integer.parseInt(quantityString);
            if (quantity < 0) {
                JOptionPane.showMessageDialog(null, "La cantidad debe ser un número positivo.", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Cantidad no válida. Ingrese un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        try {
            price = Double.parseDouble(priceString);
            if (price < 0) {
                JOptionPane.showMessageDialog(null, "El precio debe ser un número positivo.", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Precio no válido. Ingrese un número decimal válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        return new Product(id, name, description, category,  size, quantity,price);
    }

    public void saveOrUpdateProduct(Product product) {
        if (product == null) {
            JOptionPane.showMessageDialog(null, "El producto no es válido. Verifique los datos ingresados.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

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
                doc.getString("category"), 
                doc.getString("size"),
                doc.getInteger("quantity"), 
                doc.getDouble("price")
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
                doc.getString("category"), 
                doc.getString("size"),
                doc.getInteger("quantity"), 
                doc.getDouble("price")
                };
                tableModel.addRow(rowData);
            }
        }
    }

    public boolean deleteProduct(int selectedRow, DefaultTableModel tableModel, JTable table) {
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(null, "Seleccione un producto para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    int confirm = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea eliminar este producto?", "Confirmación", JOptionPane.YES_NO_OPTION);
    if (confirm != JOptionPane.YES_OPTION) {
        return false;
    }

    String id = tableModel.getValueAt(selectedRow, 0).toString();

    try {
        cloudDB.deleteProduct(id);
        tableModel.removeRow(selectedRow);
        JOptionPane.showMessageDialog(null, "El producto ha sido eliminado.");
        return true;
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al eliminar el producto: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
}
    public void saveProduct(JTextField idFldText, JTextField nameFldText, JTextField descriptionFldText,
                        JTextField categoryFldText, JTextField sizeFldText, JTextField quantityFldText,
                        JTextField priceFldText, DefaultTableModel tableModel) {
    try {
        String id = idFldText.getText().trim();
        String name = nameFldText.getText().trim();
        String description = descriptionFldText.getText().trim();
        String category = categoryFldText.getText().trim();
        String size = sizeFldText.getText().trim();
        String quantityString = quantityFldText.getText().trim();
        String priceString = priceFldText.getText().trim();

        if (id.isEmpty() || name.isEmpty() || description.isEmpty() || category.isEmpty() ||
            size.isEmpty() || quantityString.isEmpty() || priceString.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios. Por favor, complételos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int quantity;
        double price;

        try {
            quantity = Integer.parseInt(quantityString);
            if (quantity < 0) {
                JOptionPane.showMessageDialog(null, "La cantidad debe ser un número positivo.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Cantidad no válida. Ingrese un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            price = Double.parseDouble(priceString);
            if (price < 0) {
                JOptionPane.showMessageDialog(null, "El precio debe ser un número positivo.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Precio no válido. Ingrese un número decimal válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Product product = new Product(id, name, description, category, size, quantity, price);

        if (cloudDB.productExists(id)) {
            cloudDB.updateProduct(product);
        } else {
            cloudDB.uploadProductData(product);
            JOptionPane.showMessageDialog(null, "Producto añadido correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        }

        tableModel.setRowCount(0);
        loadProducts(tableModel);

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Ocurrió un error al guardar el producto: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

public void loadProducts(DefaultTableModel tableModel) {
    tableModel.setRowCount(0);
    List<Document> products = cloudDB.getAllProducts();
    for (Document doc : products) {
        Object[] rowData = {
            doc.getString("id"),
            doc.getString("name"),
            doc.getString("description"),
            doc.getString("category"),
            doc.getString("size"),
            doc.getInteger("quantity"),
            doc.getDouble("price")
        };
        tableModel.addRow(rowData);
    }
}
}

