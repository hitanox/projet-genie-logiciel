package fr.ufrsciencestech.panier.model.fruits;
import static junit.framework.TestCase.*;

import fr.ufrsciencestech.panier.model.fruits.fruitsimple.FruitSimple;
import fr.ufrsciencestech.panier.model.fruits.fruitspecifique.Jus;
import org.junit.Test;


public class JusTest {

    FruitFactory ff = new FruitFactory();
    FruitSimple papaye = ff.createFruitSimple("Papaye");
    Jus jFruit = ff.createJus(papaye);

    @Test
    public void testToString(){
        assertEquals("Jus(Papaye)", jFruit.toString());
    }
    @Test
    public void testIsSeedLess(){
        assertTrue(jFruit.isSeedless());
    }
    @Test
    public void testGetPrix(){
        assertEquals(2.99, jFruit.getPrix());
    }
    @Test
    public void testGetOrigine(){
        assertEquals("Mexique", jFruit.getOrigine());
    }

    @Test
    public void testExceptionAddJusInJus(){
        try{
            Jus jFruit2 = ff.createJus(jFruit);
        }
        catch(IllegalArgumentException e){
            assertEquals("Jus cannot contain another Jus", e.getMessage());
        }
    }

}
