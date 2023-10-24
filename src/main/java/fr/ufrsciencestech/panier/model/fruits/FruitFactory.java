package fr.ufrsciencestech.panier.model.fruits;

import fr.ufrsciencestech.panier.model.ProductFactory;
import fr.ufrsciencestech.panier.model.fruits.fruitSimple.*;
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
                return new Ananas(prix, origine);
            case "Banane":
                return new Banane(prix, origine);
            case "Cerise":
                return new Cerise(prix, origine);
            case "Fraise":
                return new Fraise(prix, origine);
            case "Kiwi":
                return new Kiwi(prix, origine);
            case "Orange":
                return new Orange(prix, origine);
            case "Poire":
                return new Poire(prix, origine);
            case "Pomme":
                return new Pomme(prix, origine);
            case "Tomate":
                return new Tomate(prix, origine);
            case "Caroube":
                return new Caroube(prix, origine);
            default:
                return new AnyFruit(name, prix, origine, isSeedless);
        }
    }

    @Override
    public FruitSimple createFruitSimple(String name) {
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
            case "Caroube":
                return new Caroube();
            default:
                return new AnyFruit(name, 0.0, "Unknown", true);
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
