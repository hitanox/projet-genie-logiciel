package fr.ufrsciencestech.panier.model.fruits;

public class Kiwi extends FruitSimple{
    public Kiwi(double prix, String origine) {
        super(prix, origine, true);
    }

    public Kiwi() {super(2.99, "Chine", true);}

    @Override
    public String getNom() {
        return "Kiwi";
    }
}
