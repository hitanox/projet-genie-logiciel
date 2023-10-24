package fr.ufrsciencestech.panier.model.fruits.fruitspecifique;

import fr.ufrsciencestech.panier.model.fruits.Fruit;
import fr.ufrsciencestech.panier.model.fruits.fruitsimple.FruitSimple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class Macedoine extends Observable implements Fruit {
    private ArrayList<FruitSimple> fruits;

    public Macedoine() {
        this.fruits = new ArrayList<>();
    }
    
    public Macedoine(ArrayList<FruitSimple> fruits) {
        this.fruits = fruits;
    }
    
    public void add(FruitSimple fruit) {
        this.fruits.add(fruit);
        setChanged();
        notifyObservers(this);
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
    
    public ArrayList<FruitSimple> getFruits() {
        return this.fruits;
    }
    
    @Override
    public String getNom() {
        String result = "Macedoine de ";
        for (Fruit f : fruits) {
            result += f.getClass().getSimpleName() + ", ";
        }
        return result;
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
    
    public Object[][] toObject() {
        Map<Fruit, Integer> fruitWithQuantity = new HashMap<>();

        for (int i = 0; i < fruits.size(); i++) {
            Fruit fruit = fruits.get(i);
            System.out.println(fruit.toString());

            if (fruitWithQuantity.containsKey(fruit)) {
                int currentQuantity = fruitWithQuantity.get(fruit);
                fruitWithQuantity.put(fruit, currentQuantity + 1);
            } else {
                fruitWithQuantity.put(fruit, 1);
            }
        }

        Object[][] res = new Object[fruitWithQuantity.size()][4];
        int i = 0;

        for (Map.Entry<Fruit, Integer> entry : fruitWithQuantity.entrySet()) {
            Fruit fruit = entry.getKey();
            int quantity = entry.getValue();
            res[i][0] = (fruit.getNom() != null) ? fruit.getNom() : "";
            res[i][1] = (fruit.getOrigine() != null) ? fruit.getOrigine() : "";
            res[i][2] = fruit.getPrix();
            res[i][3] = quantity;

            i++;
        }
    
        return res;
    }
}
