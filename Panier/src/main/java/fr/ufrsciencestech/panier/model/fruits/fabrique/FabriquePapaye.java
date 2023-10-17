package fr.ufrsciencestech.panier.model.fruits.fabrique;

import fr.ufrsciencestech.panier.model.fruits.FruitSimple;
import fr.ufrsciencestech.panier.model.fruits.Papaye;

public class FabriquePapaye implements Fabrique{
    @Override
    public FruitSimple fabrique() {
        return new Papaye();
    }

    @Override
    public FruitSimple fabrique(double prix, String origine) {
        return new Papaye(prix, origine);
    }
}
