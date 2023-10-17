package fr.ufrsciencestech.panier.model.fruits.fabrique;

import fr.ufrsciencestech.panier.model.fruits.fruitsimple.Fraise;
import fr.ufrsciencestech.panier.model.fruits.fruitsimple.FruitSimple;

public class FabriqueFraise implements Fabrique {
    @Override
    public FruitSimple fabrique() {
        return new Fraise();
    }

    @Override
    public FruitSimple fabrique(double prix, String origine) {
        return new Fraise(prix, origine);
    }
}
