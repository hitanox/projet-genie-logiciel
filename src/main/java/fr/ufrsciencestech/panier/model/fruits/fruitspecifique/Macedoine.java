package fr.ufrsciencestech.panier.model.fruits.fruitspecifique;

import fr.ufrsciencestech.panier.model.fruits.Fruit;
import fr.ufrsciencestech.panier.model.fruits.fruitsimple.FruitSimple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Observable;

public class Macedoine extends Observable implements Fruit {
    private final ArrayList<Fruit> fruits;

    public Macedoine() {
        this.fruits = new ArrayList<>();
    }

    public Macedoine(ArrayList<Fruit> fruits) {
        super();
        checkFruits(fruits);
        this.fruits = fruits;
    }

    public void add(FruitSimple fruit) {
        this.fruits.add(fruit);
        setChanged();
        notifyObservers(this);
    }
    
    public void retrait() throws IllegalAccessException {
        if (this.fruits.size() > 0) {
            this.fruits.remove(this.fruits.size() - 1);
            setChanged(); //marks this Observable object as having been changed; the hasChanged method will now return true
            notifyObservers(this); //if this object has changed, as indicated by the hasChanged method, then notify all of its observers and then call the clearChanged method to indicate that this object has no longer changed
        } else {
            throw new IllegalAccessException("Aucun fruit a supprimé dans la macedoine");
        };
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Macedoine de ");
        for (Fruit f : fruits) {
            result.append(f.getClass().getSimpleName()).append(", ");
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

    public ArrayList<Fruit> getFruits() {
        return this.fruits;
    }

    @Override
    public String getNom() {
        StringBuilder result = new StringBuilder("Macedoine de ");
        for (Fruit f : fruits) {
            result.append(f.getClass().getSimpleName()).append(", ");
        }
        return result.toString();
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
        if (fruits.size() <= 0) {
            throw new IllegalArgumentException("Macedoine cannot be empty");
        } else {
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
    
    @Override
    public boolean equals(Object o) { 
        if (o != null && getClass() == o.getClass()) {
            Macedoine m = (Macedoine) o;
            int compt = 0;
            if (m.fruits.size() == this.fruits.size()) {
                for (Fruit f : m.fruits) {
                    if (this.fruits.contains(f)) {
                        compt++;
                    }
                }
                return compt == m.fruits.size();
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.fruits);
        return hash;
    }
    
    public Object[][] toObject() {
        Map<Fruit, Integer> fruitWithQuantity = new HashMap<>();

        for (Fruit fruit : fruits) {
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
