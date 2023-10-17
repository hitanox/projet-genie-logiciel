package fr.ufrsciencestech.panier.model.fruits;

import fr.ufrsciencestech.panier.model.fruits.fruitsimple.Orange;
import junit.framework.TestCase;

public class OrangeTest extends TestCase {

    public void testGetNom() {
        Orange o = new Orange();
        assertEquals("Orange", o.getNom());
    }
}