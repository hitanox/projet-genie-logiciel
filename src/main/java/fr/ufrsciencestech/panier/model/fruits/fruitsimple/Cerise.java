package fr.ufrsciencestech.panier.model.fruits.fruitsimple;

public class Cerise extends FruitSimple {
    public Cerise(Double prix, String origine) {
        super(prix, origine, false);
    }

    public Cerise() {
        super(6.5, "Caucase", false);
    }

    @Override
    public String getNom() {
        return "Cerise";
    }
}
