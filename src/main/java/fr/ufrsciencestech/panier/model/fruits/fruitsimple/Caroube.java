package fr.ufrsciencestech.panier.model.fruits.fruitsimple;

public class Caroube extends FruitSimple {
    public Caroube(double prix, String origine) {
        super(prix, origine, true);
    }

    public Caroube() {super(3.20, "Moyen-Orient", true);}

    @Override
    public String getNom() {
        return "Caroube";
    }
}
