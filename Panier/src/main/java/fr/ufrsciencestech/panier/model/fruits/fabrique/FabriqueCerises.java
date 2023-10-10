package fr.ufrsciencestech.panier.model.fruits.fabrique;

import fr.ufrsciencestech.panier.model.fruits.Cerise;
import fr.ufrsciencestech.panier.model.fruits.FruitSimple;

public class FabriqueCerises implements Fabrique {
    @Override
    public FruitSimple fabrique() {
        return new Cerise();
    }

    public FruitSimple fabrique(double prix, String origine) {
        return new Cerise(prix, origine);
    }
}
