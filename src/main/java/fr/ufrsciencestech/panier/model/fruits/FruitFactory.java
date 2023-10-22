package fr.ufrsciencestech.panier.model.fruits;

import fr.ufrsciencestech.panier.Utils;
import fr.ufrsciencestech.panier.model.FoodFactory;
import fr.ufrsciencestech.panier.model.fruits.fruitsimple.*;
import fr.ufrsciencestech.panier.model.recipe.fruitspecifique.Jus;
import fr.ufrsciencestech.panier.model.recipe.fruitspecifique.Macedoine;

import java.util.ArrayList;

public class FruitFactory implements FoodFactory {
    private Utils utils;
    @Override
    public FruitSimple createFruitSimple(String name, double prix, String origine, boolean isSeedless) {
        return utils.getFruitSimple(name, prix, origine, isSeedless);
    }
    @Override
    public Macedoine createMacedoine(ArrayList<FruitSimple> fruits) {
        return null;
    }

    @Override
    public Jus createJus(FruitSimple fruit) {
        return null;
    }
}
