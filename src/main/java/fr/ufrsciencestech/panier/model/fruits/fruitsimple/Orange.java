package fr.ufrsciencestech.panier.model.fruits.fruitsimple;

public class Orange extends FruitSimple {
    public Orange(Double prix, String origine) {
        super("Orange", prix, origine, false);
    }

    public Orange() {
        super("Orange",2.0, "France", false);
    }
}
