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
     * Liste des fruits disponibles
     */
    private final String[] fruitsAvailable = {"Ananas", "Banane", "Cerise", "Fraise", "Kiwi", "Orange", "Poire", "Pomme", "Tomate", "Caroube", "Litchi", "Papaye"};

    @Override
    public Panier createPanier(int size) {
        return null;
    }

    /**
     * Crée une nouvelle instance de fruit en fonction des paramètres
     * @param name nom du fruit
     * @param prix prix du fruit
     * @param origine origine du fruit
     * @return l'instance du fruit créé
     */
    @Override
    public FruitSimple createFruitSimple(String name, double prix, String origine) {
        checkPriceParameter(prix);
        checkOriginParameter(origine);

        checkNameParameter(name);
        if (!Arrays.asList(fruitsAvailable).contains(name)) {

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
     * Crée une nouvelle instance de fruit à partir d'un nom
     *
     * @param name nom du fruit
     * @return l'instance du fruit créé
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
     * Crée une nouvelle instance de macédoine à partir d'une liste de fruits 
     *
     * @param fruits
     * @return l'instance de la macédoine créée
     */
    @Override
    public Macedoine createMacedoine(ArrayList<Fruit> fruits) {
        return new Macedoine(fruits);
    }

    /**
     * Crée un jus à partir d'un fruit
     *
     * @param fruit
     * @return l'instance du jus créé
     */
    @Override
    public Jus createJus(Fruit fruit) {
        return new Jus(fruit);
    }

    /**
     * Vérifie la validité du nom placé en paramètre
     *
     * @param name
     */
    public void checkNameParameter(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
    }

    /**
     * Vérifie la validité du prix placé en paramètre
     *
     * @param price
     */
    public void checkPriceParameter(double price) {
        if (price < 0.0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
    }

    /**
     * Vérifie la validité de l'origine placée en paramètre
     *
     * @param origin
     */
    public void checkOriginParameter(String origin) {
        if (origin == null || origin.isEmpty()) {
            throw new IllegalArgumentException("Origin cannot be null or empty");
        }
    }
}
