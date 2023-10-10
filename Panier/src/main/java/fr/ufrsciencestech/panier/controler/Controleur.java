package fr.ufrsciencestech.panier.controler;

import fr.ufrsciencestech.panier.model.*;
import fr.ufrsciencestech.panier.view.*;

import java.awt.*;
import java.awt.event.*;

public class Controleur implements ActionListener {
    private Panier p;
    private VueG vg;
    
    @Override
    public void actionPerformed(ActionEvent e){   //Invoked when an action occurs
        if(((Component)e.getSource()).getName().equals("Plus")) {
            try {
                p.ajout(new Orange());
            }
            catch(PanierPleinException ppe) {System.out.println(ppe);}
        }
        else {
            try {
                p.retrait(); 
            }
            catch(PanierVideException pve) {System.out.println(pve);}
        }
    }
    public void setPanier(Panier p){
        this.p = p;
    }

    public Panier getPanier() {
        return this.p;
    }
    public void setVue(VueG vg){
        this.vg = vg;
    }

    public VueG getVue() {
        return this.vg;
    }
}
