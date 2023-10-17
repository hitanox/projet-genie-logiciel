package fr.ufrsciencestech.panier.model.fruits.fruitsimple;

public class Fraise extends FruitSimple {
    public Fraise(double prix, String origine) {
        super("Fraise", prix, origine, true);
    }

    public Fraise() { super("Fraise", 1.0, "Europe", true); }
}
