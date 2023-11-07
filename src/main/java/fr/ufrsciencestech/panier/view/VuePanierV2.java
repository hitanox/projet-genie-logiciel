package fr.ufrsciencestech.panier.view;

import fr.ufrsciencestech.panier.controler.Controleur;
import fr.ufrsciencestech.panier.model.panier.Panier;
import fr.ufrsciencestech.panier.model.fruits.Fruit;

import java.util.ArrayList;
import java.util.Observable;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.Component;
import java.awt.Dimension;

public class VuePanierV2 extends javax.swing.JFrame implements VueG {

    private DefaultTableModel model;

    private Boolean isActiv = false;

    private String name = "Panier";
    
    private int lineToRemove;
    
    private JButton[] buttons;
    
    private VueConsole consoleView;
    
    public VuePanierV2(int maxSize) {
        this.setPreferredSize(new Dimension(800, 400));
        initComponents();
        buttons = new JButton[maxSize];
        for(int i=0; i<maxSize; i++) {
            buttons[i] = new JButton("Supprimer");
            buttons[i].setName("button");
        }

        model = new DefaultTableModel();
        model.addColumn("Produit");
        model.addColumn("Origine");
        model.addColumn("Prix");
        model.addColumn("Quantité");
        model.addColumn("Action");

        jTable1.setModel(model);
        
        jTable1.getColumn("Action").setCellRenderer(new ButtonRenderer());
        jTable1.getColumn("Action").setCellEditor(new ButtonEditor());

    }
    
    class ButtonRenderer extends JButton implements TableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText("Supprimer");
            return this;
        }
    }

    class ButtonEditor extends DefaultCellEditor {
        public ButtonEditor() {
            super(new JCheckBox());
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            lineToRemove = row;
            return buttons[row];
        }
        
    }

    
    /** 
     * Met à jour le contenu du tableau
     * @param donnees données à insérer dans le tableau
     */
    public void updateTab(Object[][] donnees) {
        model=new DefaultTableModel();
        model.addColumn("Produit");
        model.addColumn("Origine");
        model.addColumn("Prix");
        model.addColumn("Quantité");
        model.addColumn("Action");
        jTable1.setModel(model);
        jTable1.getColumn("Action").setCellRenderer(new ButtonRenderer());
        jTable1.getColumn("Action").setCellEditor(new ButtonEditor());

        for (Object[] ligne : donnees) {
            model.addRow(ligne);
        }
    }

    
    /** 
     * Met à jour la vue
     * @param m
     * @param o
     */
    @Override
    public void update(Observable m, Object o) {
        this.updateTab(((Panier) o).toObject());
        this.updateTotal(((Panier) o).getPrix());
    }

    
    /** 
     * Met à jour le formulaire associé à la vue
     * @param origine
     * @param prix
     */
    public void updateForm(String origine, String prix) {
        this.tfOrigin.setText(origine);
        this.tfPrice.setText(prix);
    }

    
    /** 
     * Ajout au controleur des objets à observer
     * @param c
     */
    @Override
    public void addControleur(Controleur c) {
        this.add.addActionListener(c);
        this.del.addActionListener(c);
        this.comboName.addActionListener(c);
        this.btnMacedoine.addActionListener(c);
        for (JButton button : buttons) button.addActionListener(c);
    }

    
    /** 
     * Retourne le tableau jTable1
     * @return JTable
     */
    public javax.swing.JTable getTab() {
        return jTable1;
    }

    
    /** 
     * Retourne la valeur sélectionnée dans la comboBox
     * @return String
     */
    public String getFieldName() {
        return (String) comboName.getSelectedItem();
    }

    
    /** 
     * Retourne le texte du jTextField tfOrigin
     * @return String
     */
    public String getFieldOrigin() {
        return tfOrigin.getText();
    }

    
    /** 
     * Retourne le texte du jTextField tfPrice
     * @return String
     */
    public String getFieldPrice() {
        return tfPrice.getText();
    }

    
    /** 
     * Retourne l'entier contenu dans le jTextField tfQuantity
     * @return Integer
     */
    public Integer getFieldQuantity() {
        try {
            return Integer.valueOf(tfQuantity.getText());
        } catch (NumberFormatException e) {
            return 1;
        }
    }
    
    
    /** 
     * Retourne lineToRemove (position de la ligne à supprimer)
     * @return int
     */
    public int getLineToRemove() {
        return this.lineToRemove;
    }
    
    
    /** 
     * Retourne le nom de l'élément en position n dans le tableau
     * @param n
     * @return String
     */
    public String getNameAt(int n) {
        return this.jTable1.getValueAt(n,0).toString();
    }
    
    
    /** 
     * Retourne l'origine de l'élément en position n dans le tableau
     * @param n
     * @return String
     */
    public String getOriginAt(int n) {
        return this.jTable1.getValueAt(n,1).toString(); //sécuriser si getValueAt retourne null ?
    }
    
    
    /** 
     * Retourne le prix de l'élément en position n dans le tableau
     * @param n
     * @return double
     */
    public double getPriceAt(int n) {
        return Double.parseDouble(this.jTable1.getValueAt(n,2).toString()); //sécuriser si getValueAt retourne null ?
    }

    
    /** 
     * Retourne le choix de l'option isJuice : true si le bouton est activé, false sinon
     * @return Boolean
     */
    public Boolean isJuice() {
        return isJuice.isSelected();
    }

    
    /** 
     * Met à jour l'affichage de tfTotal avec le prix total passé en paramètre
     * @param prix
     */
    public void updateTotal(double prix) {
        this.tfTotal.setText("Total : " + prix + " €");
    }

    
    /** 
     * Retourne le nom de la vue
     * @return String
     */
    @Override
    public String getName() {
        return this.name;
    }
    
    
    /** 
     * Retourne si la vue est active ou non
     * @return Boolean
     */
    @Override
    public Boolean isActiv() {
        return this.isActiv;
    }
    
    
    /** 
     * Modificateur de la variable de classe consoleView
     * @param vueConsole
     */
    public void setVueConsole(VueConsole vueConsole){
        this.consoleView = vueConsole;
    }

    /**
     * Ferme la vue ainsi que la vue console
     */
    @Override
    public void closeView() {
        this.isActiv = false;
        this.setVisible(false);
        consoleView.setVisible(false);
    }

    /**
     * Ouvre la vue ainsi que la vue console
     */
    @Override
    public void openView() {
        this.isActiv = true;
        this.setVisible(true);
        consoleView.setVisible(true);
    }

    
    /** 
     * Initialise les fruits disponibles dans la comboBox
     * @param classes classes de fruits disponibles
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public void setFruitsChoices(ArrayList<String> classes) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        this.comboName.setModel(new DefaultComboBoxModel<String>());
        for (String className : classes) {
            this.comboName.addItem(((Fruit) Class.forName(className).newInstance()).getNom());
        }
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
        comboName = new javax.swing.JComboBox<>();
        tfOrigin = new javax.swing.JTextField();
        tfPrice = new javax.swing.JTextField();
        tfQuantity = new javax.swing.JTextField();
        isJuice = new javax.swing.JCheckBox();
        add = new javax.swing.JButton();
        add.setName("add");
        btnMacedoine = new javax.swing.JButton();
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

        comboName.setEditable(true);
        comboName.setToolTipText("Fruit");
        comboName.setName("comboName"); // NOI18N
        comboName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboNameActionPerformed(evt);
            }
        });
        jPanel1.add(comboName);

        tfOrigin.setToolTipText("Origine");
        jPanel1.add(tfOrigin);

        tfPrice.setToolTipText("Prix");
        jPanel1.add(tfPrice);

        tfQuantity.setToolTipText("Quantité");
        tfQuantity.setText("1");
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

        btnMacedoine.setName("btnMacedoine");
        btnMacedoine.setText("Macedoine");
        jPanel1.add(btnMacedoine);

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        tfTotal.setText("Total : 0.0 €");
        getContentPane().add(tfTotal, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addActionPerformed

    private void comboNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNameActionPerformed

    private void isJuiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isJuiceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_isJuiceActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton btnMacedoine;
    private javax.swing.JButton del;
    private javax.swing.JCheckBox isJuice;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> comboName;
    private javax.swing.JTextField tfOrigin;
    private javax.swing.JTextField tfPrice;
    private javax.swing.JTextField tfQuantity;
    private javax.swing.JLabel tfTotal;
    // End of variables declaration//GEN-END:variables

    public JButton getAddButton() {
        return add;
    }

    public JButton getDelButton() {
        return del;
    }

    public JButton getBtnMacedoine() {
        return btnMacedoine;
    }
}
