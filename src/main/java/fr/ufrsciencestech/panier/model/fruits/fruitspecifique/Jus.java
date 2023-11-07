package fr.ufrsciencestech.panier.model.fruits.fruitspecifique;

import fr.ufrsciencestech.panier.model.fruits.Fruit;

public class Jus implements Fruit {

    private final Fruit fruit;

    public Jus(Fruit fruit) {
        super();
        checkFruit(fruit);
        this.fruit = fruit;
    }

    
    /** 
     * @return Fruit
     */
    public Fruit getFruit() {
        return fruit;
    }

    
    /** 
     * @return boolean
     */
    @Override
    public boolean isSeedless() {
        return this.getFruit().isSeedless();
    }

    
    /** 
     * @return double
     */
    @Override
    public double getPrix() {
        return this.getFruit().getPrix();
    }

    
    /** 
     * @return String
     */
    @Override
    public String getOrigine() {
        return this.getFruit().getOrigine();
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return this.getNom() + " de " + this.getOrigine() + " a " + this.getPrix() + " euros";
    }

    
    /** 
     * @return String
     */
    @Override
    public String getNom() {
        return "Jus(" + fruit.toString().split(" ")[0] + ")";
    }

    
    /** 
     * @param o jus à comparer avec l'instance courante
     * @return boolean résultat
     */
    @Override
    public boolean equals(Object o) {
        if (o != null && getClass() == o.getClass()) {
            Jus fruit = (Jus) o;
            return (this.fruit.getPrix() == fruit.getPrix() && this.fruit.getOrigine().equals(fruit.getOrigine()));
        }
        return false;
    }

    
    /** 
     * @return int hashcode assoocié au jus
     */
    @Override
    public int hashCode() {
        int result = Double.hashCode(this.fruit.getPrix());
        result = 31 * result + this.fruit.getOrigine().hashCode();
        return result;
    }

    
    /** Vérifie que le fruit placé en paramètre ne soit pas un jus
     * @param fruit
     */
    private void checkFruit(Fruit fruit) {
        if (fruit.getClass() == Jus.class) {
            throw new IllegalArgumentException("Jus cannot contain another Jus");
        }
    }
}
