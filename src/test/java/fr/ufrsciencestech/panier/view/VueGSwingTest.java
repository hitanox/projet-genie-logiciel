package fr.ufrsciencestech.panier.view;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import fr.ufrsciencestech.panier.controler.Controleur;
import fr.ufrsciencestech.panier.model.panier.Panier;
import fr.ufrsciencestech.panier.view.VueGSwing;


public class VueGSwingTest {

    private VueGSwing vue;
    
    @Before
    public void setUp() {
        vue = new VueGSwing();
        Controleur controleur = new Controleur();
        Panier panier = new Panier(5);
        
        controleur.setPanier(panier);                 
        panier.addObserver(vue);        
        vue.addControleur(controleur);
    }

    @Test
    public void testInitialAffichage() {
        assertEquals("0", vue.getAffiche().getText());
    }

    @Test
    public void testIncrement() {
        vue.getInc().doClick();
        assertEquals("1", vue.getAffiche().getText());
    }

    @Test
    public void testDecrement() {
        vue.getDec().doClick();
        assertEquals("0", vue.getAffiche().getText());
    }

    // @Test
    // public void testIntegrationAjoutProduit() throws PanierPleinException {
    //     Panier panier = Mockito.mock(Panier.class);
    //     panier.addObserver(vue);        

    //     Controleur controleur = Mockito.mock(Controleur.class);
    //     vue.addControleur(controleur);

    //     Mockito.when(controleur.getPanier()).thenReturn(panier);

    //     vue.getInc().doClick();

    //     Mockito.verify(panier).ajout(new Orange());
    // }

    // @Test
    // public void testIntegrationSuppressionProduit() throws PanierVideException {
    //     Panier panier = Mockito.mock(Panier.class);
           
    //     Controleur controleur = Mockito.mock(Controleur.class);

    //     Mockito.when(controleur.getPanier()).thenReturn(panier);
    //     Mockito.when(panier.getTaillePanier()).thenReturn(1); // Panier non vide

    //     panier.addObserver(vue); 
    //     vue.addControleur(controleur);
    //     vue.getDec().doClick();

    //     Mockito.verify(panier).retrait();
    // }

    // @Test(expected = PanierPleinException.class)
    // public void testAcceptationAjoutOrangesPanierPlein() throws PanierPleinException {
    //     Panier panier = Mockito.mock(Panier.class);
    //     panier.addObserver(vue);        

    //     Mockito.when(panier.estPlein()).thenReturn(true);

    //     Controleur controleur = new Controleur();
    //     controleur.setPanier(panier);
    //     vue.addControleur(controleur);
    
    //     vue.getInc().doClick();
    // }
 
    // @Test(expected = PanierVideException.class)
    // public void testAcceptationSuppressionOrangesPanierVide() throws PanierVideException {
    //     Panier panier = Mockito.mock(Panier.class);
    //     panier.addObserver(vue);        

    //     Mockito.when(panier.estVide()).thenReturn(true);
 
    //     Controleur controleur = new Controleur();
    //     controleur.setPanier(panier);
    //     vue.addControleur(controleur);
 
    //     vue.getDec().doClick();
    // }
 }