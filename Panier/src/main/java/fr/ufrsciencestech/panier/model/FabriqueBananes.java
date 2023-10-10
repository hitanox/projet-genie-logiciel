package fr.ufrsciencestech.panier.model;

public class FabriqueBananes implements Fabrique{
    @Override
    public FruitSimple fabrique() {
        return new Banane();
    }

    public FruitSimple fabrique(double prix, String origine) {
        return new Banane(prix, origine);
    }
}
