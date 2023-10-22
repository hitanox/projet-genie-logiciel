package fr.ufrsciencestech.panier.model.recipe;

import fr.ufrsciencestech.panier.model.FoodFactory;
import fr.ufrsciencestech.panier.model.fruits.fruitsimple.FruitSimple;
import fr.ufrsciencestech.panier.model.recipe.fruitspecifique.Jus;
import fr.ufrsciencestech.panier.model.recipe.fruitspecifique.Macedoine;

import java.util.ArrayList;

public class RecipeFactory implements FoodFactory {
    @Override
    public FruitSimple createFruitSimple(String name, double prix, String origine, boolean isSeedless) {
        return null;
    }

    @Override
    public Macedoine createMacedoine(ArrayList<FruitSimple> fruits) {
        return new Macedoine(fruits);
    }

    @Override
    public Jus createJus(FruitSimple fruit) {
        return new Jus(fruit);
    }
}
