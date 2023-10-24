package fr.ufrsciencestech.panier.controler;


import fr.ufrsciencestech.panier.model.fruits.FruitFactory;
import fr.ufrsciencestech.panier.model.fruits.fruitSimple.FruitSimple;
import fr.ufrsciencestech.panier.model.fruits.fruitspecifique.Jus;
import fr.ufrsciencestech.panier.model.panier.Panier;
import fr.ufrsciencestech.panier.model.panier.PanierPleinException;
import fr.ufrsciencestech.panier.model.panier.PanierVideException;
import fr.ufrsciencestech.panier.view.VuePanierV2;
import java.awt.*;
import java.awt.event.*;

public class Controleur implements ActionListener {
    private Panier p;
    private VuePanierV2 vg;
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(((Component)e.getSource()).getName().equals("add")) {
            try {
                FruitFactory facto = new FruitFactory();
                
                String fruitName = vg.getFieldName();
                System.out.println(fruitName);

                Integer quantity = vg.getFieldQuantity();
                
                FruitSimple fruit = facto.createFruitSimple(fruitName);

                if (vg.isJuice()) {
                    Jus jus = facto.createJus(fruit);   
                    this.p.ajout(jus, quantity);
                } else {
                    this.p.ajout(fruit, quantity);
                }
                
            } catch (PanierPleinException ex) {
                System.out.println(ex);
            }
        }
        else {
            try {
                this.p.retrait();
            } catch (PanierVideException ex) {
                //Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex);
            }
        }
    }
    public void setPanier(Panier p){
        this.p = p;
    }

    public Panier getPanier() {
        return this.p;
    }
    public void setVue(VuePanierV2 vg){
        this.vg = vg;
    }

    public VuePanierV2 getVue() {
        return this.vg;
    }
}
