package fr.ufrsciencestech.panier.model.fruits;

import fr.ufrsciencestech.panier.model.fruits.fruitsimple.FruitSimple;
import org.junit.Test;

import static org.junit.Assert.*;

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

    @Test
    public void testConstructorCaroube() {
        FruitSimple caroube1 = ff.createFruitSimple("Caroube");
        assertEquals("Caroube", caroube1.getNom());
        assertEquals(3.20, caroube1.getPrix(), 0.001);
        assertEquals("Moyen-Orient", caroube1.getOrigine());
        assertEquals(true, caroube1.isSeedless());
        FruitSimple caroube2 = ff.createFruitSimple("Caroube", 0.6, "France");
        assertEquals("Caroube", caroube2.getNom());
        assertEquals(0.6, caroube2.getPrix(), 0.001);
        assertEquals("France", caroube2.getOrigine());
        assertEquals(true, caroube2.isSeedless());
    }

    @Test
    public void testConstructorFraise() {
        FruitSimple fraise1 = ff.createFruitSimple("Fraise");
        assertEquals("Fraise", fraise1.getNom());
        assertEquals(1.0, fraise1.getPrix(), 0.001);
        assertEquals("Europe", fraise1.getOrigine());
        assertEquals(true, fraise1.isSeedless());
        FruitSimple fraise2 = ff.createFruitSimple("Fraise", 0.6, "France");
        assertEquals("Fraise", fraise2.getNom());
        assertEquals(0.6, fraise2.getPrix(), 0.001);
        assertEquals("France", fraise2.getOrigine());
        assertEquals(true, fraise2.isSeedless());
    }

    @Test
    public void testConstructorKiwi() {
        FruitSimple kiwi1 = ff.createFruitSimple("Kiwi");
        assertEquals("Kiwi", kiwi1.getNom());
        assertEquals(2.99, kiwi1.getPrix(), 0.001);
        assertEquals("Chine", kiwi1.getOrigine());
        assertEquals(true, kiwi1.isSeedless());
        FruitSimple kiwi2 = ff.createFruitSimple("Kiwi", 0.6, "France");
        assertEquals("Kiwi", kiwi2.getNom());
        assertEquals(0.6, kiwi2.getPrix(), 0.001);
        assertEquals("France", kiwi2.getOrigine());
        assertEquals(true, kiwi2.isSeedless());
    }

    @Test
    public void testConstructorOrange() {
        FruitSimple orange1 = ff.createFruitSimple("Orange");
        assertEquals("Orange", orange1.getNom());
        assertEquals(2.0, orange1.getPrix(), 0.001);
        assertEquals("France", orange1.getOrigine());
        assertEquals(false, orange1.isSeedless());
        FruitSimple orange2 = ff.createFruitSimple("Orange", 0.6, "France");
        assertEquals("Orange", orange2.getNom());
        assertEquals(0.6, orange2.getPrix(), 0.001);
        assertEquals("France", orange2.getOrigine());
        assertEquals(false, orange2.isSeedless());
    }

    @Test
    public void testConstructorPapaye() {
        FruitSimple papaye1 = ff.createFruitSimple("Papaye");
        assertEquals("Papaye", papaye1.getNom());
        assertEquals(2.99, papaye1.getPrix(), 0.001);
        assertEquals("Mexique", papaye1.getOrigine());
        assertEquals(true, papaye1.isSeedless());
        FruitSimple papaye2 = ff.createFruitSimple("Papaye", 0.6, "France");
        assertEquals("Papaye", papaye2.getNom());
        assertEquals(0.6, papaye2.getPrix(), 0.001);
        assertEquals("France", papaye2.getOrigine());
        assertEquals(true, papaye2.isSeedless());
    }

    @Test
    public void testConstructorPoire() {
        FruitSimple poire1 = ff.createFruitSimple("Poire");
        assertEquals("Poire", poire1.getNom());
        assertEquals(0.8, poire1.getPrix(), 0.001);
        assertEquals("Espagne", poire1.getOrigine());
        assertEquals(false, poire1.isSeedless());
        FruitSimple poire2 = ff.createFruitSimple("Poire", 0.6, "France");
        assertEquals("Poire", poire2.getNom());
        assertEquals(0.6, poire2.getPrix(), 0.001);
        assertEquals("France", poire2.getOrigine());
        assertEquals(false, poire2.isSeedless());
    }

    @Test
    public void testConstructorPomme() {
        FruitSimple pomme1 = ff.createFruitSimple("Pomme");
        assertEquals("Pomme", pomme1.getNom());
        assertEquals(1.35, pomme1.getPrix(), 0.001);
        assertEquals("Asie", pomme1.getOrigine());
        assertEquals(true, pomme1.isSeedless());
        FruitSimple pomme2 = ff.createFruitSimple("Pomme", 0.6, "France");
        assertEquals("Pomme", pomme2.getNom());
        assertEquals(0.6, pomme2.getPrix(), 0.001);
        assertEquals("France", pomme2.getOrigine());
        assertEquals(true, pomme2.isSeedless());
    }

    @Test
    public void testConstructorTomate() {
        FruitSimple tomate1 = ff.createFruitSimple("Tomate");
        assertEquals("Tomate", tomate1.getNom());
        assertEquals(1.49, tomate1.getPrix(), 0.001);
        assertEquals("Amérique du Sud", tomate1.getOrigine());
        assertEquals(true, tomate1.isSeedless());
        FruitSimple tomate2 = ff.createFruitSimple("Tomate", 0.6, "France");
        assertEquals("Tomate", tomate2.getNom());
        assertEquals(0.6, tomate2.getPrix(), 0.001);
        assertEquals("France", tomate2.getOrigine());
        assertEquals(true, tomate2.isSeedless());
    }

    @Test
    public void testConstructorLitchi() {
        FruitSimple litchi1 = ff.createFruitSimple("Litchi");
        assertEquals("Litchi", litchi1.getNom());
        assertEquals(1.49, litchi1.getPrix(), 0.001);
        assertEquals("Chine", litchi1.getOrigine());
        assertEquals(true, litchi1.isSeedless());
        FruitSimple litchi2 = ff.createFruitSimple("Litchi", 0.6, "France");
        assertEquals("Litchi", litchi2.getNom());
        assertEquals(0.6, litchi2.getPrix(), 0.001);
        assertEquals("France", litchi2.getOrigine());
        assertEquals(true, litchi2.isSeedless());
    }

    @Test
    public void testGetSetPrix() {
        FruitSimple cerise = ff.createFruitSimple("Cerise");
        cerise.setPrix(1.99);
        assertEquals(1.99, cerise.getPrix(), 0.001);
    }

    @Test
    public void testGetSetOrigine() {
        FruitSimple cerise = ff.createFruitSimple("Cerise");
        cerise.setOrigine("Papouasie-Nouvelle-Guinée");
        assertEquals("Papouasie-Nouvelle-Guinée", cerise.getOrigine());
    }

    @Test
    public void testGetSetSeedless() {
        FruitSimple cerise = ff.createFruitSimple("Cerise");
        cerise.setSeedless(false);
        assertFalse(cerise.isSeedless());
    }

    @Test
    public void testToString() {
        FruitSimple cerise = ff.createFruitSimple("Cerise");
        assertEquals("Cerise de Caucase a 6.5 euros.", cerise.toString());
    }

    @Test
    public void testEquals() {
        FruitSimple cerise1 = ff.createFruitSimple("Cerise");
        FruitSimple cerise2 = ff.createFruitSimple("Cerise");
        FruitSimple banane = ff.createFruitSimple("Banane");
        assertTrue(cerise1.equals(cerise2));
        assertFalse(cerise2.equals(banane));
    }

}
