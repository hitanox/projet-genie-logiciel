package fr.ufrsciencestech.panier.model.fruits;

import junit.framework.TestCase;

public class OrangeTest extends TestCase {

    public void testGetNom() {
        Orange o = new Orange();
        assertEquals("Orange", o.getNom());
    }
}