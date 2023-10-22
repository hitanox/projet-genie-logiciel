package fr.ufrsciencestech.panier.model.fruits;

import fr.ufrsciencestech.panier.model.ProductFactory;
import fr.ufrsciencestech.panier.model.fruits.fruitsimple.*;
import fr.ufrsciencestech.panier.model.fruits.fruitspecifique.Jus;
import fr.ufrsciencestech.panier.model.fruits.fruitspecifique.Macedoine;
import fr.ufrsciencestech.panier.model.panier.Panier;

import java.util.ArrayList;

public class FruitFactory implements ProductFactory {

    @Override
    public Panier createPanier(int size) {
        return null;
    }

    @Override
    public FruitSimple createFruitSimple(String name, double prix, String origine, boolean isSeedless) {
        switch (name) {
            case "Ananas":
                return new Ananas();
            case "Banane":
                return new Banane();
            case "Cerise":
                return new Cerise();
            case "Fraise":
                return new Fraise();
            case "Kiwi":
                return new Kiwi();
            case "Orange":
                return new Orange();
            case "Poire":
                return new Poire();
            case "Pomme":
                return new Pomme();
            case "Tomate":
                return new Tomate();
            default:
                return new AnyFruit(name, prix, origine, isSeedless);
        }
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
