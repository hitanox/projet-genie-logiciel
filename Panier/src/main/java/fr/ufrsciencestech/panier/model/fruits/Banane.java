package fr.ufrsciencestech.panier.model.fruits;

public class Banane extends FruitSimple {
    public Banane(Double prix, String origine) {
        super(prix, origine, true);
    }

    public Banane() {
        super(1.99, "Papouasie-Nouvelle-Guinée", true);
    }

    @Override
    public String getNom() {
        return "Banane";
    }
}
