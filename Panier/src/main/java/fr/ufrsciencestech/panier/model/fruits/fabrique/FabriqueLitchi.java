package fr.ufrsciencestech.panier.model.fruits.fabrique;

import fr.ufrsciencestech.panier.model.fruits.fruitsimple.FruitSimple;
import fr.ufrsciencestech.panier.model.fruits.fruitsimple.Litchi;

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
