package fr.ufrsciencestech.panier.model.fruits.fruitsimple;

public class Pomme extends FruitSimple {
    public Pomme(double prix, String origine) {
        super("Pomme", prix, origine, true);
    }

    public Pomme() {super("Pomme", 1.35, "Asie", true);}
}
