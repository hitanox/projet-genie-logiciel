package fr.ufrsciencestech.panier.model.panier;

public class PanierVideException extends Exception {
    public PanierVideException() {
        super("Suppression impossible car le panier est vide !");
    }
}
