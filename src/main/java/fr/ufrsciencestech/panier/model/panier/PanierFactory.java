package fr.ufrsciencestech.panier.model.panier;

import fr.ufrsciencestech.panier.model.ProductFactory;
import fr.ufrsciencestech.panier.model.fruits.Fruit;
import fr.ufrsciencestech.panier.model.fruits.fruitsimple.FruitSimple;
import fr.ufrsciencestech.panier.model.fruits.fruitspecifique.Jus;
import fr.ufrsciencestech.panier.model.fruits.fruitspecifique.Macedoine;

import java.util.ArrayList;

public class PanierFactory implements ProductFactory {

    @Override
    public Panier createPanier(int size) {
        return new Panier(size);
    }

    @Override
    public FruitSimple createFruitSimple(String name) {
        return null;
    }

    @Override
    public FruitSimple createFruitSimple(String name, double prix, String origine) {
        return null;
    }

    @Override
    public Macedoine createMacedoine(ArrayList<Fruit> fruits) {
        return null;
    }

    @Override
    public Jus createJus(Fruit fruit) {
        return null;
    }

}
