package fr.ufrsciencestech.panier.model.panier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import fr.ufrsciencestech.panier.model.fruits.fruitsimple.Cerise;
import fr.ufrsciencestech.panier.model.fruits.Fruit;
import fr.ufrsciencestech.panier.model.fruits.fruitsimple.Banane;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class PanierTest {

  Panier panierTest = new Panier(10);
  Cerise cerise1 = new Cerise(0.5, "France");
  Banane banane1 = new Banane(1.0, "Espagne");

  @Before
  public void setUp() throws Exception {
    // Instanciation d'un nouveau panier en utilisant Reflection
    panierTest = new Panier(10);
    panierTest.ajout(cerise1);
    panierTest.ajout(banane1);
  }

  @Test
  public void testToString() {
    String text =
      "Cerise de France a 0.5 euros.\nBanane de Espagne a 1.0 euros.\n";
    assertEquals(text, this.panierTest.toString());
  }

  @Test
  public void testGetFruits() {
    ArrayList<Fruit> fruits = new ArrayList<Fruit>();
    fruits.add(cerise1);
    fruits.add(banane1);
    assertEquals(panierTest.getFruits(), fruits);
  }

  @Test
  public void testGetFruit() {
    ArrayList<Fruit> fruits = new ArrayList<Fruit>();
    fruits.add(cerise1);
    fruits.add(banane1);
    assertEquals(panierTest.getFruit(0), fruits.get(0));
  }

  @Test
  public void testSetFruits() {
    ArrayList<Fruit> fruits = new ArrayList<Fruit>();
    fruits.add(cerise1);
    fruits.add(banane1);

    Panier pTest = new Panier(10);

    pTest.setFruits(fruits);
    assertEquals(this.panierTest, pTest);
  }

  @Test
  public void testSetFruit() {
    ArrayList<Fruit> fruits = new ArrayList<Fruit>();
    fruits.add(banane1);
    fruits.add(cerise1);

    this.panierTest.setFruit(0, banane1);
    this.panierTest.setFruit(1, cerise1);

    assertEquals(this.panierTest.getFruits(), fruits);
  }

  @Test
  public void testGetTaillePanier() {
    assertEquals(
      this.panierTest.getTaillePanier(),
      this.panierTest.getFruits().size()
    );
  }

  @Test
  public void testGetContenanceMax() {
    assertEquals(this.panierTest.getContenanceMax(), 10);
  }

  @Test
  public void testEstVide() {
    Panier pTest = new Panier(10);
    assertTrue(pTest.estVide());
  }

  @Test
  public void testEstPlein() throws PanierPleinException {
    Panier pTest = new Panier(2);

    pTest.ajout(new Cerise());
    pTest.ajout(new Cerise());

    assertTrue(pTest.estPlein());
  }

  @Test
  public void testAjout() throws PanierPleinException {
    Cerise cerise2 = new Cerise();
    ArrayList<Fruit> fruits = new ArrayList<Fruit>();
    fruits.add(cerise1);
    fruits.add(banane1);
    fruits.add(cerise2);

    this.panierTest.ajout(cerise2);

    assertEquals(this.panierTest.getFruits(), fruits);
  }

  @Test
  public void testRetrait() throws PanierVideException {
    ArrayList<Fruit> fruits = new ArrayList<Fruit>();
    fruits.add(cerise1);
    fruits.add(banane1);

    this.panierTest.retrait();
    fruits.remove(1);

    assertEquals(this.panierTest.getFruits(), fruits);
  }

  @Test
  public void testGetPrix() {
    assertEquals(1.5, this.panierTest.getPrix(), 0.0f);
  }

  @Test
  public void testBoycotteOrigine() {
    ArrayList<Fruit> fruits = new ArrayList<Fruit>();
    fruits.add(cerise1);

    this.panierTest.boycotteOrigine("Espagne");
    assertEquals(this.panierTest.getFruits(), fruits);
  }

  @Test
  public void testEquals() throws PanierPleinException {
    Panier pTest = new Panier(10);

    pTest.ajout(cerise1);
    pTest.ajout(banane1);

    assertTrue(this.panierTest.equals(pTest));

    pTest.ajout(banane1);
    assertFalse(this.panierTest.equals(pTest));
  }

  @Test(expected = PanierPleinException.class)
  public void testAjoutTriggerPanierPleinException()
    throws PanierPleinException {
    Panier pTest = new Panier(1);
    pTest.ajout(cerise1);
    pTest.ajout(banane1);
  }

  @Test(expected = PanierVideException.class)
  public void testAjoutTriggerPanierVideException() throws PanierVideException {
    this.panierTest.retrait();
    this.panierTest.retrait();
    this.panierTest.retrait();
  }

  @Test(expected = IllegalArgumentException.class)
  public void testPanierTriggerException() throws IllegalArgumentException {
    new Panier(0);
  }
}
