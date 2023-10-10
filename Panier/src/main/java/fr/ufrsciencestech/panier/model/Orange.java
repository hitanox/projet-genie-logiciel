package fr.ufrsciencestech.panier.model;

public class Orange extends FruitSimple {
    public Orange(Double prix, String origine) {
        super(prix, origine, false);
    }

    public Orange() {
        super(2.0, "France", false);
    }

    @Override
    public String getNom() {
        return "Orange";
    }
}
