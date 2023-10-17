package fr.ufrsciencestech.panier;

import fr.ufrsciencestech.panier.controler.Controleur;
import fr.ufrsciencestech.panier.model.fruits.fabrique.FabriqueOranges;
import fr.ufrsciencestech.panier.model.fruits.fabrique.FabriquePoires;
import fr.ufrsciencestech.panier.model.panier.Panier;
import fr.ufrsciencestech.panier.model.panier.PanierPleinException;
import fr.ufrsciencestech.panier.view.*;

//utilise pour springIoC :


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
        //vueg = new VueGAWT();
        controleur = new Controleur();
        Panier panier = new Panier(5);
        vueg = new VuePanierV2();
        vueg.run();


    }
}
