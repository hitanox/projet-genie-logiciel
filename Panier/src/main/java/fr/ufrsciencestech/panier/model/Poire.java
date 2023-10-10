package fr.ufrsciencestech.panier.model;

public class Poire extends FruitSimple {
    public Poire(Double prix,  String origine) {
        super(prix, origine, false);
    }

    public Poire() {
        super(0.8, "Espagne", false);
    }

    @Override
    public String getNom() {
        return "Poire";
    }
}
