package fr.ufrsciencestech.panier.model;

public class FabriquePoires implements Fabrique{
    @Override
    public FruitSimple fabrique() {
        return new Poire();
    }

    public FruitSimple fabrique(double prix, String origine) {
        return new Poire(prix, origine);
    }
}
