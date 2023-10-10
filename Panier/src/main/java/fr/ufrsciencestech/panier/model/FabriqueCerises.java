package fr.ufrsciencestech.panier.model;

public class FabriqueCerises implements Fabrique{
    @Override
    public FruitSimple fabrique() {
        return new Cerise();
    }

    public FruitSimple fabrique(double prix, String origine) {
        return new Cerise(prix, origine);
    }
}
