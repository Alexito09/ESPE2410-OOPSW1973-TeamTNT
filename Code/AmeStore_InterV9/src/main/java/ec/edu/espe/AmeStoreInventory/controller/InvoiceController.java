/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.AmeStoreInventory.controller;

import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import ec.edu.espe.AmeStoreInventory.model.ViewInvoice;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.bson.Document;




public class InvoiceController extends JFrame {
 private JTextArea txtInvoiceDetails;

    public InvoiceController(Document invoiceData) {
        setTitle("Factura - AME STORE");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        
        txtInvoiceDetails = new JTextArea();
        txtInvoiceDetails.setEditable(false);
        txtInvoiceDetails.setFocusable(false);
        txtInvoiceDetails.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(txtInvoiceDetails);
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        JButton btnExportPDF = new JButton("Exportar a PDF");
        JButton btnPrint = new JButton("Imprimir");

        btnExportPDF.addActionListener(e -> exportToPDF(invoiceData));
        btnPrint.addActionListener(e -> printInvoice());
        
        buttonPanel.add(btnExportPDF);
        buttonPanel.add(btnPrint);
        add(buttonPanel, BorderLayout.SOUTH);
        
        String currentDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        StringBuilder invoiceDetails = new StringBuilder();
        invoiceDetails.append("SISTEMA DE ROPA\n")
                .append("AME STORE\n")
                .append("@Team TNT\n")
                .append("*************************************************\n")
                .append("                      FACTURA                   \n")
                .append("Fecha: ").append(currentDate).append("\n")
                .append("*************************************************\n\n")
                .append("Cédula:  ").append(invoiceData.getString("customerId")).append("\n")
                .append("Nombre:  ").append(invoiceData.getString("customerName")).append("\n")
                .append("Dirección:  ").append(invoiceData.getString("customerAddress")).append("\n")
                .append("Teléfono:  ").append(invoiceData.getString("customerPhone")).append("\n\n")
                .append("------------------------------------------------\n")
                .append("           DETALLES DE LOS PRODUCTOS           \n")
                .append("------------------------------------------------\n");

        List<Document> items = (List<Document>) invoiceData.get("items");
        for (Document item : items) {
            invoiceDetails.append(String.format("%-5s %-20s %-10s %-10s %-10s\n", 
                    item.getInteger("quantity"), 
                    item.getString("productName"), 
                    "$" + item.getDouble("price"), 
                    "$" + item.getDouble("subtotal"), 
                    "$" + item.getDouble("total")));
        }

        invoiceDetails.append("\n")
                .append("------------------------------------------------\n")
                .append(String.format("%-35s %-15s\n", "Subtotal:", "$" + invoiceData.getDouble("subtotal")))
                .append(String.format("%-35s %-15s\n", "IVA:", "$" + invoiceData.getDouble("iva")))
                .append(String.format("%-35s %-15s\n", "Total:", "$" + invoiceData.getDouble("total")))
                .append("\n")
                .append("------------------------------------------------\n")
                .append("¡Gracias por tu compra en AME STORE!\n");
        
        txtInvoiceDetails.setText(invoiceDetails.toString());
    }

private void exportToPDF(Document invoiceData) {
    try {
        com.itextpdf.text.Document pdfDoc = new com.itextpdf.text.Document();
        String fileName = "Factura_AME_STORE_" + System.currentTimeMillis() + ".pdf";
        PdfWriter.getInstance(pdfDoc, new FileOutputStream(fileName));
        pdfDoc.open();

        // Formato de fecha
        String currentDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        // Agregar título y encabezados
        pdfDoc.add(new Paragraph("SISTEMA DE ROPA\n"));
        pdfDoc.add(new Paragraph("AME STORE\n"));
        pdfDoc.add(new Paragraph("@Team TNT\n"));
        pdfDoc.add(new Paragraph("************************************************\n"));
        pdfDoc.add(new Paragraph("                      FACTURA                   \n"));
        pdfDoc.add(new Paragraph("************************************************\n"));
        pdfDoc.add(new Paragraph("Fecha: " + currentDate + "\n"));
        pdfDoc.add(new Paragraph("************************************************\n\n"));
        
        // Información del cliente
        pdfDoc.add(new Paragraph("Cédula: " + invoiceData.getString("customerId")));
        pdfDoc.add(new Paragraph("Nombre: " + invoiceData.getString("customerName")));
        pdfDoc.add(new Paragraph("Dirección: " + invoiceData.getString("customerAddress")));
        pdfDoc.add(new Paragraph("Teléfono: " + invoiceData.getString("customerPhone")));
        
        // Detalles de los productos
        pdfDoc.add(new Paragraph("\n------------------------------------------------"));
        pdfDoc.add(new Paragraph("           DETALLES DE LOS PRODUCTOS           "));
        pdfDoc.add(new Paragraph("------------------------------------------------"));
        
        List<Document> items = (List<Document>) invoiceData.get("items");
        for (Document item : items) {
            pdfDoc.add(new Paragraph(String.format("%-5s %-20s %-10s %-10s %-10s", 
                    item.getInteger("quantity"), 
                    item.getString("productName"), 
                    "$" + item.getDouble("price"), 
                    "$" + item.getDouble("subtotal"), 
                    "$" + item.getDouble("total"))));
        }

        // Subtotal, IVA, Total
        pdfDoc.add(new Paragraph("\n------------------------------------------------"));
        pdfDoc.add(new Paragraph(String.format("%-35s %-15s", "Subtotal:", "$" + invoiceData.getDouble("subtotal"))));
        pdfDoc.add(new Paragraph(String.format("%-35s %-15s", "IVA:", "$" + invoiceData.getDouble("iva"))));
        pdfDoc.add(new Paragraph(String.format("%-35s %-15s", "Total:", "$" + invoiceData.getDouble("total"))));
        
        // Mensaje de agradecimiento
        pdfDoc.add(new Paragraph("\n------------------------------------------------"));
        pdfDoc.add(new Paragraph("¡Gracias por tu compra en AME STORE!"));

        // Cerrar el documento PDF
        pdfDoc.close();

        JOptionPane.showMessageDialog(this, "Factura exportada como PDF.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al exportar a PDF.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    
    private void printInvoice() {
        try {
            PrinterJob job = PrinterJob.getPrinterJob();
            job.setPrintable((g, pf, page) -> {
                if (page >= 1) return Printable.NO_SUCH_PAGE;
                g.translate((int) pf.getImageableX(), (int) pf.getImageableY());
                txtInvoiceDetails.print(g);
                return Printable.PAGE_EXISTS;
            });
            if (job.printDialog()) job.print();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al imprimir la factura.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}