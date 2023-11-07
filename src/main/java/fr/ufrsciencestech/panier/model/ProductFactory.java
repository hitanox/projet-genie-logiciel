package fr.ufrsciencestech.panier.model;

import fr.ufrsciencestech.panier.model.fruits.Fruit;
import fr.ufrsciencestech.panier.model.fruits.fruitsimple.FruitSimple;
import fr.ufrsciencestech.panier.model.fruits.fruitspecifique.Jus;
import fr.ufrsciencestech.panier.model.fruits.fruitspecifique.Macedoine;
import fr.ufrsciencestech.panier.model.panier.Panier;

import java.util.ArrayList;

public interface ProductFactory {
    /**
     * Retourne un panier de taille size
     * @param size
     * @return
     */
    Panier createPanier(int size);

    /**
     * Retourne un fruit simple créé à partir d'un nom, d'un prix et d'une origine
     * @param name nom
     * @param prix prix
     * @param origine origine
     * @return le fruit créé
     */
    FruitSimple createFruitSimple(String name, double prix, String origine);

    /**
     * Retourne un fruit simple créé à partir d'un nom
     * @param name nom
     * @return le fruit créé
     */
    FruitSimple createFruitSimple(String name);

    /**
     * Retourne une macédoine créée à partir d'une liste de fruits
     * @param fruits liste de fruits
     * @return la macédoine créée
     */
    Macedoine createMacedoine(ArrayList<Fruit> fruits);

    /**
     * Retourne un jus créé à partir d'un fruit
     * @param fruit fruit
     * @return le jus créé
     */
    Jus createJus(Fruit fruit);
}
