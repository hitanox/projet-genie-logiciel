package fr.ufrsciencestech.panier;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import fr.ufrsciencestech.panier.controler.Controleur;
import fr.ufrsciencestech.panier.model.fruits.fruitsimple.*;
import fr.ufrsciencestech.panier.model.panier.Panier;
import fr.ufrsciencestech.panier.view.*;

import java.util.ArrayList;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {
    private static VuePanierV2 vueg;      //pour pouvoir changer de vue si on le souhaite
    private static Controleur controleur;  //pour pouvoir changer de controleur si on le souhaite
    private static VueConsole vuec;     //pour pouvoir changer de console si on le souhaite

    /**
     * @return vueg
     */
    public VuePanierV2 getVueg() {
        return vueg;
    }

    /**
     * @param vueg
     */
    public void setVueg(VuePanierV2 vueg) {
        this.vueg = vueg;
    }

    /**
     * @return controleur
     */
    public Controleur getControleur() {
        return controleur;
    }

    /**
     * @param controleur 
     */
    public void setControleur(Controleur controleur) {
        this.controleur = controleur;
    }

    /**
     * @return vuec
     */
    public VueConsole getVuec() {
        return vuec;
    }

    /**
     * @param vuec
     */
    public void setVuec(VueConsole vuec) {
        this.vuec = vuec;
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        
        UIManager.setLookAndFeel(new FlatMacLightLaf());
        
        controleur = new Controleur();
        Panier panier = new Panier(5);
        vueg = new VuePanierV2(panier.getContenanceMax());
        vuec = new VueConsole();

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

        controleur.setMainVue(vueg);
        controleur.setVueConsole(vuec);
        controleur.setPanier(panier);
        controleur.setFruitsClasses(fruitsClasses);
        panier.addObserver(vueg);
        vueg.addControleur(controleur);
        vueg.setVueConsole(vuec);

        try {
            vueg.setFruitsChoices(fruitsClasses);
            controleur.updateForm(vueg);
        } catch (Exception e) {
            vuec.affiche(e.toString());
        }

        vueg.openView();

    }
}
