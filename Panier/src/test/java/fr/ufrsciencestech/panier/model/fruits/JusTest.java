package fr.ufrsciencestech.panier.model.fruits;
import static junit.framework.TestCase.*;

import org.junit.Test;


public class JusTest {

    Fruit jFruit = new Jus(new Orange());

    @Test
    public void testToString(){
        assertEquals("Jus(Orange)", jFruit.toString());
    }

    @Test
    public void testIsSeedLess(){
        assertFalse(jFruit.isSeedless());
    }

    @Test
    public void testGetPrix(){
        assertEquals(2.0, jFruit.getPrix());
    }

    @Test
    public void testGetOrigine(){
        assertEquals("France", jFruit.getOrigine());
    }

}
