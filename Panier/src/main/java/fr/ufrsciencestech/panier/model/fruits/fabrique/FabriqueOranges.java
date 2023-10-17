package fr.ufrsciencestech.panier.model.fruits.fabrique;

import fr.ufrsciencestech.panier.model.fruits.fruitsimple.FruitSimple;
import fr.ufrsciencestech.panier.model.fruits.fruitsimple.Orange;

public class FabriqueOranges implements Fabrique {
    @Override
    public FruitSimple fabrique() {
        return new Orange();
    }

    @Override
    public FruitSimple fabrique(double prix, String origine) {
        return new Orange(prix, origine);
    }
}
