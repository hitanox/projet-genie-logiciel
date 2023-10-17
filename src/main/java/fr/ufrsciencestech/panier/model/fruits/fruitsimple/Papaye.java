package fr.ufrsciencestech.panier.model.fruits.fruitsimple;

public class Papaye extends FruitSimple {
    public Papaye(double prix, String origine) {
        super("Papaye", prix, origine, true);
    }

    public Papaye() {super("Papaye", 2.99, "Mexique", true);}
}
