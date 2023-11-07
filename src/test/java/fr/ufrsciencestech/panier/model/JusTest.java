package fr.ufrsciencestech.panier.model;
import static junit.framework.TestCase.*;
import static org.junit.Assert.assertNotEquals;

import fr.ufrsciencestech.panier.model.fruits.FruitFactory;
import fr.ufrsciencestech.panier.model.fruits.fruitsimple.FruitSimple;
import fr.ufrsciencestech.panier.model.fruits.fruitspecifique.Jus;
import org.junit.Test;


public class JusTest {

    FruitFactory ff = new FruitFactory();
    FruitSimple papaye = ff.createFruitSimple("Papaye");
    Jus jFruit = ff.createJus(papaye);

    @Test
    public void testToString(){
        assertEquals("Jus(Papaye) de Mexique a 2.99 euros", jFruit.toString());
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

    @Test
    public void testHashCode(){
        Jus jFruit2 = ff.createJus(papaye);
        assertEquals(jFruit.hashCode(), jFruit2.hashCode());
        Jus jFruit3 = ff.createJus(ff.createFruitSimple("Pomme"));
        assertNotEquals(jFruit.hashCode(), jFruit3.hashCode());
    }

}
