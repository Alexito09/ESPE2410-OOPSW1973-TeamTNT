package ec.edu.espe.AmeStoreInventory.controller;

import ec.edu.espe.AmeStoreInventory.model.Customer;
import ec.edu.espe.AmeStoreInventory.utils.CloudDB;
import ec.edu.espe.AmeStoreInventory.utils.CustomerRepository;
import javax.swing.JOptionPane;

/**
 *
 * @author TEAM TNT
 */
public class CustomerController {
    CloudDB cloudDB = new CloudDB();
    public CustomerController() {
        this.cloudDB = new CloudDB();
    }

    public boolean validateIdentityCard(String id) {
        return id.matches("\\d{10}"); // Ejemplo de validación simple de cédula
    }

    public boolean validateEmail(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }

    public boolean addCustomer(String id, String name, String address, String email, String phone) {
        if (!validateIdentityCard(id)) {
            JOptionPane.showMessageDialog(null, "La cédula ingresada no es válida.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!validateEmail(email)) {
            JOptionPane.showMessageDialog(null, "El correo electrónico no es válido.", "Error", JOptionPane.ERROR_MESSAGE);
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
}
