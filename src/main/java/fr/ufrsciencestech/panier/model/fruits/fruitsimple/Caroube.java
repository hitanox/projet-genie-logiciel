package fr.ufrsciencestech.panier.model.fruits.fruitsimple;

public class Caroube extends FruitSimple {
    public Caroube(double prix, String origine) {
        super("Caroube", prix, origine, true);
    }

    public Caroube() {super("Caroube", 3.20, "Moyen-Orient", true);}
}
