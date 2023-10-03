package fr.ufrsciencestech.panier.model;

public class Cerise extends FruitSimple {
    public Cerise(Double prix,  String origine) {
        super(prix, origine, false);
    }

    public Cerise() {
        super(6.5, "Caucase", false);
    }
}
