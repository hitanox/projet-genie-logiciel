package fr.ufrsciencestech.panier.model.fruits.fabrique;

import fr.ufrsciencestech.panier.model.fruits.Ananas;
import fr.ufrsciencestech.panier.model.fruits.FruitSimple;

public class FabriqueAnanas implements Fabrique{
    @Override
    public FruitSimple fabrique() {
        return new Ananas();
    }

    @Override
    public FruitSimple fabrique(double prix, String origine) {
        return new Ananas(prix, origine);
    }
}
