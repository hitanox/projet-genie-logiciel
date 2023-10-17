package fr.ufrsciencestech.panier.model.fruits.fruitsimple;

public class Ananas extends FruitSimple {
    public Ananas(double prix, String origine) {
        super(prix, origine, true);
    }

    public Ananas() { super(2.0, "Paraguay", true); }

    @Override
    public String getNom() {
        return "Ananas";
    }
}
