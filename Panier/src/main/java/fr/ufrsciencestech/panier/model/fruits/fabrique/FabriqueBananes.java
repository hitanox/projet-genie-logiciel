package fr.ufrsciencestech.panier.model.fruits.fabrique;

import fr.ufrsciencestech.panier.model.fruits.fruitsimple.Banane;
import fr.ufrsciencestech.panier.model.fruits.fruitsimple.FruitSimple;

public class FabriqueBananes implements Fabrique {
    @Override
    public FruitSimple fabrique() {
        return new Banane();
    }

    public FruitSimple fabrique(double prix, String origine) {
        return new Banane(prix, origine);
    }
}
