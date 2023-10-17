package fr.ufrsciencestech.panier.model.fruits.fabrique;

import fr.ufrsciencestech.panier.model.fruits.fruitsimple.FruitSimple;
import fr.ufrsciencestech.panier.model.fruits.fruitsimple.Tomate;

public class FabriqueTomate implements Fabrique{
    @Override
    public FruitSimple fabrique() {
        return new Tomate();
    }

    @Override
    public FruitSimple fabrique(double prix, String origine) {
        return new Tomate(prix, origine);
    }
}
