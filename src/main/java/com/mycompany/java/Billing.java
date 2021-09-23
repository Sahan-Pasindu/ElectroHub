
package com.mycompany.java;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Billing extends javax.swing.JFrame {

    
    public Billing() {
        initComponents();
        table1load();
        table2load();
        txtQuantity.setText("1");
    }

    int XX,XY;
    Connection con = null;
    PreparedStatement pst = null,pst1,pst2;
    ResultSet rs,rsc;
    int productID,customerID,retailPrice,wholesalePrice,finalTotal,paidAmount,returnAmount;
    String description;
    DefaultTableModel model3;
    
    void table1load(){
        
        try {
             con = DBConnect.connect();
             String sql = "select * from customers";
             pst = con.prepareStatement(sql);
             rsc = pst.executeQuery();
             DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
             model.setRowCount(0);
             while(rsc.next()){
                    
                 model.addRow(new Object[] {rsc.getInt("customerID"),rsc.getString("name"),rsc.getInt("contactNum"),rsc.getString("email")});
             }
             
            
         } catch (SQLException ex) {
             Logger.getLogger(UpdateCustomer.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    
    }
    void table2load(){
        
        try {
             con = DBConnect.connect();
             
             
            String sql = "select * from products INNER JOIN stock ON products.productID = stock.productID" ;
             pst = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             rs = pst.executeQuery();
             DefaultTableModel model2 = (DefaultTableModel) jTable2.getModel();
             model2.setRowCount(0);
             while(rs.next()){
                 
                 if(rs.getString("activate").equals("Yes")){   
                    model2.addRow(new Object[] {rs.getInt("productID"),rs.getString("name"),rs.getString("category"),rs.getInt("retailPrice"),rs.getString("description"),rs.getString("amountInStock")});
                 }
                 
             }
             
             
         } catch (SQLException ex) {
             Logger.getLogger(UpdateCustomer.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCusName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtProID = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtProName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        jButton1 = new com.k33ptoo.components.KButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton2 = new com.k33ptoo.components.KButton();
        kButton4 = new com.k33ptoo.components.KButton();
        jButton5 = new com.k33ptoo.components.KButton();
        kButton8 = new com.k33ptoo.components.KButton();
        jLabel8 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        txtPaid = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtReturn = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1101, 831));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel1MouseReleased(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(110, 89, 222));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Name");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8_search_25px_4.png"))); // NOI18N
        jLabel2.setText("Select Customer");

        txtCusName.setBackground(new Color(0,0,0,0));
        txtCusName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtCusName.setForeground(new java.awt.Color(255, 255, 255));
        txtCusName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtCusName.setOpaque(false);
        txtCusName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCusNameKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Contact No");

        jTextField2.setBackground(new Color(0,0,0,0));
        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));
        jTextField2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jTextField2.setOpaque(false);
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer ID", "Name", "Contact Number", "Email"
            }
        ));
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setSelectionBackground(new java.awt.Color(110, 89, 222));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 975, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtCusName, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(txtCusName, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8_search_25px_5.png"))); // NOI18N
        jLabel4.setText("Select Item");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("ID");

        txtProID.setBackground(new Color(0,0,0,0));
        txtProID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtProID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtProID.setOpaque(false);
        txtProID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtProIDKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Name");

        txtProName.setBackground(new Color(0,0,0,0));
        txtProName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtProName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtProName.setOpaque(false);
        txtProName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtProNameKeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Quantity");

        txtQuantity.setBackground(new Color(0,0,0,0));
        txtQuantity.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtQuantity.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtQuantity.setOpaque(false);
        txtQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtQuantityKeyTyped(evt);
            }
        });

        jButton1.setBorder(null);
        jButton1.setText("ADD");
        jButton1.setToolTipText("");
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButton1.setkBorderRadius(40);
        jButton1.setkEndColor(new java.awt.Color(0, 204, 204));
        jButton1.setkFillButton(false);
        jButton1.setkForeGround(new java.awt.Color(0, 0, 0));
        jButton1.setkHoverEndColor(new java.awt.Color(204, 0, 204));
        jButton1.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        jButton1.setkHoverStartColor(new java.awt.Color(0, 204, 204));
        jButton1.setkPressedColor(new java.awt.Color(255, 0, 102));
        jButton1.setkStartColor(new java.awt.Color(204, 0, 204));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Name", "Category", "Retail Price", "Description", "In Stock"
            }
        ));
        jTable2.setGridColor(new java.awt.Color(255, 255, 255));
        jTable2.setSelectionBackground(new java.awt.Color(110, 89, 222));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jTable3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Name", "Description", "Price", "Quantity", "Total"
            }
        ));
        jTable3.setGridColor(new java.awt.Color(255, 255, 255));
        jTable3.setSelectionBackground(new java.awt.Color(110, 89, 222));
        jScrollPane3.setViewportView(jTable3);

        jButton2.setBorder(null);
        jButton2.setText("Save");
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButton2.setkBorderRadius(40);
        jButton2.setkEndColor(new java.awt.Color(0, 204, 204));
        jButton2.setkFillButton(false);
        jButton2.setkForeGround(new java.awt.Color(0, 0, 0));
        jButton2.setkHoverEndColor(new java.awt.Color(204, 0, 204));
        jButton2.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        jButton2.setkHoverStartColor(new java.awt.Color(0, 204, 204));
        jButton2.setkPressedColor(new java.awt.Color(255, 0, 102));
        jButton2.setkStartColor(new java.awt.Color(204, 0, 204));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        kButton4.setBorder(null);
        kButton4.setText("Reset");
        kButton4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        kButton4.setkBorderRadius(40);
        kButton4.setkEndColor(new java.awt.Color(0, 204, 204));
        kButton4.setkHoverEndColor(new java.awt.Color(204, 0, 204));
        kButton4.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton4.setkHoverStartColor(new java.awt.Color(0, 204, 204));
        kButton4.setkPressedColor(new java.awt.Color(204, 204, 204));
        kButton4.setkStartColor(new java.awt.Color(204, 0, 204));
        kButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton4ActionPerformed(evt);
            }
        });

        jButton5.setBorder(null);
        jButton5.setText("Remove");
        jButton5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButton5.setkBorderRadius(40);
        jButton5.setkEndColor(new java.awt.Color(0, 204, 204));
        jButton5.setkHoverEndColor(new java.awt.Color(204, 0, 204));
        jButton5.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        jButton5.setkHoverStartColor(new java.awt.Color(0, 204, 204));
        jButton5.setkPressedColor(new java.awt.Color(204, 204, 204));
        jButton5.setkStartColor(new java.awt.Color(204, 0, 204));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        kButton8.setBorder(null);
        kButton8.setText("Back");
        kButton8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        kButton8.setkBorderRadius(40);
        kButton8.setkEndColor(new java.awt.Color(0, 204, 204));
        kButton8.setkHoverEndColor(new java.awt.Color(204, 0, 204));
        kButton8.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton8.setkHoverStartColor(new java.awt.Color(0, 204, 204));
        kButton8.setkPressedColor(new java.awt.Color(204, 204, 204));
        kButton8.setkStartColor(new java.awt.Color(204, 0, 204));
        kButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton8ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Total");

        txtTotal.setEditable(false);
        txtTotal.setBackground(new Color(0,0,0,0));
        txtTotal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTotal.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtTotal.setOpaque(false);
        txtTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTotalKeyTyped(evt);
            }
        });

        txtPaid.setBackground(new Color(0,0,0,0));
        txtPaid.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtPaid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtPaid.setOpaque(false);
        txtPaid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPaidKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPaidKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Paid Amount");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Balance");

        txtReturn.setEditable(false);
        txtReturn.setBackground(new Color(0,0,0,0));
        txtReturn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtReturn.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtReturn.setOpaque(false);
        txtReturn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtReturnKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 975, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel8))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtPaid, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(kButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(kButton8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(57, 57, 57)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtProID, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(99, 99, 99)
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtProName, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(74, 74, 74)
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(52, 52, 52))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(53, 53, 53))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(txtProID, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(txtProName, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(txtPaid, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(kButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(txtReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(kButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        this.setOpacity((float)0.8);
        XX=evt.getX();
        XY=evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseReleased
        this.setOpacity((float)1.0);
    }//GEN-LAST:event_jPanel1MouseReleased

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-XX, y-XY);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       int row = jTable1.getSelectedRow();
       customerID = (int) jTable1.getValueAt(row, 0);
       String name = (String) jTable1.getValueAt(row, 1);
       int contact = (int) jTable1.getValueAt(row, 2);
       jTextField2.setText(String.valueOf(contact));
       txtCusName.setText(name);

    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        int row = jTable2.getSelectedRow();
        retailPrice= (int) jTable2.getValueAt(row, 3);
        productID = (int) jTable2.getValueAt(row, 0);
        String name = (String) jTable2.getValueAt(row, 1);
        txtProID.setText(String.valueOf(productID));
        txtProName.setText(name);
        try {
            rs.absolute(row+1);
            wholesalePrice = rs.getInt("wholesalePrice");
            description = rs.getString("description");
        } catch (SQLException ex) {
            Logger.getLogger(Billing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void txtCusNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCusNameKeyReleased
        jTextField2.setText("");
        String name = txtCusName.getText();
        String sql = "select * from customers where name LIKE '%"+name+"%'";
            
         try {
             con = DBConnect.connect();
             pst = con.prepareStatement(sql);
             rsc = pst.executeQuery();
             DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
             model.setRowCount(0);
             while(rsc.next()){
                    
                 model.addRow(new Object[] {rsc.getInt("customerID"),rsc.getString("name"),rsc.getInt("contactNum"),rsc.getString("email")});
             }
             con.close();
         } catch (SQLException ex) {
             Logger.getLogger(UpdateCustomer.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_txtCusNameKeyReleased

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        txtCusName.setText("");
        String contact = jTextField2.getText();
        String sql = "select * from customers where contactNum LIKE '%"+contact+"%'";
            
         try {
             con = DBConnect.connect();
             pst = con.prepareStatement(sql);
             rsc = pst.executeQuery();
             DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
             model.setRowCount(0);
             while(rsc.next()){
                    
                 model.addRow(new Object[] {rsc.getInt("customerID"),rsc.getString("name"),rsc.getInt("contactNum"),rsc.getString("email")});
             }
             con.close();
         } catch (SQLException ex) {
             Logger.getLogger(UpdateCustomer.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_jTextField2KeyReleased

    private void txtProIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProIDKeyReleased
        String ID = txtProID.getText();
        productID = Integer.parseInt(ID);
        String sql = "select products.productID,products.name,products.category,stock.amountInStock,products.retailPrice,products.wholesalePrice,products.description,products.activate "
                        + "From products INNER JOIN stock ON products.productID = stock.productID AND products.productID ='"+ID+"'";
            
         try {
             con = DBConnect.connect();
             pst = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             rs = pst.executeQuery();
             DefaultTableModel model1 = (DefaultTableModel) jTable2.getModel();
             model1.setRowCount(0);
             if(rs.next()){
                 if(rs.getString("activate").equals("Yes")){   
                 model1.addRow(new Object[] {rs.getInt("productID"),rs.getString("name"),rs.getString("category"),rs.getInt("retailPrice"),rs.getString("description"),rs.getString("amountInStock")});
                 txtProName.setText(rs.getString("name"));
                 jTable2.setRowSelectionInterval(0, 0);
                 retailPrice= (int) jTable2.getValueAt(0, 3);
                 productID = (int) jTable2.getValueAt(0, 0);
                 String name = (String) jTable2.getValueAt(0, 1);
                 wholesalePrice = rs.getInt("wholesalePrice");
                 description = rs.getString("description");
                 
                 }
            }
            
         } catch (SQLException ex) {
             Logger.getLogger(UpdateCustomer.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_txtProIDKeyReleased

    private void txtProNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProNameKeyReleased
        String name = txtProName.getText();
      
        
        String sql = "select products.productID,products.name,products.category,stock.amountInStock,products.retailPrice,products.wholesalePrice,products.description,products.activate "
                        + "From products INNER JOIN stock ON products.productID = stock.productID AND products.name like '%"+name+"%'";
            
         try {
             con = DBConnect.connect();
             pst = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             rs = pst.executeQuery();
             DefaultTableModel model2 = (DefaultTableModel) jTable2.getModel();
             model2.setRowCount(0);
             while(rs.next()){
                 
                 if(rs.getString("activate").equals("Yes")){   
                    model2.addRow(new Object[] {rs.getInt("productID"),rs.getString("name"),rs.getString("category"),rs.getInt("retailPrice"),rs.getString("description"),rs.getString("amountInStock")});
                 }
                 
             }
            
         } catch (SQLException ex) {
             Logger.getLogger(UpdateCustomer.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_txtProNameKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int quantity = Integer.parseInt(txtQuantity.getText());
        int total = quantity*retailPrice;
        int row = jTable2.getSelectedRow();
        if(Integer.valueOf((String)jTable2.getValueAt(row, 5))>quantity){
            if(!jTable2.getSelectionModel().isSelectionEmpty()){
                if(Integer.valueOf((String)jTable2.getValueAt(row, 5))>0){
                    finalTotal = finalTotal + total;
                    txtTotal.setText(String.valueOf(finalTotal));
                    txtTotal.setEditable(false);
                    model3 = (DefaultTableModel) jTable3.getModel();
                    model3.addRow(new Object[] {txtProID.getText(),txtProName.getText(),description,retailPrice,txtQuantity.getText(),total});
                }
                    else{
                    JOptionPane.showMessageDialog(this,"Out of Stock!");
                }
            }
            else{
                JOptionPane.showMessageDialog(this,"Item not selected!");
            }
        }
        else{
            JOptionPane.showMessageDialog(this,"Quantity exceded!");
        
        }
            
        if(!txtPaid.getText().equals("")){
            paidAmount = Integer.parseInt(txtPaid.getText());
            returnAmount =paidAmount-finalTotal;
            if(returnAmount>=0){
                txtReturn.setText(String.valueOf(returnAmount));
            }
            else{
                txtReturn.setText("");
            }
            
        
        }
        txtProID.setText("");
        txtProName.setText("");
        txtQuantity.setText("1");
        txtProID.requestFocusInWindow();
        DefaultTableModel m = (DefaultTableModel) jTable2.getModel();
        m.setRowCount(0);
        table2load();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtPaidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPaidKeyReleased
        paidAmount = Integer.parseInt(txtPaid.getText());
         returnAmount =paidAmount-finalTotal;
        if(returnAmount>=0){
            txtReturn.setText(String.valueOf(returnAmount));
            txtReturn.setEditable(false);
        }
    }//GEN-LAST:event_txtPaidKeyReleased

    private void kButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton4ActionPerformed
        new Billing().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_kButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(paidAmount>=finalTotal){
            if(!jTable1.getSelectionModel().isSelectionEmpty()){    
                if(jTable3.getRowCount()!=0){ 
        
                        java.util.Date date =  Calendar.getInstance().getTime();
                        DateFormat dateFormatDate = new SimpleDateFormat("yyyy-MM-dd");
                        DateFormat dateFormat1Time = new SimpleDateFormat("hh:mm:ss");
                        String strDate = dateFormatDate.format(date);
                        String strTime = dateFormat1Time.format(date);
        
                        int lastInsertKey = 0;
        
                    try {
                            con = DBConnect.connect();
            
                            String sql1="insert into sales(customerID,subtotal,pay,balance,time,date) values('"+customerID+"','"+finalTotal+"','"+paidAmount+"','"+returnAmount+"','"+strTime+"','"+strDate+"')";
                            pst1=con.prepareStatement(sql1,java.sql.Statement.RETURN_GENERATED_KEYS);
                            pst1.executeUpdate();
                            ResultSet generatedKey = pst1.getGeneratedKeys();
                    
                            if(generatedKey.next()){         
                                lastInsertKey = generatedKey.getInt(1);
                            }
            
                            String sql2="insert into sales_products(sales_id,product_id,name,price,wprice,quantity,total) values(?,?,?,?,?,?,?)";
                        
            
                            for(int i=0;i<jTable3.getRowCount();i++){
                                String product_id = (String)jTable3.getValueAt(i,0);
                                String name =(String)jTable3.getValueAt(i,1);
                                String price =Integer.toString((int) jTable3.getValueAt(i,3));
                                int quantity = Integer.parseInt((String)jTable3.getValueAt(i,4)) ;
                                String total = Integer.toString((int) jTable3.getValueAt(i,5));
                                pst1=con.prepareStatement(sql2);
                                pst1.setInt(1,lastInsertKey);
                                pst1.setString(2,product_id);
                                pst1.setString(3,name);
                                pst1.setString(4,price);
                                pst1.setInt(6,quantity);
                                pst1.setString(7,total);
                            
                                String sql3 = "select wholesalePrice from products where productID='"+product_id+"'";
                                pst2 = con.prepareStatement(sql3);
                                rs=pst2.executeQuery();
                                rs.next();
                                int wprice = rs.getInt("wholesalePrice");
                            
                                pst1.setInt(5,wprice );
                                pst1.executeUpdate();
            
                            }
                            for(int i=0;i<jTable3.getRowCount();i++){
                            String sql4="Update stock set amountInStock =amountInStock - '"+(String) jTable3.getValueAt(i,4)+"' where productID ='"+(String)jTable3.getValueAt(i,0)+"'";
                                pst1=con.prepareStatement(sql4);
                                pst1.executeUpdate();
                             
                            }
                            JOptionPane.showMessageDialog(this,"Success!!");
            
                            HashMap map = new HashMap();
                            map.put("IN", lastInsertKey);
                            
                            try {
                                JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\Sahan Pasindu\\Desktop\\ElectroHub\\src\\main\\java\\com\\mycompany\\java\\report1.jrxml");
                                JasperReport ireport = JasperCompileManager.compileReport(jdesign);
                                JasperPrint  jprint  = JasperFillManager.fillReport(ireport,map,con);
                                JasperViewer.viewReport(jprint, false);
                                //JasperPrintManager.printReport(jprint, false);
                
                            } catch (JRException ex) {
                                Logger.getLogger(Billing.class.getName()).log(Level.SEVERE, null, ex);
                            }
            
                        } catch (SQLException ex) {
                            Logger.getLogger(Billing.class.getName()).log(Level.SEVERE, null, ex);
                        }
                
                   Billing a= new Billing();
                   a.setVisible(true);
                   a.setLocationRelativeTo(null);
                   this.dispose();
                
                }
                else{
                    JOptionPane.showMessageDialog(this,"Cart is Empty!","",JOptionPane.ERROR_MESSAGE);
            
                }
            }
            else{
                JOptionPane.showMessageDialog(this,"Select Customer!","",JOptionPane.ERROR_MESSAGE);
            
                }
        }
        else{
            JOptionPane.showMessageDialog(this,"Balance cannot be Calculated!","",JOptionPane.ERROR_MESSAGE);
        
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
            int selectedrow = jTable3.getSelectedRow();
       model3.removeRow(selectedrow);
       int count =jTable3.getRowCount();
       int subtotal=0;
       for(int i=0;i<count;i++){
           subtotal=subtotal+(int)jTable3.getValueAt(i,5);
       }
       txtTotal.setText(String.valueOf(subtotal));
       finalTotal=subtotal;
       paidAmount = Integer.parseInt(txtPaid.getText());
         returnAmount =paidAmount-finalTotal;
        if(returnAmount>0){
            txtReturn.setText(String.valueOf(returnAmount));
            txtReturn.setEditable(false);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtQuantityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantityKeyTyped
        char c = evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
        }
    }//GEN-LAST:event_txtQuantityKeyTyped

    private void kButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton8ActionPerformed
      this.dispose();
      MainBody a = new MainBody();
      a.setVisible(true);
      a.setLocationRelativeTo(null);
    }//GEN-LAST:event_kButton8ActionPerformed

    private void txtTotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalKeyTyped
        char c = evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
        }

    }//GEN-LAST:event_txtTotalKeyTyped

    private void txtPaidKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPaidKeyTyped
        char c = evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
        }

    }//GEN-LAST:event_txtPaidKeyTyped

    private void txtReturnKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtReturnKeyTyped
        char c = evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
        }

    }//GEN-LAST:event_txtReturnKeyTyped

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
            java.util.logging.Logger.getLogger(Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Billing().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton jButton1;
    private com.k33ptoo.components.KButton jButton2;
    private com.k33ptoo.components.KButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField2;
    private com.k33ptoo.components.KButton kButton4;
    private com.k33ptoo.components.KButton kButton8;
    private javax.swing.JTextField txtCusName;
    private javax.swing.JTextField txtPaid;
    private javax.swing.JTextField txtProID;
    private javax.swing.JTextField txtProName;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtReturn;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
