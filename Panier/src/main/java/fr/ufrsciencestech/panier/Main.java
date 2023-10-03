package fr.ufrsciencestech.panier;

import fr.ufrsciencestech.panier.controler.Controleur;
import fr.ufrsciencestech.panier.view.*;
import fr.ufrsciencestech.panier.model.Panier;

//utilise pour springIoC :
import javax.swing.*;

public class Main {
    private VueG vueg;      //pour pouvoir changer de vue si on le souhaite
    private Controleur controleur;  //pour pouvoir changer de controleur si on le souhaite
    
    /**
     * @return the vueg
     */
    public VueG getVueg() {
        return vueg;
    }

    /**
     * @param vueg the vueg to set
     */
    public void setVueg(VueG vueg) {
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
    
    
    public Main(){
        //sans utiliser SpringIoC :
        vueg = new VueGSwing();
        //vueg = new VueGAWT();
        controleur = new Controleur();
        Panier panier = new Panier(5);
        VueConsole vuec = new VueConsole();
        
        controleur.setPanier(panier);                 
        panier.addObserver(vueg);        
        panier.addObserver(vuec);         
        vueg.addControleur(controleur);
    }
    
    public static void main(String[] args){
        Main test = new Main();    //sans utiliser SpringIoC
    }
}
