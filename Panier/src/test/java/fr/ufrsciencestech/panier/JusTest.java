package fr.ufrsciencestech.panier;
import static junit.framework.TestCase.assertEquals;
import org.junit.Test;
import fr.ufrsciencestech.panier.model.*;


public class JusTest {

    Fruit jFruit = new Jus(new Orange());

    @Test
    public void testToString(){
        assertEquals("Jus(Orange)", jFruit.toString());
    }
    
}
