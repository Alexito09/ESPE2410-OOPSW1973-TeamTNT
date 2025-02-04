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
import java.util.ArrayList;
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

    public InvoiceController(org.bson.Document invoiceData) {
        
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

 
        btnExportPDF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exportToPDF(invoiceData);
            }
        });

        btnPrint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printInvoice();
            }
        });

        buttonPanel.add(btnExportPDF);
        buttonPanel.add(btnPrint);

        add(buttonPanel, BorderLayout.SOUTH);

      
        StringBuilder invoiceDetails = new StringBuilder();
      
        invoiceDetails.append("SISTEMA DE ROPA\n")
                .append("AME STORE\n")
                .append("@Team TNT\n")
                .append("*************************************************\n")
                .append("                      FACTURA                   \n")
                .append("*************************************************\n\n");

  
        invoiceDetails.append("Cédula:  ").append(invoiceData.getString("customerId")).append("\n")
                .append("Nombre:  ").append(invoiceData.getString("customerName")).append("\n")
                .append("Dirección:  ").append(invoiceData.getString("customerAddress")).append("\n")
                .append("Teléfono:  ").append(invoiceData.getString("customerPhone")).append("\n")
                .append("\n")
                .append("------------------------------------------------\n")
                .append("           DETALLES DE LOS PRODUCTOS           \n")
                .append("------------------------------------------------\n");

      
        List<org.bson.Document> items = (List<org.bson.Document>) invoiceData.get("items");
        for (org.bson.Document item : items) {
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

    
    private void exportToPDF(org.bson.Document invoiceData) {
        try {
     
            com.itextpdf.text.Document pdfDoc = new com.itextpdf.text.Document();
            PdfWriter.getInstance(pdfDoc, new FileOutputStream("Factura_AME_STORE.pdf"));
            pdfDoc.open();

         
            pdfDoc.add(new Paragraph("SISTEMA DE ROPA\n"));
            pdfDoc.add(new Paragraph("AME STORE\n"));
            pdfDoc.add(new Paragraph("@Team TNT\n"));
            pdfDoc.add(new Paragraph("************************************************\n"));
            pdfDoc.add(new Paragraph("                      FACTURA                   \n"));
            pdfDoc.add(new Paragraph("************************************************\n\n"));

         
            pdfDoc.add(new Paragraph("Cédula: " + invoiceData.getString("customerId")));
            pdfDoc.add(new Paragraph("Nombre: " + invoiceData.getString("customerName")));
            pdfDoc.add(new Paragraph("Dirección: " + invoiceData.getString("customerAddress")));
            pdfDoc.add(new Paragraph("Teléfono: " + invoiceData.getString("customerPhone")));
            pdfDoc.add(new Paragraph("\n"));
            pdfDoc.add(new Paragraph("------------------------------------------------"));
            pdfDoc.add(new Paragraph("           DETALLES DE LOS PRODUCTOS           "));
            pdfDoc.add(new Paragraph("------------------------------------------------\n"));

         
            List<org.bson.Document> items = (List<org.bson.Document>) invoiceData.get("items");
            for (org.bson.Document item : items) {
                pdfDoc.add(new Paragraph(String.format("%-5s %-20s %-10s %-10s %-10s",
                        item.getInteger("quantity"), 
                        item.getString("productName"), 
                        "$" + item.getDouble("price"), 
                        "$" + item.getDouble("subtotal"), 
                        "$" + item.getDouble("total"))));
            }

            pdfDoc.add(new Paragraph("\n"));
            pdfDoc.add(new Paragraph("------------------------------------------------"));
            pdfDoc.add(new Paragraph(String.format("%-35s %-15s\n", "Subtotal:", "$" + invoiceData.getDouble("subtotal"))));
            pdfDoc.add(new Paragraph(String.format("%-35s %-15s\n", "IVA:", "$" + invoiceData.getDouble("iva"))));
            pdfDoc.add(new Paragraph(String.format("%-35s %-15s\n", "Total:", "$" + invoiceData.getDouble("total"))));
            pdfDoc.add(new Paragraph("\n"));
            pdfDoc.add(new Paragraph("------------------------------------------------"));
            pdfDoc.add(new Paragraph("¡Gracias por tu compra en AME STORE!\n"));

          
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
            job.setPrintable(new Printable() {
                @Override
                public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
                    if (page >= 1) {
                        return Printable.NO_SUCH_PAGE;
                    }

                    g.translate((int) pf.getImageableX(), (int) pf.getImageableY());
                    txtInvoiceDetails.print(g);

                    return Printable.PAGE_EXISTS;
                }
            });

           
            if (job.printDialog()) {
                job.print();
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al imprimir la factura.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}