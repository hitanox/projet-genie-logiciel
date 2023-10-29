package fr.ufrsciencestech.panier.model.fruits;

import java.util.HashMap;

public class FruitHelper {
    public static HashMap<String, String> getDefaultValuesFor(String fruitSimple) {
        FruitFactory factory = new FruitFactory();
        Fruit fruit = factory.createFruitSimple(fruitSimple);

        HashMap<String, String> values = new HashMap<String, String>();
        values.put("origin", fruit.getOrigine());
        values.put("price", String.valueOf(fruit.getPrix()));

        return values;
    }
}
