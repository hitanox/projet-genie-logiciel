package fr.ufrsciencestech.panier.model.fruits;
import static junit.framework.TestCase.assertEquals;

import fr.ufrsciencestech.panier.model.fruits.Fruit;
import fr.ufrsciencestech.panier.model.fruits.Jus;
import fr.ufrsciencestech.panier.model.fruits.Orange;
import org.junit.Test;


public class JusTest {

    Fruit jFruit = new Jus(new Orange());

    @Test
    public void testToString(){
        assertEquals("Jus(Orange)", jFruit.toString());
    }
    
}
