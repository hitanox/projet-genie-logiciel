package fr.ufrsciencestech.panier.model.fruits.fruitsimple;

public class Fraise extends FruitSimple {
    public Fraise(double prix, String origine) {
        super(prix, origine, true);
    }

    public Fraise() { super(1.0, "Europe", true); }

    @Override
    public String getNom() {
        return "Fraise";
    }
}
