package fr.ufrsciencestech.panier.model;

import fr.ufrsciencestech.panier.model.fruits.Fruit;
import fr.ufrsciencestech.panier.model.fruits.fruitsimple.FruitSimple;
import fr.ufrsciencestech.panier.model.fruits.fruitspecifique.Jus;
import fr.ufrsciencestech.panier.model.fruits.fruitspecifique.Macedoine;
import fr.ufrsciencestech.panier.model.panier.Panier;

import java.util.ArrayList;

public interface ProductFactory {
    Panier createPanier(int size);

    FruitSimple createFruitSimple(String name, double prix, String origine);

    FruitSimple createFruitSimple(String name);

    Macedoine createMacedoine(ArrayList<Fruit> fruits);

    Jus createJus(Fruit fruit);
}
