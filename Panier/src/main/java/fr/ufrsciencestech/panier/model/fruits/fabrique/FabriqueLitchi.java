package fr.ufrsciencestech.panier.model.fruits.fabrique;

import fr.ufrsciencestech.panier.model.fruits.FruitSimple;
import fr.ufrsciencestech.panier.model.fruits.Litchi;

public class FabriqueLitchi implements Fabrique{
    @Override
    public FruitSimple fabrique() {
        return new Litchi();
    }

    @Override
    public FruitSimple fabrique(double prix, String origine) {
        return new Litchi(prix, origine);
    }
}
