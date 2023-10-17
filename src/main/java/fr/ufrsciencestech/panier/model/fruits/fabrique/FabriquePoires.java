package fr.ufrsciencestech.panier.model.fruits.fabrique;

import fr.ufrsciencestech.panier.model.fruits.fruitsimple.FruitSimple;
import fr.ufrsciencestech.panier.model.fruits.fruitsimple.Poire;

public class FabriquePoires implements Fabrique {
    @Override
    public FruitSimple fabrique() {
        return new Poire();
    }

    public FruitSimple fabrique(double prix, String origine) {
        return new Poire(prix, origine);
    }
}
