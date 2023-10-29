package fr.ufrsciencestech.panier;

import fr.ufrsciencestech.panier.controler.Controleur;
import fr.ufrsciencestech.panier.model.fruits.fruitsimple.*;
import fr.ufrsciencestech.panier.model.panier.Panier;
import fr.ufrsciencestech.panier.view.*;

import java.util.ArrayList;

public class Main {
    private static VuePanierV2 vueg;      //pour pouvoir changer de vue si on le souhaite
    private static Controleur controleur;  //pour pouvoir changer de controleur si on le souhaite

    /**
     * @return the vueg
     */
    public VuePanierV2 getVueg() {
        return vueg;
    }

    /**
     * @param vueg the vueg to set
     */
    public void setVueg(VuePanierV2 vueg) {
        this.vueg = vueg;
    }

    /**
     * @return the controleur
     */
    public Controleur getControleur() {
        return controleur;
    }

    /**
     * @param controleur the controleur to set
     */
    public void setControleur(Controleur controleur) {
        this.controleur = controleur;
    }

    public static void main(String[] args) {
        controleur = new Controleur();
        Panier panier = new Panier(5);

        // On récupère toutes les classes de fruits
        ArrayList<String> fruitsClasses = new ArrayList<>();
        fruitsClasses.add(Ananas.class.getName());
        fruitsClasses.add(Banane.class.getName());
        fruitsClasses.add(Caroube.class.getName());
        fruitsClasses.add(Cerise.class.getName());
        fruitsClasses.add(Fraise.class.getName());
        fruitsClasses.add(Kiwi.class.getName());
        fruitsClasses.add(Litchi.class.getName());
        fruitsClasses.add(Orange.class.getName());
        fruitsClasses.add(Papaye.class.getName());
        fruitsClasses.add(Poire.class.getName());
        fruitsClasses.add(Pomme.class.getName());
        fruitsClasses.add(Tomate.class.getName());

        System.out.println(fruitsClasses);

        vueg = new VuePanierV2();

        controleur.setMainVue(vueg);
        controleur.setPanier(panier);
        panier.addObserver(vueg);
        vueg.addControleur(controleur);

        try {
            vueg.setFruitsChoices(fruitsClasses);
        } catch (Exception e) {
            System.out.println(e);
        }

        vueg.openView();

    }
}
