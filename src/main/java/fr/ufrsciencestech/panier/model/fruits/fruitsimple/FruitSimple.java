package fr.ufrsciencestech.panier.model.fruits.fruitsimple;

import fr.ufrsciencestech.panier.model.fruits.Fruit;

public abstract class FruitSimple implements Fruit {
    private double prix;
    private String origine;
    private boolean isSeedless;

    public FruitSimple(double prix, String origine, boolean isSeedless) {
        this.prix = prix;
        this.origine = origine;
        this.isSeedless = isSeedless;
    }

    public abstract String getNom();

    
    /** 
     * @return double
     */
    public double getPrix() {
        return prix;
    }

    
    /** 
     * @param prix
     */
    public void setPrix(double prix) {
        this.prix = prix;
    }

    
    /** 
     * @return String
     */
    public String getOrigine() {
        return origine;
    }

    
    /** 
     * @param origine
     */
    public void setOrigine(String origine) {
        this.origine = origine;
    }

    
    /** 
     * @return boolean
     */
    public boolean isSeedless() {
        return isSeedless;
    }

    
    /** 
     * @param seedless
     */
    public void setSeedless(boolean seedless) {
        isSeedless = seedless;
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return this.getNom() + " de " + origine + " a " + prix + " euros";
    }

    
    /** 
     * @param o fruit simple à comparer avec l'instance courante
     * @return boolean résultat
     */
    @Override
    public boolean equals(Object o) {
        if (o != null && getClass() == o.getClass()) {
            FruitSimple fruit = (FruitSimple) o;
            return (prix == fruit.prix && origine.equals(fruit.origine));
        }
        return false;
    }

    
    /** 
     * @return int hashcode assoocié au fruit
     */
    @Override
    public int hashCode() {
        int result = Double.hashCode(prix);
        result = 31 * result + origine.hashCode();
        return result;
    }
}
