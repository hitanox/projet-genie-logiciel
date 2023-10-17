package fr.ufrsciencestech.panier.model.fruits.fabrique;

import fr.ufrsciencestech.panier.model.fruits.fruitsimple.FruitSimple;

public interface Fabrique {
    public FruitSimple fabrique();

    public FruitSimple fabrique(double prix, String origine);
}
