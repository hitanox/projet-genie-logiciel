package fr.ufrsciencestech.panier.model.fruits.fruitsimple;

public class Tomate extends FruitSimple {
    public Tomate(double prix, String origine) {
        super(prix, origine, true);
    }

    public Tomate() {super(1.49, "Amérique du Sud", true);}

    @Override
    public String getNom() {
        return "Tomate";
    }
}
