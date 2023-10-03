package fr.ufrsciencestech.panier.model;

public class FabriqueCerises implements Fabrique{
    @Override
    public Fruit fabrique() {
        return new Cerise();
    }

    public Fruit fabrique(double prix, String origine) {
        return new Cerise(prix, origine);
    }
}
