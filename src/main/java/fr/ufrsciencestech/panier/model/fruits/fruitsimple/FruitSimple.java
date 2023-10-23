package fr.ufrsciencestech.panier.model.fruits.fruitsimple;

import fr.ufrsciencestech.panier.model.fruits.Fruit;

//Donne un parametre de plus a la classe FruitSimple qui est un nom qui peut etre null
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
    @Override
    public boolean isSeedless() {
        return isSeedless;
    }
    public void setSeedless(boolean seedless) {
        isSeedless = seedless;
    }
    @Override
    public double getPrix() {
        return prix;
    }
    public void setPrix(double prix) {
        this.prix = prix;
    }
    @Override
    public String getOrigine() {
        return origine;
    }
    public void setOrigine(String origine) {
        this.origine = origine;
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && getClass() == o.getClass()) {
            FruitSimple fruit = (FruitSimple) o;
            return (prix == fruit.prix && origine.equals(fruit.origine));
        }
        return false;
    }

    @Override
    public String toString() {
        return this.getNom() + " de " + origine + " a " + prix + " euros.";
    }

}
