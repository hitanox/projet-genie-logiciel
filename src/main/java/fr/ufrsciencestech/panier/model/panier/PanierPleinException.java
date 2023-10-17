package fr.ufrsciencestech.panier.model.panier;

public class PanierPleinException extends Exception {

    public PanierPleinException() {
        super("Ajout impossible car le panier est plein !");
    }

}
