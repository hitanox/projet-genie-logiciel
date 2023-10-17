package fr.ufrsciencestech.panier;

import fr.ufrsciencestech.panier.controler.Controleur;
import fr.ufrsciencestech.panier.model.panier.Panier;
import fr.ufrsciencestech.panier.view.*;

//utilise pour springIoC :


public class Main {
    private static VueGraphique vueg;      //pour pouvoir changer de vue si on le souhaite
    private static Controleur controleur;  //pour pouvoir changer de controleur si on le souhaite

    /**
     * @return the vueg
     */
    public VueGraphique getVueg() {
        return vueg;
    }

    /**
     * @param vueg the vueg to set
     */
    public void setVueg(VueGraphique vueg) {
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
        //vueg = new VueGAWT();
        controleur = new Controleur();
        Panier panier = Panier.getInstance(5);
        vueg = new VueGraphique();

        controleur.setVue(vueg);
        controleur.setPanier(panier);
        panier.addObserver(vueg);
        vueg.addControleur(controleur);

    }
}
