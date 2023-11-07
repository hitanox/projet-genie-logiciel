import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import fr.ufrsciencestech.panier.controler.Controleur;
import fr.ufrsciencestech.panier.model.fruits.fruitsimple.*;
import fr.ufrsciencestech.panier.model.fruits.*;
import fr.ufrsciencestech.panier.model.panier.*;
import fr.ufrsciencestech.panier.view.*;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import static org.mockito.Mockito.*;

public class VuePanierV2Test {

    private Controleur controleur;
    private Panier panier;
    private VuePanierV2 mainView;
    private VueConsole vueC;
    private FruitFactory facto;

    @Before
    public void setUp() {
        // Initialiser le contrôleur, le panier et la vueConsole si nécessaire
        controleur = new Controleur();
        panier = Mockito.mock(Panier.class);
        vueC = Mockito.mock(VueConsole.class);

        // Initialiser la VuePanierV2 (mainView)
        mainView = Mockito.mock(VuePanierV2.class);
        mainView.setVueConsole(vueC);

        // Configurer le contrôleur avec le panier, la vue principale et la vue console
        controleur.setPanier(panier);
        controleur.setMainVue(mainView);
        controleur.setVueConsole(vueC);

        // Configurer les classes de fruits (vous devrez peut-être remplacer cette liste par vos propres classes de fruits)
        ArrayList<String> fruitsClasses = new ArrayList<>();
        fruitsClasses.add(Ananas.class.getName());
        fruitsClasses.add(Banane.class.getName());
        fruitsClasses.add(Caroube.class.getName());
        fruitsClasses.add(Cerise.class.getName());
        fruitsClasses.add(Fraise.class.getName());
        fruitsClasses.add(Kiwi.class.getName());
        fruitsClasses.add(Litchi.class.getName());
        fruitsClasses.add(Orange.class.getName());
        fruitsClasses.add(Papaye.class.getName());
        fruitsClasses.add(Poire.class.getName());
        fruitsClasses.add(Pomme.class.getName());
        fruitsClasses.add(Tomate.class.getName());

        controleur.setFruitsClasses(fruitsClasses);
        facto = new FruitFactory();
    }

    @Test
    public void testActionPerformed_AddButton() throws PanierPleinException{
        // Préparer le mock pour simuler le comportement de la vue
        when(mainView.isActiv()).thenReturn(true);
        when(mainView.getFieldName()).thenReturn("Orange");
        when(mainView.getFieldQuantity()).thenReturn(2);
        when(mainView.getFieldPrice()).thenReturn("2.0");
        when(mainView.getFieldOrigin()).thenReturn("France");
        when(mainView.isJuice()).thenReturn(false);

        controleur.action("add");

        
        FruitSimple fruit = facto.createFruitSimple("Orange", 2.0, "France");

        verify(panier).ajout(fruit, 2); 
        verify(vueC).affiche("Ajout de " + fruit.toString()); 
    }


}