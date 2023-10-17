package fr.ufrsciencestech.panier.view;

import fr.ufrsciencestech.panier.controler.Controleur;
import fr.ufrsciencestech.panier.model.panier.Panier;

import java.awt.*;
import javax.swing.*;
import java.util.*;

public class VueGraphique extends JFrame implements VueG {
    private JButton inc;
    private JButton dec;
    private JTextArea affiche;
    private JComboBox comboBox;
    private JPanel panel;
    
    public VueGraphique() {
        super("Panier");
        inc = new JButton("+");
        dec = new JButton("-");
        affiche = new JTextArea("Panier vide");
        comboBox = new JComboBox();
        comboBox.addItem("Orange");
        comboBox.addItem("Poire");
        panel = new JPanel();
        
        panel.setLayout(new BorderLayout());
        panel.add(inc, BorderLayout.WEST);
        panel.add(comboBox, BorderLayout.CENTER);
        
        add(panel, BorderLayout.NORTH);
        add(dec, BorderLayout.SOUTH);
        add(affiche, BorderLayout.CENTER);
        this.setPreferredSize(new Dimension(500,500));
        
        comboBox.setName("comboBox");
        inc.setName("Plus");
        dec.setName("Moins");
        affiche.setName("Affichage");
        
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    @Override
    public void addControleur(Controleur c){
        getInc().addActionListener(c);
        getDec().addActionListener(c);
        getComboBox().addActionListener(c);
    }
    
    @Override
    public void update(Observable m, Object o){     //This method is called whenever the observed object is changed
        getAffiche().setText(((Panier) o).toString());
    }

    /**
     * @return the inc
     */
    public JButton getInc() {
        return inc;
    }

    /**
     * @param inc the inc to set
     */
    public void setInc(JButton inc) {
        this.inc = inc;
    }

    /**
     * @return the dec
     */
    public JButton getDec() {
        return dec;
    }

    /**
     * @param dec the dec to set
     */
    public void setDec(JButton dec) {
        this.dec = dec;
    }

    /**
     * @return the affiche
     */
    public JTextArea getAffiche() {
        return affiche;
    }

    /**
     * @param affiche the affiche to set
     */
    public void setAffiche(JTextArea affiche) {
        this.affiche = affiche;
    }

    
    public JComboBox getComboBox() {
        return comboBox;
    }

}
