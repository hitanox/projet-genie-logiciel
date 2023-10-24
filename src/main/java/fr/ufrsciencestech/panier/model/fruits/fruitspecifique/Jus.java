package fr.ufrsciencestech.panier.model.fruits.fruitspecifique;

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

    @Override
    public String getNom() {
        return "Jus(" + fruit.toString().split(" ")[0] + ")";
    }
    
    @Override
    public boolean equals(Object o) {
        if (o != null && getClass() == o.getClass()) {
            Jus fruit = (Jus) o;
            return (this.fruit.getPrix() == fruit.getPrix() && this.fruit.getOrigine().equals(fruit.getOrigine()));
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        int result = Double.hashCode(this.fruit.getPrix());
        result = 31 * result + this.fruit.getOrigine().hashCode();
        return result;
    }
}
