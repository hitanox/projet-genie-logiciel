package fr.ufrsciencestech.panier.model.recipe.fruitspecifique;

import fr.ufrsciencestech.panier.model.fruits.Fruit;
import fr.ufrsciencestech.panier.model.fruits.fruitsimple.FruitSimple;

public class Jus implements Fruit {

    private FruitSimple fruit;
    public Jus(FruitSimple fruit) {
        super();
        this.fruit = fruit;
    }

    public FruitSimple getFruit() {
        return fruit;
    }

    @Override
    public boolean isSeedless() {return this.getFruit().isSeedless();}

    @Override
    public double getPrix() { return this.getFruit().getPrix(); }

    @Override
    public String getOrigine() {return this.getFruit().getOrigine();}

    @Override
    public String toString() {
        return "Jus(" + fruit.toString().split(" ")[0] + ")";
    }
}
