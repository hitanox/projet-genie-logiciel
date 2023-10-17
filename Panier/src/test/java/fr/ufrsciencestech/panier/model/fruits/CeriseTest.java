package fr.ufrsciencestech.panier.model.fruits;

import fr.ufrsciencestech.panier.model.fruits.fruitsimple.Cerise;
import junit.framework.TestCase;

public class CeriseTest extends TestCase {

    public void testGetNom() {
        Cerise c = new Cerise();
        assertEquals("Cerise", c.getNom());
    }
}