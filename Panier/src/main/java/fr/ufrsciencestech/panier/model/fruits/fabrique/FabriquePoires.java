package fr.ufrsciencestech.panier.model.fruits.fabrique;

import fr.ufrsciencestech.panier.model.fruits.FruitSimple;
import fr.ufrsciencestech.panier.model.fruits.Poire;

public class FabriquePoires implements Fabrique {
    @Override
    public FruitSimple fabrique() {
        return new Poire();
    }

    public FruitSimple fabrique(double prix, String origine) {
        return new Poire(prix, origine);
    }
}
