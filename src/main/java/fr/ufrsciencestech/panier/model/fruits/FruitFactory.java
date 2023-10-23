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

    /**
     * Create a new instance of a fruit depending on parameters given by the user
     * @param name
     * @param prix
     * @param origine
     * @param isSeedless
     * @return a new instance of a fruit depending on parameters given by the user
     */
    @Override
    public FruitSimple createFruitSimple(String name, double prix, String origine, boolean isSeedless) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        return new AnyFruit(name, prix, origine, isSeedless);
    }

    @Override
    public FruitSimple createFruitSimple(String name, double prix, String origine) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
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
            case "Litchi":
                return new Litchi(prix, origine);
            case "Papaye":
                return new Papaye(prix, origine);
            default:
                throw new IllegalArgumentException("Name specified is not a fruit");
        }
    }

    /**
     * Create a new instance of a fruit depending on the name given by the user
     * @param name
     * @return a new instance of a fruit depending on the name given by the user
     */
    @Override
    public FruitSimple createFruitSimple(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
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
            case "Litchi":
                return new Litchi();
            case "Papaye":
                return new Papaye();
            default:
                throw new IllegalArgumentException("Name specified is not a fruit");
        }
    }

    /**
     * Create a new instance of a Macedoine with the list of fruits
     * @param fruits
     * @return
     */
    @Override
    public Macedoine createMacedoine(ArrayList<FruitSimple> fruits) {
        return new Macedoine(fruits);
    }

    /**
     * Create a new instance of a Jus with the fruit
     * @param fruit
     * @return
     */
    @Override
    public Jus createJus(FruitSimple fruit) {
        return new Jus(fruit);
    }
}
