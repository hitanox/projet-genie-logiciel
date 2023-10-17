package fr.ufrsciencestech.panier.model.fruits.fruitsimple;

public class Poire extends FruitSimple {
    public Poire(Double prix, String origine) {
        super("Poire", prix, origine, false);
    }

    public Poire() {
        super("Poire", 0.8, "Espagne", false);
    }
}
