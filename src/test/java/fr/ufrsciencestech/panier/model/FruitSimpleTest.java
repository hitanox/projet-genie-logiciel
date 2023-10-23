package fr.ufrsciencestech.panier.model;

import fr.ufrsciencestech.panier.model.fruits.FruitFactory;
import fr.ufrsciencestech.panier.model.fruits.fruitsimple.FruitSimple;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FruitSimpleTest {

    FruitFactory ff = new FruitFactory();

    // Test passing the getNom() method of FruitSimple inheriting classes
    @Test
    public void testGetNom() {
        FruitSimple ananas = ff.createFruitSimple("Ananas");
        assertEquals("Ananas", ananas.getNom());
        FruitSimple banane = ff.createFruitSimple("Banane");
        assertEquals("Banane", banane.getNom());
        FruitSimple cerise = ff.createFruitSimple("Cerise");
        assertEquals("Cerise", cerise.getNom());
        FruitSimple caroube = ff.createFruitSimple("Caroube");
        assertEquals("Caroube", caroube.getNom());
        FruitSimple kiwi = ff.createFruitSimple("Kiwi");
        assertEquals("Kiwi", kiwi.getNom());
        FruitSimple orange = ff.createFruitSimple("Orange");
        assertEquals("Orange", orange.getNom());
        FruitSimple poire = ff.createFruitSimple("Poire");
        assertEquals("Poire", poire.getNom());
        FruitSimple pomme = ff.createFruitSimple("Pomme");
        assertEquals("Pomme", pomme.getNom());
        FruitSimple tomate = ff.createFruitSimple("Tomate");
        assertEquals("Tomate", tomate.getNom());
        FruitSimple fraise = ff.createFruitSimple("Fraise");
        assertEquals("Fraise", fraise.getNom());
        FruitSimple litchi = ff.createFruitSimple("Litchi");
        assertEquals("Litchi", litchi.getNom());
        FruitSimple papaye = ff.createFruitSimple("Papaye");
        assertEquals("Papaye", papaye.getNom());
        FruitSimple specialFruit = ff.createFruitSimple("SpecialFruit", 0.0, "France", false);
        assertEquals("SpecialFruit", specialFruit.getNom());
    }

    @Test
    public void testConstructorBanane() {
        FruitSimple banane1 = ff.createFruitSimple("Banane");
        assertEquals("Banane", banane1.getNom());
        assertEquals(1.99, banane1.getPrix(), 0.001);
        assertEquals("Papouasie-Nouvelle-Guinée", banane1.getOrigine());
        assertEquals(true, banane1.isSeedless());
        FruitSimple banane2 = ff.createFruitSimple("Banane", 2.99, "France");
        assertEquals("Banane", banane2.getNom());
        assertEquals(2.99, banane2.getPrix(), 0.001);
        assertEquals("France", banane2.getOrigine());
        assertEquals(true, banane2.isSeedless());
    }

    @Test
    public void testConstructorAnanas() {
        FruitSimple ananas1 = ff.createFruitSimple("Ananas");
        assertEquals("Ananas", ananas1.getNom());
        assertEquals(2.0, ananas1.getPrix(), 0.001);
        assertEquals("Paraguay", ananas1.getOrigine());
        assertEquals(true, ananas1.isSeedless());
        FruitSimple ananas2 = ff.createFruitSimple("Ananas", 3.5, "France");
        assertEquals("Ananas", ananas2.getNom());
        assertEquals(3.5, ananas2.getPrix(), 0.001);
        assertEquals("France", ananas2.getOrigine());
        assertEquals(true, ananas2.isSeedless());
    }

    @Test
    public void testConstructorCerise() {
        FruitSimple cerise1 = ff.createFruitSimple("Cerise");
        assertEquals("Cerise", cerise1.getNom());
        assertEquals(6.5, cerise1.getPrix(), 0.001);
        assertEquals("Caucase", cerise1.getOrigine());
        assertEquals(false, cerise1.isSeedless());
        FruitSimple cerise2 = ff.createFruitSimple("Cerise", 7.5, "France");
        assertEquals("Cerise", cerise2.getNom());
        assertEquals(7.5, cerise2.getPrix(), 0.001);
        assertEquals("France", cerise2.getOrigine());
        assertEquals(false, cerise2.isSeedless());
    }



}
