package fr.ufrsciencestech.panier.controler;

import fr.ufrsciencestech.panier.model.fruits.fruitsimple.Poire;
import fr.ufrsciencestech.panier.model.fruits.fruitsimple.Orange;
import fr.ufrsciencestech.panier.model.panier.Panier;
import fr.ufrsciencestech.panier.model.panier.PanierPleinException;
import fr.ufrsciencestech.panier.model.panier.PanierVideException;
import fr.ufrsciencestech.panier.view.VueGraphique;

import java.awt.*;
import java.awt.event.*;

public class Controleur implements ActionListener {
    private Panier panier;
    private VueGraphique vg;
    private String fruit = "Orange"; 
    
    @Override
    public void actionPerformed(ActionEvent e){   //Invoked when an action occurs
        if(((Component)e.getSource()).getName().equals("comboBox")) {
            this.setFruit(vg.getComboBox().getSelectedItem().toString());
            System.out.println(fruit);
        }
        else if(((Component)e.getSource()).getName().equals("Plus")){
            try {
                switch (this.getFruit()) {
                    case "Orange":
                        panier.ajout(new Orange());
                        break;
                    case "Poire":
                        panier.ajout(new Poire());
                        break;
                
                }
            }
            catch(PanierPleinException ppe) {System.err.println(ppe);}
        }
        else {
            try {
                panier.retrait();
            }
            catch(PanierVideException pve) {System.err.println(pve);}
        }
              
    }
    public void setPanier(Panier p){
        this.panier = p;
    }

    public Panier getPanier() {
        return this.panier;
    }
    public void setVue(VueGraphique vg){
        this.vg = vg;
    }

    public VueGraphique getVue() {
        return this.vg;
    }
    
     public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }
}
