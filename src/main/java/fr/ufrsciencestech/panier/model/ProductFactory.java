package fr.ufrsciencestech.panier.model;

import fr.ufrsciencestech.panier.model.fruits.Fruit;
import fr.ufrsciencestech.panier.model.fruits.fruitSimple.FruitSimple;
import fr.ufrsciencestech.panier.model.fruits.fruitspecifique.Jus;
import fr.ufrsciencestech.panier.model.fruits.fruitspecifique.Macedoine;
import fr.ufrsciencestech.panier.model.panier.Panier;

import java.util.ArrayList;

public interface ProductFactory {
    public Panier createPanier(int size);
    public FruitSimple createFruitSimple(String name, double prix, String origine, boolean isSeedless);
    public FruitSimple createFruitSimple(String name, double prix, String origine);
    public FruitSimple createFruitSimple(String name);
    public Macedoine createMacedoine(ArrayList<Fruit> fruits);
    public Jus createJus(Fruit fruit);
}
