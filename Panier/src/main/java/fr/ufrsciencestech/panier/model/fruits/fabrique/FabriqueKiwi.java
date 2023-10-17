package fr.ufrsciencestech.panier.model.fruits.fabrique;

import fr.ufrsciencestech.panier.model.fruits.fruitsimple.FruitSimple;
import fr.ufrsciencestech.panier.model.fruits.fruitsimple.Kiwi;

public class FabriqueKiwi implements Fabrique{
    @Override
    public FruitSimple fabrique() {
        return new Kiwi();
    }

    @Override
    public FruitSimple fabrique(double prix, String origine) {
        return new Kiwi(prix, origine);
    }
}
