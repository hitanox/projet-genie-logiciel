package fr.ufrsciencestech.panier.model.fruits.fruitsimple;

public class Pomme extends FruitSimple {
    public Pomme(double prix, String origine) {
        super(prix, origine, true);
    }

    public Pomme() {
        super(1.35, "Asie", true);
    }

    @Override
    public String getNom() {
        return "Pomme";
    }
}
