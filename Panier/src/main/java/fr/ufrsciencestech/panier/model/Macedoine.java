package fr.ufrsciencestech.panier.model;

import java.util.ArrayList;

public class Macedoine implements Fruit {
    private ArrayList<Fruit> fruits;
    public Macedoine(ArrayList<Fruit> fruits) {
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
}
