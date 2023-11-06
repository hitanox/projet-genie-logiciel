package fr.ufrsciencestech.panier.model.fruits.fruitsimple;

public class AnyFruit extends FruitSimple {
    public String name;
    public boolean isSeedless;

    public AnyFruit(String name, Double prix, String origine, boolean isSeedless) {
        super(prix, origine, isSeedless);
        this.name = name;
    }

    @Override
    public String getNom() {
        return name;
    }
}
