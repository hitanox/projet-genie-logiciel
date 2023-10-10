package fr.ufrsciencestech.panier.model.fruits;

import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class FruitSimpleTest {

    @Test
    public void testGetSetPrix() {
        FruitSimple fs = mock(FruitSimple.class);
        fs.setPrix(1.99);
        verify(fs).setPrix(1.99);

        when(fs.getPrix()).thenReturn(2.00);
        assertEquals(2.00, fs.getPrix(), 0.001);
    }

    
    public void testGetSetOrigine() {
        FruitSimple fs = mock(FruitSimple.class);
        fs.setOrigine("Papouasie-Nouvelle-Guinée");
        verify(fs).setOrigine("Papouasie-Nouvelle-Guinée");

        when(fs.getOrigine()).thenReturn("Papouasie-Nouvelle-Guinée");
        assertEquals("Papouasie-Nouvelle-Guinée", fs.getOrigine());
    }

    
    public void testGetSetSeedless() {
        FruitSimple fs = mock(FruitSimple.class);
        fs.setSeedless(true);
        verify(fs).setSeedless(true);

        when(fs.isSeedless()).thenReturn(true);
        assertEquals(true, fs.isSeedless());
    }

    
    public void testTestToString() {
        FruitSimple fs = mock(FruitSimple.class);

        when(fs.getNom()).thenReturn("Pomme");
        when(fs.getPrix()).thenReturn(10.0);
        when(fs.getOrigine()).thenReturn("France");

        assertEquals("Pomme de France a 10.0 euros.", fs.toString());
    }
    
    public void testTestEquals() {
        
    }
    
}