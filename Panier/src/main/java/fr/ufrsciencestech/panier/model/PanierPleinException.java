package fr.ufrsciencestech.panier.model;

public class PanierPleinException extends Exception {
    
    public PanierPleinException()
    {
	super("Ajout impossible car le panier est plein !");
    }

}
