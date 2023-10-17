package fr.ufrsciencestech.panier.model.fruits.fabrique;

import fr.ufrsciencestech.panier.model.fruits.fruitsimple.Caroube;
import fr.ufrsciencestech.panier.model.fruits.fruitsimple.FruitSimple;

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
