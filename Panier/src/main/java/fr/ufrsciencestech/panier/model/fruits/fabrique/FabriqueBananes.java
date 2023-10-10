package fr.ufrsciencestech.panier.model.fruits.fabrique;

import fr.ufrsciencestech.panier.model.fruits.Banane;
import fr.ufrsciencestech.panier.model.fruits.FruitSimple;

public class FabriqueBananes implements Fabrique {
    @Override
    public FruitSimple fabrique() {
        return new Banane();
    }

    public FruitSimple fabrique(double prix, String origine) {
        return new Banane(prix, origine);
    }
}
