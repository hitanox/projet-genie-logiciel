package fr.ufrsciencestech.panier.model.fruits.fruitsimple;

public class Kiwi extends FruitSimple {
    public Kiwi(double prix, String origine) {
        super("Kiwi", prix, origine, true);
    }

    public Kiwi() {super("Kiwi", 2.99, "Chine", true);}
}
