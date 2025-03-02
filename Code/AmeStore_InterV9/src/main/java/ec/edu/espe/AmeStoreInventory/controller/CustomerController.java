package ec.edu.espe.AmeStoreInventory.controller;

import ec.edu.espe.AmeStoreInventory.model.Customer;
import ec.edu.espe.AmeStoreInventory.utils.CloudDB;
import ec.edu.espe.AmeStoreInventory.utils.CustomerRepository;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;

/**
 *
 * @author TEAM TNT
 */
public class CustomerController {
    CloudDB cloudDB = new CloudDB();
    public CustomerController(CloudDB cloudDB) {
        this.cloudDB = new CloudDB();
    }

    public boolean validateIdentityCard(String id) {
        return id.matches("\\d{10}"); 
    }

    public boolean validateEmail(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }

    public boolean validateName(String name) {
        return name.matches("^[A-Za-zÁÉÍÓÚáéíóúÑñ ]+$"); 
    }
    
    public boolean validatePhone(String phone) {
        return phone.matches("\\d+");
    }

    public boolean addCustomer(String id, String name, String address, String email, String phone) {
        
        if (id.isEmpty() || name.isEmpty() || address.isEmpty() || email.isEmpty() || phone.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios. Por favor, complételos.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (!validateIdentityCard(id)) {
            JOptionPane.showMessageDialog(null, "La cédula ingresada no es válida.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!validateEmail(email)) {
            JOptionPane.showMessageDialog(null, "El correo electrónico no es válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (!validateName(name)) {
            JOptionPane.showMessageDialog(null, "El nombre solo debe contener letras y espacios.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (!validatePhone(phone)) {
            JOptionPane.showMessageDialog(null, "El teléfono solo debe contener números.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        try {
            Customer customer = new Customer(id, name, address, email, phone);
            cloudDB.uploadCustomerData(customer); // Utiliza CustomerRepository
            JOptionPane.showMessageDialog(null, "Cliente agregado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar el cliente: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    public boolean IdentityCardValidation(String IdentityCard) {
        if (IdentityCard.length() != 10) {
            return false;
        }

        int provincia = Integer.parseInt(IdentityCard.substring(0, 2));
        if (provincia < 1 || provincia > 24) {
            return false;
        }

        int tercerDigito = Integer.parseInt(IdentityCard.substring(2, 3));
        if (tercerDigito < 0 || tercerDigito > 6) {
            return false;
        }

        int suma = 0;
        int[] coeficientes = { 2, 1, 2, 1, 2, 1, 2, 1, 2 };
        for (int i = 0; i < 9; i++) {
            int digito = Integer.parseInt(IdentityCard.substring(i, i + 1));
            int producto = digito * coeficientes[i];
            suma += (producto > 9) ? producto - 9 : producto;
        }

        int ultimoDigito = Integer.parseInt(IdentityCard.substring(9, 10));
        int decenaSuperior = ((suma + 9) / 10) * 10;
        int digitoVerificador = decenaSuperior - suma;

        return digitoVerificador == ultimoDigito;
    }
        public void updateCustomer(String id, String name, String address, String email, String phone, JTable tblCustomers) {
        if (id.isEmpty() || name.isEmpty() || address.isEmpty() || email.isEmpty() || phone.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, rellene todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Document updatedData = new Document("name", name)
                .append("address", address)
                .append("email", email)
                .append("phone", phone);

        cloudDB.updateCustomer(id, updatedData);
        loadAllCustomers(tblCustomers);
        JOptionPane.showMessageDialog(null, "Cliente actualizado exitosamente.", "Success", JOptionPane.INFORMATION_MESSAGE);
    }
    public boolean deleteCustomer(int selectedRow, JTable tblCustomers, DefaultTableModel model) {
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(null, "Por favor seleccione un cliente de la tabla.", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    String id = model.getValueAt(selectedRow, 0).toString();

    int confirmation = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea eliminar este cliente?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
    if (confirmation != JOptionPane.YES_OPTION) {
        return false;
    }

    boolean success = cloudDB.deleteCustomer(id);
    if (success) {
        JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente", "Success", JOptionPane.INFORMATION_MESSAGE);
        return true;
    } else {
        JOptionPane.showMessageDialog(null, "Error deleting customer. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
}
    public void loadAllCustomers(JTable tblCustomers) {
        List<Document> results = cloudDB.getAllCustomers();
        DefaultTableModel model = (DefaultTableModel) tblCustomers.getModel();
        model.setRowCount(0);

        for (Document doc : results) {
            model.addRow(new Object[]{
                doc.getString("id"),
                doc.getString("name"),
                doc.getString("address"),
                doc.getString("email"),
                doc.getString("phone")
            });
        }
    }


}
