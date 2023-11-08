package fr.ufrsciencestech.panier.view;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import fr.ufrsciencestech.panier.controler.Controleur;
import java.awt.event.ActionEvent;

public class VuePanierV2Test {
    private VuePanierV2 vue;
    private Controleur controleur;

    @Before
    public void setUp() {
        vue = new VuePanierV2(5); 
        controleur = mock(Controleur.class);
        vue.addControleur(controleur);
    }

    @Test
    public void testAddButtonActionPerformed() {

        vue.getAddButton().doClick(); 

        verify(controleur).actionPerformed(any(ActionEvent.class));
    }

    @Test
    public void testDelButtonActionPerformed() {

        vue.getDelButton().doClick(); 

        verify(controleur).actionPerformed(any(ActionEvent.class));
    }

    @Test
    public void testBtnMacedoineActionPerformed() {

        vue.getBtnMacedoine().doClick(); 

        verify(controleur).actionPerformed(any(ActionEvent.class));
    }

}