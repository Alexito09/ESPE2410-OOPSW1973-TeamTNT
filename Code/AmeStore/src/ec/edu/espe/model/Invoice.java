package ec.edu.espe.model;
import java.util.ArrayList;
import java.util.List; 
import java.lang.reflect.Type;
import java.util.Scanner;
import utils.ProductManager;
/**
 *
 * @author TEAM TNT
 */
public class Invoice{
     private String customerName;
    private String date;
    private String phoneNumber;
    private String address;
    private String email;
    private List<Transaction> transactions;
    private double total;
    
    public Invoice(String customerName, String date, String phoneNumber, String address, String email, List<Transaction> transactions) {
        this.customerName = customerName;
        this.date = date;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
        this.transactions = transactions;
        this.total = calculateTotal();
        
    }


    private double calculateTotal() {
        return transactions.stream().mapToDouble(Transaction::getTotalPrice).sum();
    }


    public void displayInvoice() {
        System.out.println("=== INVOICE ===");
        System.out.println("Customer Name: " + customerName);
        System.out.println("Date: " + date);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Address: " + address);
        System.out.println("Email: " + email);
        System.out.println("=== Transactions ===");
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
        System.out.println("Total: $" + total);
    }


    public static Invoice createInvoice(Scanner scanner, List<Transaction> transactionHistory) {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions available to generate an invoice.");
            return null;
        }

        String customerName;
    while (true) {
    System.out.print("Customer Name: ");
    customerName = scanner.nextLine();
    if (customerName.matches("^[a-zA-Z ]+$")) {
        break;
    } else {
        System.out.println("Invalid name. Please enter a valid name without numbers.");
    }
}


String date;
while (true) {
    System.out.print("Date (yyyy-MM-dd): ");
    date = scanner.nextLine();
    if (date.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
        break;
    } else {
        System.out.println("Invalid date format. Please enter a valid date in the format yyyy-MM-dd.");
    }
}


String phoneNumber;
while (true) {
    System.out.print("Phone Number: ");
    phoneNumber = scanner.nextLine();
    if (phoneNumber.matches("^\\d{7,}$")) {
        break;
    } else {
        System.out.println("Invalid phone number. Please enter a valid phone number with at least 7 digits.");
    }
}


System.out.print("Address: ");
String address = scanner.nextLine();


String email;
while (true) {
    System.out.print("Email: ");
    email = scanner.nextLine();
    if (email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
        break;
    } else {
        System.out.println("Invalid email. Please enter a valid email address.");
    }
}

    System.out.println("Customer details validated successfully!");
    Invoice invoice = new Invoice(customerName, date, phoneNumber, address, email, transactionHistory);
    ProductManager productManager = new ProductManager();
    productManager.saveToJsonObjectFile(invoice, "invoice.json");

    return invoice;
}
}