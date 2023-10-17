package fr.ufrsciencestech.panier.model.fruits.fruitsimple;

public class Banane extends FruitSimple {
    public Banane(Double prix, String origine) {
        super("Banane", prix, origine, true);
    }

    public Banane() {
        super("Banane", 1.99, "Papouasie-Nouvelle-Guinée", true);
    }

}
