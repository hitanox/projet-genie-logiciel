/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fr.ufrsciencestech.panier.view;

import fr.ufrsciencestech.panier.controler.Controleur;
import fr.ufrsciencestech.panier.model.fruits.Fruit;
import fr.ufrsciencestech.panier.model.fruits.fruitsimple.FruitSimple;
import fr.ufrsciencestech.panier.model.fruits.fruitspecifique.Macedoine;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Observable;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sltctom
 */
public class VueMacedoine extends javax.swing.JFrame implements VueG {
    
    private DefaultTableModel model;
    private Boolean isActiv = false;
    private String name = "Macedoine";
    private Macedoine macedoine = new Macedoine();

    /**
     * Creates new form VueMacedoine
     */
    public VueMacedoine() {
        initComponents();
        this.macedoine.addObserver(this);
               
        model = new DefaultTableModel();
        model.addColumn("Produit");
        model.addColumn("Origine");
        model.addColumn("Prix");
        model.addColumn("Quantité");

        jTable1.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        cancel = new javax.swing.JButton();
        cancel.setName("cancel");
        macedoineTitle = new javax.swing.JLabel();
        tfOrigin = new javax.swing.JTextField();
        tfPrice = new javax.swing.JTextField();
        tfQuantity = new javax.swing.JTextField();
        add = new javax.swing.JButton();
        add.setName("add");
        addMacedoine = new javax.swing.JButton();
        comboName = new javax.swing.JComboBox<>();

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

        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        cancel.setText("Annuler");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        macedoineTitle.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        macedoineTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        macedoineTitle.setText("Macedoine");
        macedoineTitle.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        tfOrigin.setText("Origine");

        tfPrice.setText("Prix");

        tfQuantity.setText("Quantité");

        add.setText("Ajouter");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        addMacedoine.setName("addMacedoine");
        addMacedoine.setText("Valider Macedoine");

        comboName.setName("comboName");
        comboName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(macedoineTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(comboName, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfOrigin, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(tfQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1030, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addMacedoine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 38, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 39, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(macedoineTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfOrigin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tfPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(add)
                        .addComponent(addMacedoine)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 53, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 457, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelActionPerformed

    /**
     * @param args the command line arguments
     */
    
    public void updateTab(Object[][] donnees) {
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }

        for (Object[] ligne : donnees) {
            model.addRow(ligne);
        }   
    }

    @Override
    public void update(Observable m, Object o) {
        this.updateTab(((Macedoine) o).toObject());
    }

    public void updateForm(String origine, String prix) {
        this.tfOrigin.setText(origine);
        this.tfPrice.setText(prix);
    }

    @Override
    public void addControleur(Controleur c) {
        this.add.addActionListener(c);
        this.cancel.addActionListener(c);
        this.comboName.addActionListener(c);
        this.addMacedoine.addActionListener(c);
    }
    
    @Override
    public String getName() {
        return this.name;
    }
    
    @Override
    public Boolean isActiv() {
        return this.isActiv;
    }

    @Override
    public void closeView() {
        this.isActiv = false;
        this.dispose();
    }
    
    @Override
    public void openView() {
        this.isActiv = true;
        this.setVisible(true);
    }
    
    public String getFieldName() {
        return (String) comboName.getSelectedItem();
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

    public void setFruitsChoices(ArrayList<String> classes) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        this.comboName.setModel(new DefaultComboBoxModel<String>());
        for (String className : classes) {
            System.out.println(className);
            this.comboName.addItem(((Fruit) Class.forName(className).newInstance()).getNom());
        }
        System.out.println(comboName.getItemAt(0));
    }
    
    public void addFruit(FruitSimple fruit) {
        this.macedoine.add(fruit);
    }
    
    public ArrayList<Fruit> getMacedoine() {
        return this.macedoine.getFruits();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton addMacedoine;
    private javax.swing.JButton cancel;
    private javax.swing.JComboBox<String> comboName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel macedoineTitle;
    private javax.swing.JTextField tfOrigin;
    private javax.swing.JTextField tfPrice;
    private javax.swing.JTextField tfQuantity;
    // End of variables declaration//GEN-END:variables
}
