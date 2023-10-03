package fr.ufrsciencestech.panier.model;

public class FabriqueBananes implements Fabrique{
    @Override
    public Fruit fabrique() {
        return new Banane();
    }

    public Fruit fabrique(double prix, String origine) {
        return new Banane(prix, origine);
    }
}
