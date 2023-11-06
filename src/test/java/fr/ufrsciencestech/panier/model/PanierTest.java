package fr.ufrsciencestech.panier.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import fr.ufrsciencestech.panier.model.fruits.FruitFactory;
import fr.ufrsciencestech.panier.model.fruits.fruitsimple.Cerise;
import fr.ufrsciencestech.panier.model.fruits.Fruit;
import fr.ufrsciencestech.panier.model.fruits.fruitsimple.Banane;
import java.util.ArrayList;

import fr.ufrsciencestech.panier.model.fruits.fruitsimple.FruitSimple;
import fr.ufrsciencestech.panier.model.panier.Panier;
import fr.ufrsciencestech.panier.model.panier.PanierFactory;
import fr.ufrsciencestech.panier.model.panier.PanierPleinException;
import fr.ufrsciencestech.panier.model.panier.PanierVideException;
import org.junit.Before;
import org.junit.Test;

public class PanierTest {

  PanierFactory pf = new PanierFactory();
  Panier panierTest = pf.createPanier(10);
  FruitFactory ff = new FruitFactory();
  FruitSimple orange = ff.createFruitSimple("Orange");
  FruitSimple poire = ff.createFruitSimple("Poire");

  @Before
  public void setUp() throws Exception {
    panierTest.ajout(orange, 1);
    panierTest.ajout(poire, 1);
  }

  @Test
  public void testToString() {
    String text =
            "Panier de 2 fruits : 2.8\n" +
            "Orange de France a 2.0 euros.\n" +
            "Poire de Espagne a 0.8 euros.\n";
    assertEquals(text, this.panierTest.toString());
  }

  @Test
  public void testGetFruits() {
    ArrayList<Fruit> fruits = new ArrayList<>();
    fruits.add(orange);
    fruits.add(poire);
    assertEquals(panierTest.getFruits(), fruits);
  }

  @Test
  public void testGetFirstFruit() {
    ArrayList<Fruit> fruits = new ArrayList<>();
    fruits.add(orange);
    fruits.add(poire);
    assertEquals(panierTest.getFruit(0), fruits.get(0));
  }

  @Test
  public void testSetFruits() {
    ArrayList<Fruit> fruits = new ArrayList<>();
    fruits.add(orange);
    fruits.add(poire);

    Panier pTest = pf.createPanier(10);

    pTest.setFruits(fruits);
    assertEquals(this.panierTest, pTest);
  }

  @Test
  public void testSetFruit() {
    ArrayList<Fruit> fruits = new ArrayList<>();
    fruits.add(orange);
    fruits.add(poire);

    this.panierTest.setFruit(0, orange);
    this.panierTest.setFruit(1, poire);

    assertEquals(this.panierTest.getFruits(), fruits);
  }

  @Test
  public void testGetTaillePanier() {
    assertEquals(this.panierTest.getTaillePanier(), this.panierTest.getFruits().size());
  }

  @Test
  public void testGetContenanceMax() {
    assertEquals(this.panierTest.getContenanceMax(), 10);
  }

  @Test
  public void testEstVide() {
    Panier pTest = pf.createPanier(10);
    assertTrue(pTest.estVide());
  }

  @Test
  public void testEstPlein() throws PanierPleinException {
    Panier pTest = pf.createPanier(2);

    pTest.ajout(orange, 1);
    pTest.ajout(orange, 1);

    assertTrue(pTest.estPlein());
  }

  @Test
  public void testAjout() throws PanierPleinException {
    FruitSimple cerise = ff.createFruitSimple("Cerise");
    ArrayList<Fruit> fruits = new ArrayList<>();
    fruits.add(orange);
    fruits.add(poire);
    fruits.add(cerise);

    this.panierTest.ajout(cerise, 1);

    assertEquals(this.panierTest.getFruits(), fruits);
  }

  @Test
  public void testRetrait() throws PanierVideException {
    ArrayList<Fruit> fruits = new ArrayList<>();
    fruits.add(orange);
    fruits.add(poire);

    this.panierTest.retrait();
    fruits.remove(1);

    assertEquals(this.panierTest.getFruits(), fruits);
  }

  @Test
  public void testGetPrix() {
    assertEquals(2.8, this.panierTest.getPrix(), 0.0f);
  }

  @Test
  public void testBoycotteOrigine() {
    ArrayList<Fruit> fruits = new ArrayList<Fruit>();
    fruits.add(orange);

    this.panierTest.boycotteOrigine("Espagne");
    assertEquals(this.panierTest.getFruits(), fruits);
  }

  @Test
  public void testEquals() throws PanierPleinException {
    Panier pTest = new Panier(10);

    pTest.ajout(orange, 1);
    pTest.ajout(poire, 1);

    assertTrue(this.panierTest.equals(pTest));
    FruitSimple cerise = ff.createFruitSimple("Cerise");

    pTest.ajout(cerise, 1);
    assertFalse(this.panierTest.equals(pTest));
  }

  @Test
  public void testAjoutTriggerPanierPleinException(){
    Panier pTest = pf.createPanier(1);
    try {
      pTest.ajout(orange, 1);
      pTest.ajout(poire, 1);
    } catch (PanierPleinException e) {
      assertEquals("Ajout impossible car le panier est plein !", e.getMessage());
    }
  }

  @Test
  public void testAjoutTriggerPanierVideException(){
    try {
      this.panierTest.retrait();
      this.panierTest.retrait();
      this.panierTest.retrait();
    } catch (PanierVideException e) {
      assertEquals("Suppression impossible car le panier est vide !", e.getMessage());
    }
  }

  @Test
  public void testPanierTriggerException(){
    try {
      new Panier(-1);
    } catch (IllegalArgumentException e) {
      assertEquals("La contenance maximale doit être supérieure à 0", e.getMessage());
    }

  }
}
