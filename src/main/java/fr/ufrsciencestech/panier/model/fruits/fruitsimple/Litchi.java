package fr.ufrsciencestech.panier.model.fruits.fruitsimple;

public class Litchi extends FruitSimple {
    public Litchi(double prix, String origine) {
        super("Litchi", prix, origine, true);
    }

    public Litchi() {super("Litchi", 1.49, "Chine", true);}
}
