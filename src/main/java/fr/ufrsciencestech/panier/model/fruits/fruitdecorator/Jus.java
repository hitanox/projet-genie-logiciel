package fr.ufrsciencestech.panier.model.fruits.fruitdecorator;

import fr.ufrsciencestech.panier.model.fruits.Fruit;

public class Jus extends FruitDecorator {


    public Jus(Fruit fruit) {
        super(fruit);
    }

    public String toString() {
        return "Jus(" + super.toString().split(" ")[0] + ")";
    }

    @Override
    public boolean isSeedless() {
        return super.getFruit().isSeedless();
    }

    @Override
    public double getPrix() {
        return super.getFruit().getPrix();
    }

    @Override
    public String getOrigine() {
        return super.getFruit().getOrigine();
    }

    @Override
    public String getNom() {
        return "Jus";
    }
}