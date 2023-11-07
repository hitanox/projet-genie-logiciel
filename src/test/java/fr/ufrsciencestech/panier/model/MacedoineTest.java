package fr.ufrsciencestech.panier.model;

import fr.ufrsciencestech.panier.model.fruits.Fruit;
import fr.ufrsciencestech.panier.model.fruits.FruitFactory;
import fr.ufrsciencestech.panier.model.fruits.fruitsimple.*;
import fr.ufrsciencestech.panier.model.fruits.fruitspecifique.Jus;
import fr.ufrsciencestech.panier.model.fruits.fruitspecifique.Macedoine;
import fr.ufrsciencestech.panier.model.panier.Panier;
import fr.ufrsciencestech.panier.model.panier.PanierFactory;
import fr.ufrsciencestech.panier.model.panier.PanierPleinException;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MacedoineTest {

    PanierFactory pf = new PanierFactory();
    Panier panierTest = pf.createPanier(10);
    FruitFactory ff = new FruitFactory();
    FruitSimple orange = ff.createFruitSimple("Orange");
    FruitSimple poire = ff.createFruitSimple("Poire");

    @Before
    public void setUp() throws Exception {
        panierTest.ajout(orange, 1);
        panierTest.ajout(poire, 1);
    }

    @Test
    public void testToString() {
        Macedoine m = ff.createMacedoine(panierTest.getFruits());
        assertEquals("Macedoine de Orange, Poire a 2.8 euros", m.toString());
    }

    @Test
    public void testIsSeedless() {
        Macedoine m = ff.createMacedoine(panierTest.getFruits());
        assertFalse(m.isSeedless());
    }

    @Test
    public void testGetPrix() {
        Macedoine m = ff.createMacedoine(panierTest.getFruits());
        assertEquals(2.8, m.getPrix());
    }

    @Test
    public void testGetOrigine() {
        Macedoine m = ff.createMacedoine(panierTest.getFruits());
        assertEquals("France", m.getOrigine());
    }

    @Test
    public void testExceptionAddMacedoineInMacedoine() {
        Macedoine m = ff.createMacedoine(panierTest.getFruits());
        try {
            m = ff.createMacedoine(panierTest.getFruits());
        } catch (IllegalArgumentException e) {
            assertEquals("Macedoine cannot contain another Macedoine", e.getMessage());
        }
    }

    @Test
    public void testAddFruit() {
        Macedoine m = ff.createMacedoine(panierTest.getFruits());
        FruitSimple cerise = ff.createFruitSimple("Cerise");
        m.add(cerise);
        assertTrue(m.getFruits().contains(cerise));
    }

    @Test
    public void testExceptionAddJusInMacedoine() throws PanierPleinException {
        Macedoine m = ff.createMacedoine(panierTest.getFruits());
        Jus j = ff.createJus(orange);
        panierTest.ajout(j, 1);
        try {
            m = ff.createMacedoine(panierTest.getFruits());
        } catch (IllegalArgumentException e) {
            assertEquals("Macedoine cannot contain a Jus", e.getMessage());
        }
    }

    @Test
    public void testToObject() throws PanierPleinException {
        Panier panier = pf.createPanier(10);
        FruitSimple pomme = ff.createFruitSimple("Pomme");
        FruitSimple banane = ff.createFruitSimple("Banane");
        FruitSimple kiwi = ff.createFruitSimple("Kiwi");

        panier.ajout(pomme, 1);
        panier.ajout(banane, 1);
        panier.ajout(kiwi, 1);

        Macedoine m = ff.createMacedoine(panier.getFruits());
        Object[][] res = m.toObject();

        Object[][] expected = new Object[][]{
                {"Banane", 1.99, "Papouasie-Nouvelle-Guinée", 1},
                {"Pomme", 1.35, "Asie", 1},
                {"Kiwi", 2.99, "Chine", 1}
        };

        assertEquals(res.length, expected.length);
        for (int i = 0; i < res.length; i++) {
            assertEquals(res[i][0], expected[i][0]);
            assertEquals(res[i][3], expected[i][3]);
        }
    }

    @Test
    public void testEquals() throws PanierPleinException {
        FruitSimple pomme = ff.createFruitSimple("Pomme");
        FruitSimple banane = ff.createFruitSimple("Banane");
        FruitSimple kiwi = ff.createFruitSimple("Kiwi");

        ArrayList<Fruit> fruits = new ArrayList<>();
        fruits.add(pomme);
        fruits.add(banane);
        fruits.add(kiwi);

        Macedoine m1 = ff.createMacedoine(fruits);

        FruitSimple pomme2 = ff.createFruitSimple("Pomme");
        FruitSimple banane2 = ff.createFruitSimple("Banane");
        FruitSimple kiwi2 = ff.createFruitSimple("Kiwi");

        ArrayList<Fruit> fruits2 = new ArrayList<>();
        fruits2.add(pomme2);
        fruits2.add(banane2);
        fruits2.add(kiwi2);

        Macedoine m2 = ff.createMacedoine(fruits2);

        FruitSimple papaye = ff.createFruitSimple("Papaye");
        FruitSimple poire = ff.createFruitSimple("Poire");
        FruitSimple litchi = ff.createFruitSimple("Litchi");

        ArrayList<Fruit> fruits3 = new ArrayList<>();
        fruits3.add(papaye);
        fruits3.add(poire);
        fruits3.add(litchi);

        Macedoine m3 = ff.createMacedoine(fruits3);

        assertTrue(m1.equals(m2));
        assertFalse(m1.equals(m3));
    }

    @Test
    public void testGetNom() {
        Macedoine m = ff.createMacedoine(panierTest.getFruits());
        assertEquals("Macedoine de Orange, Poire, ", m.getNom());
    }

    @Test
    public void testHashCode() {
        Macedoine m1 = new Macedoine();
        m1.add(new Orange());
        m1.add(new Pomme());
        m1.add(new Poire());

        Macedoine m2 = new Macedoine();
        m2.add(new Orange());
        m2.add(new Pomme());
        m2.add(new Poire());

        assertEquals(m1.hashCode(), m2.hashCode());

        Macedoine m3 = new Macedoine();
        m3.add(new Orange());
        m3.add(new Pomme());
        m3.add(new Cerise());

        assertNotEquals(m1.hashCode(), m3.hashCode());
    }

    @Test
    public void testCheckFruits() {
        Macedoine macedoine = new Macedoine();

        ArrayList<Fruit> fruits = new ArrayList<>();
        fruits.add(new Pomme());
        fruits.add(new Banane());

        Jus jusTest = new Jus(new Orange());

        fruits.add(jusTest);

        Macedoine macedoineTest = new Macedoine();

        fruits.add(macedoineTest);

        try {
            macedoine.checkFruits(fruits);
            fail("IllegalArgumentException should be thrown for an invalid list of fruits.");
        } catch (IllegalArgumentException e) {
            assertEquals("Macedoine cannot contain a Jus", e.getMessage());
        }
    }

    @Test
    public void testCheckFruitsEmptyList() {
        Macedoine macedoine = new Macedoine();
        ArrayList<Fruit> fruits = new ArrayList<>();

        try {
            macedoine.checkFruits(fruits);
            fail("IllegalArgumentException should be thrown for an empty list of fruits.");
        } catch (IllegalArgumentException e) {
            assertEquals("Macedoine cannot be empty", e.getMessage());
        }
    }

    @Test
    public void testCheckFruitsWithJus() {
        Macedoine macedoine = new Macedoine();
        ArrayList<Fruit> fruits = new ArrayList<>();
        fruits.add(new Pomme());
        fruits.add(new Jus(new Orange()));

        try {
            macedoine.checkFruits(fruits);
            fail("IllegalArgumentException should be thrown for a list containing Jus.");
        } catch (IllegalArgumentException e) {
            assertEquals("Macedoine cannot contain a Jus", e.getMessage());
        }
    }

    @Test
    public void testCheckFruitsWithMacedoine() {
        Macedoine macedoine = new Macedoine();
        ArrayList<Fruit> fruits = new ArrayList<>();
        fruits.add(new Pomme());
        fruits.add(new Macedoine());

        try {
            macedoine.checkFruits(fruits);
            fail("IllegalArgumentException should be thrown for a list containing another Macedoine.");
        } catch (IllegalArgumentException e) {
            assertEquals("Macedoine cannot contain another Macedoine", e.getMessage());
        }
    }

    @Test
    public void testCheckFruitsValidList() {
        Macedoine macedoine = new Macedoine();
        ArrayList<Fruit> fruits = new ArrayList<>();
        fruits.add(new Pomme());
        fruits.add(new Banane());

        try {
            macedoine.checkFruits(fruits);
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException should not be thrown for a valid list of fruits.");
        }
    }

}
