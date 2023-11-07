import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import fr.ufrsciencestech.panier.model.panier.*;
import fr.ufrsciencestech.panier.controler.Controleur;
import fr.ufrsciencestech.panier.view.*;

public class VuePanierV2Test {
    private VuePanierV2 vue;
    private Controleur controleur;

    @Before
    public void setUp() {
        vue = new VuePanierV2(5); // On crée une instance avec une taille maximale de 5
        controleur = mock(Controleur.class);
        vue.addControleur(controleur);
    }

}