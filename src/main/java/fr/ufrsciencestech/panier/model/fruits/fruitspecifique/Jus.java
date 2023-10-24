package fr.ufrsciencestech.panier.model.fruits.fruitspecifique;

import fr.ufrsciencestech.panier.model.fruits.Fruit;
import fr.ufrsciencestech.panier.model.fruits.fruitsimple.FruitSimple;

public class Jus implements Fruit {

    private Fruit fruit;
    public Jus(Fruit fruit) {
        super();
        checkFruit(fruit);
        this.fruit = fruit;
    }

    public Fruit getFruit() {
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

    private void checkFruit(Fruit fruit) {
        if (fruit.getClass() == Jus.class) {
            throw new IllegalArgumentException("Jus cannot contain another Jus");
        }
    }
}
