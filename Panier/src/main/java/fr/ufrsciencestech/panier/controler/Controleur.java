package fr.ufrsciencestech.panier.controler;

import fr.ufrsciencestech.panier.view.*;
import fr.ufrsciencestech.panier.model.Panier;
import fr.ufrsciencestech.panier.model.Orange;
import fr.ufrsciencestech.panier.model.PanierPleinException;
import fr.ufrsciencestech.panier.model.PanierVideException;
import fr.ufrsciencestech.panier.model.Poire;
import java.awt.*;
import java.awt.event.*;

public class Controleur implements ActionListener {
    private Panier p;
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
                        p.ajout(new Orange());
                        break;
                    case "Poire":
                        p.ajout(new Poire());
                        break;
                
                }
            }
            catch(PanierPleinException ppe) {System.err.println(ppe);}
        }
        else {
            try {
                p.retrait(); 
            }
            catch(PanierVideException pve) {System.err.println(pve);}
        }
              
    }
    public void setPanier(Panier p){
        this.p = p;
    }

    public Panier getPanier() {
        return this.p;
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
