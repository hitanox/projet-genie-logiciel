package fr.ufrsciencestech.panier.model.fruits;

import junit.framework.TestCase;

public class PoireTest extends TestCase {

    public void testGetNom() {
        Poire p = new Poire();
        assertEquals("Poire", p.getNom());
    }
}