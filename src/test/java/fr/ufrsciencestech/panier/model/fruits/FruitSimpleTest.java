package fr.ufrsciencestech.panier.model.fruits;

import fr.ufrsciencestech.panier.model.fruits.fruitsimple.Banane;
import fr.ufrsciencestech.panier.model.fruits.fruitsimple.Cerise;
import org.junit.Test;
import static org.junit.Assert.*;


public class FruitSimpleTest {

    Cerise cerise = new Cerise();

    @Test
    public void testGetSetPrix() {
        cerise.setPrix(1.99);
        assertEquals(1.99, cerise.getPrix(), 0.001);
    }

    @Test
    public void testGetSetOrigine() {
        cerise.setOrigine("Papouasie-Nouvelle-Guinée");
        assertEquals("Papouasie-Nouvelle-Guinée", cerise.getOrigine());
    }

    @Test
    public void testGetSetSeedless() {
        cerise.setSeedless(false);
        assertFalse(cerise.isSeedless());
    }

    @Test
    public void testTestToString() {
        assertEquals("Cerise de Caucase a 6.5 euros.", cerise.toString());
    }
    
    @Test
    public void testTestEquals() {
        Cerise cerise2 = new Cerise();
        Banane banane = new Banane();

        assertTrue(cerise.equals(cerise2));
        assertFalse(cerise.equals(banane));
    }
    
}