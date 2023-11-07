import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import java.awt.event.ActionEvent;
import fr.ufrsciencestech.panier.model.panier.*;
import fr.ufrsciencestech.panier.controler.Controleur;
import fr.ufrsciencestech.panier.view.*;

public class VueMacedoineTest {
    private VueMacedoine vue;
    private Controleur controleur;

    @Before
    public void setUp() {
        vue = new VueMacedoine();
        controleur = mock(Controleur.class);
        vue.addControleur(controleur);
    }

    @Test
    public void testAddButtonActionPerformed() {

        vue.getAddButton().doClick(); 

        verify(controleur).actionPerformed(any(ActionEvent.class));
    }

    @Test
    public void testAddMacedoineButtonActionPerformed() {

        vue.getAddMacedoineButton().doClick(); 

        verify(controleur).actionPerformed(any(ActionEvent.class));
    }

}