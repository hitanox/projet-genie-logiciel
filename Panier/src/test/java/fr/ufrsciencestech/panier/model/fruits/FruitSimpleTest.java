package fr.ufrsciencestech.panier.model.fruits;

import junit.framework.TestCase;

import static org.mockito.Mockito.mock;

public class FruitSimpleTest extends TestCase {
    public void testGetSetNom() {
        FruitSimple fs = mock(FruitSimple.class);
    }

    public void testGetSetPrix() {
        FruitSimple fs = mock(FruitSimple.class);
        fs.setPrix(1.99);
        assertEquals(1.99, fs.getPrix());
    }

    public void testGetSetOrigine() {
        FruitSimple fs = mock(FruitSimple.class);
        fs.setOrigine("Papouasie-Nouvelle-Guinée");
        assertEquals("Papouasie-Nouvelle-Guinée", fs.getOrigine());
    }

    public void testGetSetSeedless() {
        FruitSimple fs = mock(FruitSimple.class);
        fs.setSeedless(true);
        assertTrue(fs.isSeedless());
    }

    public void testToJuice() {

    }

    public void testTestToString() {

    }

    public void testTestEquals() {
    }
}