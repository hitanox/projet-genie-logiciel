package fr.ufrsciencestech.panier.model;

public interface Fabrique {
    public Fruit fabrique();
    public Fruit fabrique(double prix, String origine);
}
