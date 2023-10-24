package fr.ufrsciencestech.panier.model.fruits.fruitspecifique;

import fr.ufrsciencestech.panier.model.fruits.Fruit;
import fr.ufrsciencestech.panier.model.fruits.fruitSimple.FruitSimple;

import java.util.ArrayList;

public class Macedoine implements Fruit {
    private ArrayList<Fruit> fruits;

    public Macedoine(ArrayList<Fruit> fruits) {
        super();
        checkFruits(fruits);
        this.fruits = fruits;
    }

    @Override
    public String toString() {
        String result = "Macedoine de ";
        for (Fruit f : fruits) {
            result += f.getClass().getSimpleName() + ", ";
        }
        return result.substring(0, result.length() - 2) + " a " + getPrix() + " euros";
    }

    public boolean isSeedless() {
        for (Fruit f : fruits) {
            if (!f.isSeedless()) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public String getNom() {
        return "Macedoine";
    }

    @Override
    public double getPrix() {
        double prix = 0;
        for (Fruit f : fruits) {
            prix += f.getPrix();
        }
        return prix;
    }

    @Override
    public String getOrigine() {
        return "France";
    }

    private void checkFruits(ArrayList<Fruit> fruits) {
        for (Fruit f : fruits) {
            if (f.getClass() == Jus.class) {
                throw new IllegalArgumentException("Macedoine cannot contain a Jus");
            }
            if (f.getClass() == Macedoine.class) {
                throw new IllegalArgumentException("Macedoine cannot contain another Macedoine");
            }
        }
    }
}
