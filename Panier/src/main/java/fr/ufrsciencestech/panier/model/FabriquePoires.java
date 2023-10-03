package fr.ufrsciencestech.panier.model;

public class FabriquePoires implements Fabrique{
    @Override
    public Fruit fabrique() {
        return new Poire();
    }

    public Fruit fabrique(double prix, String origine) {
        return new Poire(prix, origine);
    }
}
