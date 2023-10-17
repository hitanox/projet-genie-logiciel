package fr.ufrsciencestech.panier.model.fruits.fabrique;

import fr.ufrsciencestech.panier.model.fruits.fruitsimple.FruitSimple;
import fr.ufrsciencestech.panier.model.fruits.fruitsimple.Pomme;

public class FabriquePomme implements Fabrique{
    @Override
    public FruitSimple fabrique() {
        return new Pomme();
    }

    @Override
    public FruitSimple fabrique(double prix, String origine) {
        return new Pomme(prix, origine);
    }
}
