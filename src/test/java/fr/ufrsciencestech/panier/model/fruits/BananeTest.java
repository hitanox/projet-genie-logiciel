package fr.ufrsciencestech.panier.model.fruits;

import fr.ufrsciencestech.panier.model.fruits.fruitsimple.Banane;
import junit.framework.TestCase;

public class BananeTest extends TestCase {

    public void testGetNom() {
        Banane b = new Banane();
        assertEquals("Banane", b.getNom());
    }
}