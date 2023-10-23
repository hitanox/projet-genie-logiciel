package fr.ufrsciencestech.panier.controler;

import fr.ufrsciencestech.panier.model.fruits.fruitsimple.Poire;
import fr.ufrsciencestech.panier.model.panier.Panier;
import fr.ufrsciencestech.panier.model.panier.PanierPleinException;
import fr.ufrsciencestech.panier.model.panier.PanierVideException;
import fr.ufrsciencestech.panier.view.VuePanierV2;

import java.awt.*;
import java.awt.event.*;
import fr.ufrsciencestech.panier.model.fruits.Fruit;
import fr.ufrsciencestech.panier.model.fruits.FruitFactory;
import fr.ufrsciencestech.panier.model.fruits.fruitsimple.FruitSimple;
import fr.ufrsciencestech.panier.model.fruits.fruitspecifique.Jus;

public class Controleur implements ActionListener {
    private Panier p;
    private VuePanierV2 vg;
    private String fruit = "Orange"; 
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(((Component)e.getSource()).getName().equals("add")) {
            try {
                FruitFactory ff = new FruitFactory();
                this.setFruit(vg.getTextFieldType().getText());
                if (vg.isJuice()) {
                    FruitSimple fruitAJus = ff.createFruitSimple(fruit, 2, "Espagne", true);
                    Jus object = ff.createJus(fruitAJus);
                } else {
                    FruitSimple object = ff.createFruitSimple(fruit, 2, "Espagne", true);
                }
                System.out.println(object.toString());
                this.p.ajout(object);
            } catch (PanierPleinException | ClassNotFoundException | IllegalAccessException | InstantiationException ex) {
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
    
     public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }
}
