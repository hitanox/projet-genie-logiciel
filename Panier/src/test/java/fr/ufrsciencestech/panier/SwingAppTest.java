package fr.ufrsciencestech.panier;

import fr.ufrsciencestech.panier.view.VueGraphique;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SwingAppTest {
    private FrameFixture window;

    @Before
    public void setUp() {
        window = new FrameFixture(new VueGraphique());
        window.show();
    }

    @Test
    public void testApp() {
        window.textBox().requireText("Panier vide");
        assertEquals("Panier vide", window.textBox("Affichage").text());
    }

    @After
    public void tearDown() {
        window.cleanUp();
    }
}
