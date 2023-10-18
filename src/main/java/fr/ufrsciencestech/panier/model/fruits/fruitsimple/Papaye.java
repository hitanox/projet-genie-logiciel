package fr.ufrsciencestech.panier.model.fruits.fruitsimple;

public class Papaye extends FruitSimple {
    public Papaye(double prix, String origine) {
        super(prix, origine, true);
    }

    public Papaye() {super(2.99, "Mexique", true);}

    @Override
    public String getNom() {
        return "Papaye";
    }
}
