
package ec.edu.espe.AmeStoreInventorySystem.view;

import ec.edu.espe.AmeStoreInventory.model.Product;
import ec.edu.espe.AmeStoreInventory.utils.CloudDB;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;



public class FrmEditProduct extends javax.swing.JFrame {

    /**
     * Creates new form FrmEditProduct
     */
    private CloudDB cloudDB;
    private DefaultTableModel tableModel;
    int xMouse, yMouse;
    
    public FrmEditProduct() {
        initComponents();
        cloudDB = new CloudDB();
        tableModel = (DefaultTableModel) jTable1.getModel();
        tableModel.setRowCount(0); 
        loadProducts();

        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    int selectedRow = jTable1.getSelectedRow();
                    if (selectedRow != -1) {
                        idFldText.setText(tableModel.getValueAt(selectedRow, 0).toString());
                        nameFldText.setText(tableModel.getValueAt(selectedRow, 1).toString());
                        descriptionFldText.setText(tableModel.getValueAt(selectedRow, 2).toString());
                        quantityFldText.setText(tableModel.getValueAt(selectedRow, 3).toString());
                        sizeFldText.setText(tableModel.getValueAt(selectedRow, 4).toString());
                        priceFldText.setText(tableModel.getValueAt(selectedRow, 5).toString());
                        categoryFldText.setText(tableModel.getValueAt(selectedRow, 6).toString());
                    }
                }
            }
        });
    }

    private void saveProduct() {
        try {
            String id = idFldText.getText();
            String name = nameFldText.getText();
            String description = descriptionFldText.getText();
            int quantity = Integer.parseInt(quantityFldText.getText());
            String size = sizeFldText.getText();
            double price = Double.parseDouble(priceFldText.getText());//falta try catch
                     
            String category = categoryFldText.getText();

            Product product = new Product(id, name, description, quantity, size, (float) price, category);

            if (cloudDB.productExists(id)) {
                cloudDB.updateProduct(product);
            } else {
                cloudDB.uploadProductData(product);
            }

            tableModel.setRowCount(0);
            loadProducts();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La cantidad y el precio deben ser números válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al guardar el producto: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
        
        
        private void loadProducts() {
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        editBtn = new javax.swing.JPanel();
        editBtnText = new javax.swing.JLabel();
        returnBtn = new javax.swing.JPanel();
        returnBtnText = new javax.swing.JLabel();
        idText = new javax.swing.JLabel();
        idFldText = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        nameText = new javax.swing.JLabel();
        nameFldText = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        descriptionText = new javax.swing.JLabel();
        descriptionFldText = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        categoryText = new javax.swing.JLabel();
        categoryFldText = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        priceText = new javax.swing.JLabel();
        priceFldText = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        sizeText = new javax.swing.JLabel();
        sizeFldText = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        quantityText = new javax.swing.JLabel();
        quantityFldText = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        exitBtn = new javax.swing.JPanel();
        exitTxt = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        editBtn.setBackground(new java.awt.Color(110, 37, 159));

        editBtnText.setBackground(new java.awt.Color(110, 37, 159));
        editBtnText.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        editBtnText.setForeground(new java.awt.Color(255, 255, 255));
        editBtnText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        editBtnText.setText("EDITAR");
        editBtnText.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editBtnText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editBtnTextMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editBtnTextMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editBtnTextMouseExited(evt);
            }
        });

        javax.swing.GroupLayout editBtnLayout = new javax.swing.GroupLayout(editBtn);
        editBtn.setLayout(editBtnLayout);
        editBtnLayout.setHorizontalGroup(
            editBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editBtnLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(editBtnText, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        editBtnLayout.setVerticalGroup(
            editBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editBtnLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(editBtnText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.add(editBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 460, 130, 30));

        returnBtn.setBackground(new java.awt.Color(110, 37, 159));

        returnBtnText.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        returnBtnText.setForeground(new java.awt.Color(255, 255, 255));
        returnBtnText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        returnBtnText.setText("REGRESAR");
        returnBtnText.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        returnBtnText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                returnBtnTextMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                returnBtnTextMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                returnBtnTextMouseExited(evt);
            }
        });

        javax.swing.GroupLayout returnBtnLayout = new javax.swing.GroupLayout(returnBtn);
        returnBtn.setLayout(returnBtnLayout);
        returnBtnLayout.setHorizontalGroup(
            returnBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, returnBtnLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(returnBtnText, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        returnBtnLayout.setVerticalGroup(
            returnBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, returnBtnLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(returnBtnText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.add(returnBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 460, 130, 30));

        idText.setFont(new java.awt.Font("Roboto Medium", 3, 15)); // NOI18N
        idText.setText("Id:");
        jPanel3.add(idText, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, -1, -1));

        idFldText.setBorder(null);
        idFldText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                idFldTextMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                idFldTextMouseExited(evt);
            }
        });
        idFldText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                idFldTextKeyReleased(evt);
            }
        });
        jPanel3.add(idFldText, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 130, -1));

        jSeparator1.setForeground(new java.awt.Color(69, 32, 130));
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 130, -1));

        nameText.setFont(new java.awt.Font("Roboto Medium", 3, 15)); // NOI18N
        nameText.setText("Nombre:");
        jPanel3.add(nameText, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        nameFldText.setBorder(null);
        jPanel3.add(nameFldText, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 280, -1));

        jSeparator3.setForeground(new java.awt.Color(69, 32, 130));
        jPanel3.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 280, 10));

        descriptionText.setFont(new java.awt.Font("Roboto Medium", 3, 15)); // NOI18N
        descriptionText.setText("Descripción:");
        jPanel3.add(descriptionText, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        descriptionFldText.setBorder(null);
        jPanel3.add(descriptionFldText, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 280, -1));

        jSeparator4.setForeground(new java.awt.Color(69, 32, 130));
        jPanel3.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 280, 10));

        categoryText.setFont(new java.awt.Font("Roboto Medium", 3, 15)); // NOI18N
        categoryText.setText("Categoría:");
        jPanel3.add(categoryText, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        categoryFldText.setBorder(null);
        jPanel3.add(categoryFldText, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 280, -1));

        jSeparator5.setForeground(new java.awt.Color(69, 32, 130));
        jPanel3.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 280, 10));

        priceText.setFont(new java.awt.Font("Roboto Medium", 3, 15)); // NOI18N
        priceText.setText("Precio:");
        jPanel3.add(priceText, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));

        priceFldText.setBorder(null);
        jPanel3.add(priceFldText, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 280, -1));

        jSeparator6.setForeground(new java.awt.Color(69, 32, 130));
        jPanel3.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 280, 10));

        sizeText.setFont(new java.awt.Font("Roboto Medium", 3, 15)); // NOI18N
        sizeText.setText("Tamaño:");
        jPanel3.add(sizeText, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        sizeFldText.setBorder(null);
        jPanel3.add(sizeFldText, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 280, -1));

        jSeparator7.setForeground(new java.awt.Color(69, 32, 130));
        jPanel3.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 280, 10));

        quantityText.setFont(new java.awt.Font("Roboto Medium", 3, 15)); // NOI18N
        quantityText.setText("Cantidad:");
        jPanel3.add(quantityText, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        quantityFldText.setBorder(null);
        jPanel3.add(quantityFldText, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 280, -1));

        jSeparator2.setForeground(new java.awt.Color(69, 32, 130));
        jPanel3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 280, 10));

        jPanel1.setBackground(new java.awt.Color(110, 37, 159));

        header.setBackground(new java.awt.Color(110, 37, 159));
        header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerMouseDragged(evt);
            }
        });
        header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerMousePressed(evt);
            }
        });

        exitBtn.setBackground(new java.awt.Color(110, 37, 159));

        exitTxt.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        exitTxt.setForeground(new java.awt.Color(242, 242, 242));
        exitTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitTxt.setText("X");
        exitTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        exitTxt.setPreferredSize(new java.awt.Dimension(40, 40));
        exitTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout exitBtnLayout = new javax.swing.GroupLayout(exitBtn);
        exitBtn.setLayout(exitBtnLayout);
        exitBtnLayout.setHorizontalGroup(
            exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, exitBtnLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(exitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        exitBtnLayout.setVerticalGroup(
            exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exitTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("EDITAR PRODUCTO");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap(276, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(244, 244, 244)
                .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exitBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 50));

        jTable1.setBackground(new java.awt.Color(204, 153, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "NOMBRE", "DESCRIPCIÓN", "CANTIDAD", "TAMAÑO", "PRECIO", "CATEGORÍA"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 660, 130));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editBtnTextMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editBtnTextMouseEntered
        editBtn.setBackground(new Color(110,80,159));
    }//GEN-LAST:event_editBtnTextMouseEntered

    private void editBtnTextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editBtnTextMouseExited
        editBtn.setBackground(new Color(110,37,159));
    }//GEN-LAST:event_editBtnTextMouseExited

    private void returnBtnTextMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnBtnTextMouseEntered
        returnBtn.setBackground(new Color(110,80,159));
    }//GEN-LAST:event_returnBtnTextMouseEntered

    private void returnBtnTextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnBtnTextMouseExited
        returnBtn.setBackground(new Color(110,37,159));
    }//GEN-LAST:event_returnBtnTextMouseExited

    private void idFldTextMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_idFldTextMouseEntered

    }//GEN-LAST:event_idFldTextMouseEntered

    private void idFldTextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_idFldTextMouseExited

    }//GEN-LAST:event_idFldTextMouseExited

    private void idFldTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idFldTextKeyReleased

    }//GEN-LAST:event_idFldTextKeyReleased

    private void editBtnTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editBtnTextMouseClicked
        saveProduct();
    }//GEN-LAST:event_editBtnTextMouseClicked

    private void returnBtnTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnBtnTextMouseClicked
        FrmMenuAmeStore frmUniversoDelFomix = new FrmMenuAmeStore();
        this.setVisible(false);
        frmUniversoDelFomix.setVisible(true);
    }//GEN-LAST:event_returnBtnTextMouseClicked

    private void exitTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseClicked
        System.exit(0);
    }//GEN-LAST:event_exitTxtMouseClicked

    private void exitTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseEntered
        exitBtn.setBackground(Color.red);
        exitTxt.setForeground(Color.white);
    }//GEN-LAST:event_exitTxtMouseEntered

    private void exitTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseExited
        exitBtn.setBackground(new Color(110,37,159));
        exitTxt.setForeground(Color.white);
    }//GEN-LAST:event_exitTxtMouseExited

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_headerMouseDragged

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmEditProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmEditProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmEditProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmEditProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmEditProduct().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField categoryFldText;
    private javax.swing.JLabel categoryText;
    private javax.swing.JTextField descriptionFldText;
    private javax.swing.JLabel descriptionText;
    private javax.swing.JPanel editBtn;
    private javax.swing.JLabel editBtnText;
    private javax.swing.JPanel exitBtn;
    private javax.swing.JLabel exitTxt;
    private javax.swing.JPanel header;
    private javax.swing.JTextField idFldText;
    private javax.swing.JLabel idText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nameFldText;
    private javax.swing.JLabel nameText;
    private javax.swing.JTextField priceFldText;
    private javax.swing.JLabel priceText;
    private javax.swing.JTextField quantityFldText;
    private javax.swing.JLabel quantityText;
    private javax.swing.JPanel returnBtn;
    private javax.swing.JLabel returnBtnText;
    private javax.swing.JTextField sizeFldText;
    private javax.swing.JLabel sizeText;
    // End of variables declaration//GEN-END:variables

    
}
