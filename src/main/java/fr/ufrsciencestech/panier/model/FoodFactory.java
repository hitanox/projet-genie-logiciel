package fr.ufrsciencestech.panier.model;

import fr.ufrsciencestech.panier.model.fruits.fruitsimple.FruitSimple;
import fr.ufrsciencestech.panier.model.recipe.fruitspecifique.Jus;
import fr.ufrsciencestech.panier.model.recipe.fruitspecifique.Macedoine;

import java.util.ArrayList;

public interface FoodFactory {
    public FruitSimple createFruitSimple(String name, double prix, String origine, boolean isSeedless);

    public Macedoine createMacedoine(ArrayList<FruitSimple> fruits);

    public Jus createJus(FruitSimple fruit);
}
