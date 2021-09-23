/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.java;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class StockInternal extends javax.swing.JInternalFrame {

    /**
     * Creates new form StockInternal
     */
    public StockInternal() {
        initComponents();
        tableload();
    }

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs;
    String name;
    int amount,id;
     public void tableload(){
        try {
           
            con=DBConnect.connect();
            String sql = "select products.productID,products.name,products.category,stock.amountInStock,products.retailPrice,products.wholesalePrice,products.description,products.activate "
                    + "     From products INNER JOIN stock ON products.productID = stock.productID ";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
             model.setRowCount(0);
             while(rs.next()){
                    
                 model.addRow(new Object[] {rs.getInt("productID"),rs.getString("name"),rs.getString("category"),rs.getInt("amountInStock"),rs.getInt("retailPrice"),rs.getInt("wholesalePrice"),rs.getString("description"),rs.getString("activate")});
             }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(StockInternal.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        kButton3 = new com.k33ptoo.components.KButton();

        setMaximumSize(new java.awt.Dimension(1366, 651));
        setMinimumSize(new java.awt.Dimension(1366, 651));
        setOpaque(true);

        kGradientPanel1.setkEndColor(new java.awt.Color(204, 0, 204));
        kGradientPanel1.setkGradientFocus(50);
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 204, 204));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Filter By Category");

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Category", "TV Video and Audio", "Mobile Phones", "Cameras & Accessories", "Computer Accessories ", "Earphones & Headphones ", "Laptops & Desktops", "Mobile Accessories ", " " }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Search By Name");

        jTextField1.setBackground(new Color(0,0,0,0));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jTextField1.setOpaque(false);
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Product ID", "Product Name", "Category", "Amount In Stock", "Retail Price", "Wholesale Price", "Description", "Active Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setSelectionBackground(new java.awt.Color(110, 89, 222));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(5);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(5);
            jTable1.getColumnModel().getColumn(3).setMinWidth(5);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(5);
            jTable1.getColumnModel().getColumn(4).setMinWidth(10);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(10);
            jTable1.getColumnModel().getColumn(5).setMinWidth(10);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(10);
            jTable1.getColumnModel().getColumn(7).setMinWidth(5);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(5);
        }

        kButton3.setBorder(null);
        kButton3.setText("Delete");
        kButton3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        kButton3.setkBorderRadius(30);
        kButton3.setkEndColor(new java.awt.Color(0, 204, 204));
        kButton3.setkHoverEndColor(new java.awt.Color(204, 0, 204));
        kButton3.setkHoverForeGround(new java.awt.Color(255, 204, 255));
        kButton3.setkHoverStartColor(new java.awt.Color(0, 204, 204));
        kButton3.setkStartColor(new java.awt.Color(255, 0, 255));
        kButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(251, 251, 251)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(136, 136, 136)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(kButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
            try {
            jTextField1.setText("");
            String Category =(String)jComboBox1.getSelectedItem();
            System.out.println(Category);
            con=DBConnect.connect();
            String sql = "select * From products INNER JOIN stock ON products.productID = stock.productID AND products.category ='"+Category+"'";
            if(Category.equals("Select Category")){
                sql = "select * From products INNER JOIN stock ON products.productID = stock.productID";
            }
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
             model.setRowCount(0);
             while(rs.next()){
                    
                 model.addRow(new Object[] {rs.getInt("productID"),rs.getString("name"),rs.getString("category"),rs.getInt("amountInStock"),rs.getInt("retailPrice"),rs.getInt("wholesalePrice"),rs.getString("description"),rs.getString("activate")});
             }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(StockInternal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void kButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton3ActionPerformed
    if(!jTable1.getSelectionModel().isSelectionEmpty()){ 
        try {
            con= DBConnect.connect();
             java.util.Date date =  Calendar.getInstance().getTime();
             DateFormat dateFormatDate = new SimpleDateFormat("yyyy-MM-dd");
             DateFormat dateFormat1Time = new SimpleDateFormat("hh:mm:ss");
             String strDate = dateFormatDate.format(date);
             String strTime = dateFormat1Time.format(date);

            String sql1 = "Insert into stockhistory (productID,name,amount,action,date,time) values ('"+id+"','"+name+"','"+amount+"','REMOVED','"+strDate+"','"+strTime+"')";
            pst = con.prepareStatement(sql1);
            pst.executeUpdate();

            String sql2= "Delete from stock where productID = '"+id+"'";
            pst=con.prepareStatement(sql2);
            pst.executeUpdate();


            JOptionPane.showMessageDialog(null,"Successfully Removed!");
            tableload();
            jComboBox1.setSelectedIndex(0);
            jTextField1.setText("");


         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(this,"Delete Failed!","",JOptionPane.ERROR_MESSAGE);;
             Logger.getLogger(StockInternal.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    else{
        JOptionPane.showMessageDialog(this,"No item selected!");
    }
    }//GEN-LAST:event_kButton3ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        String name = jTextField1.getText();
        String Category = (String)jComboBox1.getSelectedItem();
        if(Category.equals("Select Category")){
        
            try {
           
            con=DBConnect.connect();
            String sql = "select * From products INNER JOIN stock ON products.productID = stock.productID AND products.name Like '%"+name+"%'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
             model.setRowCount(0);
             while(rs.next()){
                    
                 model.addRow(new Object[] {rs.getInt("productID"),rs.getString("name"),rs.getString("category"),rs.getInt("amountInStock"),rs.getInt("retailPrice"),rs.getInt("wholesalePrice"),rs.getString("description"),rs.getString("activate")});
             }
            con.close();
             } catch (SQLException ex) {
                Logger.getLogger(StockInternal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            
            try {
                con=DBConnect.connect();
                String sql = "select * From products INNER JOIN stock ON products.productID = stock.productID AND products.name Like '%"+name+"%' AND products.category ='"+Category+"'";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);
                while(rs.next()){
                    
                    model.addRow(new Object[] {rs.getInt("productID"),rs.getString("name"),rs.getString("category"),rs.getInt("amountInStock"),rs.getInt("retailPrice"),rs.getInt("wholesalePrice"),rs.getString("description"),rs.getString("activate")});
                }
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(StockInternal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
             } 
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       jTextField1.setText((String) jTable1.getValueAt(jTable1.getSelectedRow(),1));
       int row = jTable1.getSelectedRow();
       id = (int) jTable1.getValueAt(row,0);
       name =(String)jTable1.getValueAt(row, 1);
       amount  =  (int)jTable1.getValueAt(row, 3);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
       
    }//GEN-LAST:event_jTextField1KeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private com.k33ptoo.components.KButton kButton3;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    // End of variables declaration//GEN-END:variables
}
