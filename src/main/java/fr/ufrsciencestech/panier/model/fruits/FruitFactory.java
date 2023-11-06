package fr.ufrsciencestech.panier.model.fruits;

import fr.ufrsciencestech.panier.model.ProductFactory;
import fr.ufrsciencestech.panier.model.fruits.fruitsimple.*;
import fr.ufrsciencestech.panier.model.fruits.fruitspecifique.Jus;
import fr.ufrsciencestech.panier.model.fruits.fruitspecifique.Macedoine;
import fr.ufrsciencestech.panier.model.panier.Panier;

import java.util.ArrayList;
import java.util.Arrays;

public class FruitFactory implements ProductFactory {

    /**
     * List of fruits available
     */
    private final String[] fruitsAvailable = {"Ananas", "Banane", "Cerise", "Fraise", "Kiwi", "Orange", "Poire", "Pomme", "Tomate", "Caroube", "Litchi", "Papaye"};

    @Override
    public Panier createPanier(int size) {
        return null;
    }

    /**
     * Create a new instance of a fruit depending on parameters given by the user
     *
     * @param name
     * @param prix
     * @param origine
     * @return a new instance of a fruit depending on parameters given by the user
     */
    @Override
    public FruitSimple createFruitSimple(String name, double prix, String origine) {
        if (prix < 0.0) throw new IllegalArgumentException("Price cannot be negative");
        if (null == origine || origine.isEmpty()) throw new IllegalArgumentException("Origin cannot be empty");

        checkNameParameter(name);
        if (!Arrays.asList(fruitsAvailable).contains(name)) {
            checkPriceParameter(prix);
            checkOriginParameter(origine);
            return new AnyFruit(name, prix, origine);
        } else {
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
    }

    /**
     * Create a new instance of a fruit depending on the name given by the user
     *
     * @param name
     * @return a new instance of a fruit depending on the name given by the user
     */
    @Override
    public FruitSimple createFruitSimple(String name) {
        checkNameParameter(name);
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
     *
     * @param fruits
     * @return
     */
    @Override
    public Macedoine createMacedoine(ArrayList<Fruit> fruits) {
        return new Macedoine(fruits);
    }

    /**
     * Create a new instance of a Jus with the fruit
     *
     * @param fruit
     * @return
     */
    @Override
    public Jus createJus(Fruit fruit) {
        return new Jus(fruit);
    }

    /**
     * Check if the name parameter is valid
     *
     * @param name
     */
    public void checkNameParameter(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
    }

    /**
     * Check if the price parameter is valid
     *
     * @param price
     */
    public void checkPriceParameter(double price) {
        if (price < 0.0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
    }

    /**
     * Check if the origin parameter is valid
     *
     * @param origin
     */
    public void checkOriginParameter(String origin) {
        if (origin == null || origin.isEmpty()) {
            throw new IllegalArgumentException("Origin cannot be null or empty");
        }
    }
}
