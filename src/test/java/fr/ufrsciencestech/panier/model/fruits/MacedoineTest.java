package fr.ufrsciencestech.panier.model.fruits;

import fr.ufrsciencestech.panier.model.fruits.fruitSimple.Orange;
import fr.ufrsciencestech.panier.model.fruits.fruitSimple.Poire;
import fr.ufrsciencestech.panier.model.fruits.fruitspecifique.Macedoine;
import fr.ufrsciencestech.panier.model.panier.Panier;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertEquals;

public class MacedoineTest {

    Panier panierTest = new Panier(10);
    Orange orange1 = new Orange(0.5, "France");
    Poire poire1= new Poire(1.0, "France");

    @Before
    public void setUp() throws Exception {
        panierTest.ajout(orange1);
        panierTest.ajout(poire1);
    }

    @Test
    public void testToString() {
        Macedoine m = new Macedoine(panierTest.getFruits());
        assertEquals("Macedoine de Orange, Poire a 1.5 euros", m.toString());
    }

    @Test
    public void testIsSeedless() {
        Macedoine m = new Macedoine(panierTest.getFruits());
        assertFalse(m.isSeedless());
    }

    @Test
    public void testGetPrix() {
        ArrayList<Fruit> fruits = new ArrayList<Fruit>();
        fruits.add(new Orange(0.5, "France"));
        fruits.add(new Poire(1.0, "France"));
        Macedoine m = new Macedoine(fruits);
        assertEquals(1.5, m.getPrix());
    }

}
