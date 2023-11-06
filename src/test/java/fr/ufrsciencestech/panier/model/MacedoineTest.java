package fr.ufrsciencestech.panier.model;

import fr.ufrsciencestech.panier.model.fruits.FruitFactory;
import fr.ufrsciencestech.panier.model.fruits.fruitsimple.FruitSimple;
import fr.ufrsciencestech.panier.model.fruits.fruitspecifique.Jus;
import fr.ufrsciencestech.panier.model.fruits.fruitspecifique.Macedoine;
import fr.ufrsciencestech.panier.model.panier.Panier;
import fr.ufrsciencestech.panier.model.panier.PanierFactory;
import fr.ufrsciencestech.panier.model.panier.PanierPleinException;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertEquals;

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
    public void testExceptionAddMacedoineInMacedoine() {
        Macedoine m = ff.createMacedoine(panierTest.getFruits());
        try {
            m = ff.createMacedoine(panierTest.getFruits());
        } catch (IllegalArgumentException e) {
            assertEquals("Macedoine cannot contain another Macedoine", e.getMessage());
        }
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

}
