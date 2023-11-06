package fr.ufrsciencestech.panier.model.fruits.fruitsimple;

public class AnyFruit extends FruitSimple {
    public String name;

    public AnyFruit(String name, Double prix, String origine) {
        super(prix, origine, false);
        this.name = name;
    }

    @Override
    public String getNom() {
        return name;
    }
}
