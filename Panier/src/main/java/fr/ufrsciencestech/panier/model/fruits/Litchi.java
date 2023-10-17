package fr.ufrsciencestech.panier.model.fruits;

public class Litchi extends FruitSimple{
    public Litchi(double prix, String origine) {
        super(prix, origine, true);
    }

    public Litchi() {super(1.49, "Chine", true);}

    @Override
    public String getNom() {
        return "Litchi";
    }
}
