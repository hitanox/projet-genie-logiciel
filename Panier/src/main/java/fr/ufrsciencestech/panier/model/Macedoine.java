package fr.ufrsciencestech.panier.model;

import java.util.ArrayList;

public class Macedoine {
    private ArrayList<Fruit> fruits;
    public Macedoine(ArrayList<Fruit> fruits) {
        this.fruits = fruits;
    }

    @Override
    public String toString() {
        String result = "";
        for (Fruit f : fruits) {
            result += f.toString() + "\n";
        }
        return result;
    }

    public boolean isSeedless() {
        for (Fruit f : fruits) {
            if (!f.isSeedless()) {
                return false;
            }
        }
        return true;
    }
}
