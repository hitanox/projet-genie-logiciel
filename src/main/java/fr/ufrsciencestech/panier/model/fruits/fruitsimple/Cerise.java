package fr.ufrsciencestech.panier.model.fruits.fruitsimple;

public class Cerise extends FruitSimple {
    public Cerise(Double prix, String origine) {
        super("Cerise", prix, origine, false);
    }

    public Cerise() {
        super("Cerise",6.5, "Caucase", false);
    }
}
