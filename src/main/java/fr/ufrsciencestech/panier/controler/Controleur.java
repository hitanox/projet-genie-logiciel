package fr.ufrsciencestech.panier.controler;

import fr.ufrsciencestech.panier.model.fruits.fruitsimple.Poire;
import fr.ufrsciencestech.panier.model.panier.Panier;
import fr.ufrsciencestech.panier.model.panier.PanierPleinException;
import fr.ufrsciencestech.panier.model.panier.PanierVideException;
import fr.ufrsciencestech.panier.view.VuePanierV2;

import java.awt.*;
import java.awt.event.*;
import fr.ufrsciencestech.panier.model.fruits.Fruit;

public class Controleur implements ActionListener {
    private Panier p;
    private VuePanierV2 vg;
    private String fruit = "Orange"; 
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(((Component)e.getSource()).getName().equals("add")) {
            try {
                this.setFruit(vg.getTextFieldType().getText());
                System.out.println(fruit);
                    try {
                        Class vClasse = Class.forName("fr.ufrsciencestech.panier.model.fruits.fruitsimple." + fruit);
                        try {
                            Fruit object = (Fruit)vClasse.newInstance();
                            this.p.ajout(object);
                        }catch(InstantiationException | IllegalAccessException ex){ System.out.println(ex); }
                    }
                    catch(ClassNotFoundException ex) {
                        System.out.println(ex);
                        this.p.ajout(new Poire()); //test, à terme ajouter fruit personnalisé
                    }
            } catch (PanierPleinException ex) {
                //Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
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
        this.panier = p;
    }

    public Panier getPanier() {
        return this.panier;
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
