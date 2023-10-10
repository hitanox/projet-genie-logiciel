package fr.ufrsciencestech.panier.model;

public abstract class FruitDecorator implements Fruit {
    private Fruit fruit;

    public FruitDecorator(Fruit fruit) {
        this.fruit = fruit;
    }

    public Fruit getFruit() {
        return this.fruit;
    }

    @Override
    public String toString() {
        return fruit.toString();
    }
}