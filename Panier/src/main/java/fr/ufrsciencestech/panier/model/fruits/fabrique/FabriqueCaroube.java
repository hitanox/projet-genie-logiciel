package fr.ufrsciencestech.panier.model.fruits.fabrique;

import fr.ufrsciencestech.panier.model.fruits.Caroube;
import fr.ufrsciencestech.panier.model.fruits.FruitSimple;

public class FabriqueCaroube implements Fabrique{
    @Override
    public FruitSimple fabrique() {
        return new Caroube();
    }

    @Override
    public FruitSimple fabrique(double prix, String origine) {
        return new Caroube(prix, origine);
    }
}
