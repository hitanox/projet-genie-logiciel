package fr.ufrsciencestech.panier.view;

import org.assertj.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SwingAppTest {
    private FrameFixture window;

    @Before
    public void setUp() {
        window = new FrameFixture(new VuePanierV2(10));
        window.show();
    }

    @Test
    public void testApp() {
        //TODO: Not implemented yet
    }

    @After
    public void tearDown() {
        window.cleanUp();
    }
}
