package ec.edu.espe.AmeStoreInventory.controller;

import ec.edu.espe.AmeStoreInventory.model.Customer;
import ec.edu.espe.AmeStoreInventory.utils.CloudDB;
import javax.swing.JOptionPane;

/**
 *
 * 
 * 
 * @author TEAM TNT
 * 
 * 
 * 
 * 
 * 
 */
public class CustomerController {
    CloudDB cloudDB = new CloudDB();
    public boolean IdentityCardValidation(String IdentityCard) {
        if (IdentityCard.length() !=10){
            return false;
        }

        int provincia = Integer.parseInt(IdentityCard.substring(0,2));
        if (provincia < 1 || provincia > 24) {
            return false;
        }
        
        int tercerDigito = Integer.parseInt(IdentityCard.substring(2, 3));
        if (tercerDigito < 0 || tercerDigito > 6) {
            return false;
        }

        int suma = 0;
        int[] coeficientes = {2, 1, 2, 1, 2, 1, 2, 1, 2};
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
    public void addCustomerToDB(Customer customer){
        cloudDB.uploadCustomerData(customer);
        JOptionPane.showMessageDialog(null, "Customer added successfully!");
    }
}

