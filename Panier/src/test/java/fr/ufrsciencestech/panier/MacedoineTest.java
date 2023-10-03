package fr.ufrsciencestech.panier;

import fr.ufrsciencestech.panier.model.Macedoine;
import fr.ufrsciencestech.panier.model.Orange;
import fr.ufrsciencestech.panier.model.Panier;
import fr.ufrsciencestech.panier.model.Poire;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertEquals;

public class MacedoineTest {

    Panier panierTest = new Panier(10);
    Orange orange1 = new Orange(0.5, "France");
    Poire poire1= new Poire(1, "France");

    @Before
    public void setUp() throws Exception {
        panierTest.ajout(orange1);
        panierTest.ajout(poire1);
    }

    @Test
    public void testToString() {
        Macedoine m = new Macedoine(panierTest.getFruits());
        assertEquals("Macedoine de Orange, Poire a 1.5 euros", m.toString());
    }

    @Test
    public void testIsSeedless() {
        Macedoine m = new Macedoine(panierTest.getFruits());
        assertFalse(m.isSeedless());
    }

    @Test
    public void testGetPrix() {
        Macedoine m = new Macedoine(panierTest.getFruits());
        assertEquals(1.5, m.getPrix());
    }

}
