package fr.ufrsciencestech.panier.model;

public abstract class FruitSimple {
    private String nom;
    private double prix;
    private String origine;
    private boolean isSeedless;

    public FruitSimple(double prix, String origine, boolean isSeedless) {
        this.prix = prix;
        this.origine = origine;
        this.isSeedless = isSeedless;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getOrigine() {
        return origine;
    }

    public void setOrigine(String origine) {
        this.origine = origine;
    }

    public boolean isSeedless() {
        return isSeedless;
    }

    public void setSeedless(boolean seedless) {
        isSeedless = seedless;
    }

    public String toJuice() {
        return this.nom;
    }

    @Override
    public String toString(){
        return this.nom+" de " + origine + " a " + prix + " euros.";
    }

    @Override
    public boolean equals(Object o) {
        if(o != null && getClass() == o.getClass()){
            FruitSimple fruit = (FruitSimple) o;
            return (prix == fruit.prix && origine.equals(fruit.origine));
        }
        return false;
    }
}
