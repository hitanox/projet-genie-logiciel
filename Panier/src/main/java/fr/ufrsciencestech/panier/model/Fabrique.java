package fr.ufrsciencestech.panier.model;

public interface Fabrique {
    public FruitSimple fabrique();
    public FruitSimple fabrique(double prix, String origine);
}
