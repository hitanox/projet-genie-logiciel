/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package fr.ufrsciencestech.panier.view;

import fr.ufrsciencestech.panier.controler.Controleur;
import fr.ufrsciencestech.panier.model.panier.Panier;
import java.util.Observable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sltctom
 */
public class VuePanierV2 extends javax.swing.JFrame implements VueG {

    private DefaultTableModel model;
    
    public VuePanierV2() {
        initComponents();

        model = new DefaultTableModel();
        model.addColumn("Produit");
        model.addColumn("Origine");
        model.addColumn("Prix");
        model.addColumn("Quantité");

        jTable1.setModel(model);

    }
    
    public void mettreAJourTableau(Object[][] donnees) {
        try {
            while (model.getRowCount() > 0) {
                model.removeRow(0);
            }

            for (Object[] ligne : donnees) {
                if (!ligne[0].toString().isEmpty()) {
                    model.addRow(ligne);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
    @Override
    public void update(Observable m, Object o) {
        this.mettreAJourTableau(((Panier) o).toObject());
        this.mettreAJourTotal(((Panier) o).getPrix());
    }

    @Override
    public void addControleur(Controleur c) {
        this.add.addActionListener(c);
        this.del.addActionListener(c);
        //this.jTable1.addActionListener(c);
    }
    
    public javax.swing.JTable getTab() {
        return jTable1;
    }
    
    public String getFieldName() {
        return tfName.getText();
    }
    
    public String getFieldOrigin() {
        return tfOrigin.getText();
    }
    
    public String getFieldPrice() {
        return tfPrice.getText();
    }
    
    public Integer getFieldQuantity() {
        try {
            return Integer.valueOf(tfQuantity.getText());
        } catch (NumberFormatException e) {
            return 1;
        }   
    }
    
    public Boolean isJuice() {
        return isJuice.isSelected();
    }
    
    public void mettreAJourTotal(double prix) {
        this.tfTotal.setText("Total : " + prix + " €");
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        del = new javax.swing.JButton();
        del.setName("del");
        jPanel1 = new javax.swing.JPanel();
        tfName = new javax.swing.JTextField();
        tfOrigin = new javax.swing.JTextField();
        tfPrice = new javax.swing.JTextField();
        tfQuantity = new javax.swing.JTextField();
        isJuice = new javax.swing.JCheckBox();
        add = new javax.swing.JButton();
        add.setName("add");
        tfTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        del.setText("Supprimer");
        getContentPane().add(del, java.awt.BorderLayout.EAST);

        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        tfName.setText("Orange");
        tfName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNameActionPerformed(evt);
            }
        });
        jPanel1.add(tfName);

        tfOrigin.setText("Origine");
        jPanel1.add(tfOrigin);

        tfPrice.setText("Prix");
        jPanel1.add(tfPrice);

        tfQuantity.setText("Quantité");
        jPanel1.add(tfQuantity);

        isJuice.setName("jus");
        isJuice.setText("Jus");
        isJuice.setMaximumSize(new java.awt.Dimension(20, 22));
        isJuice.setMinimumSize(new java.awt.Dimension(20, 22));
        isJuice.setPreferredSize(new java.awt.Dimension(20, 22));
        isJuice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isJuiceActionPerformed(evt);
            }
        });
        jPanel1.add(isJuice);

        add.setText("Ajouter");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel1.add(add);

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        tfTotal.setText("Total : 0.0 €");
        getContentPane().add(tfTotal, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addActionPerformed

    private void tfNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNameActionPerformed

    private void isJuiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isJuiceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_isJuiceActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton del;
    private javax.swing.JCheckBox isJuice;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfOrigin;
    private javax.swing.JTextField tfPrice;
    private javax.swing.JTextField tfQuantity;
    private javax.swing.JLabel tfTotal;
    // End of variables declaration//GEN-END:variables



}
