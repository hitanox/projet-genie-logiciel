package fr.ufrsciencestech.panier.model.fruits.fruitsimple;

public class Tomate extends FruitSimple {
    public Tomate(double prix, String origine) {
        super("Tomate", prix, origine, true);
    }

    public Tomate() {super("Tomate", 1.49, "Amérique du Sud", true);}
}
