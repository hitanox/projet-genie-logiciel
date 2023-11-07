import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import fr.ufrsciencestech.panier.controler.Controleur;
import fr.ufrsciencestech.panier.model.fruits.fruitsimple.*;
import fr.ufrsciencestech.panier.model.fruits.fruitspecifique.*;
import fr.ufrsciencestech.panier.model.fruits.*;
import fr.ufrsciencestech.panier.model.panier.*;
import fr.ufrsciencestech.panier.view.*;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;

import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;

public class ControleurTest {

    private Controleur controleur;
    private Panier panier;
    private VuePanierV2 mainView;
    private VueMacedoine secondaryView; 
    private VueConsole vueC;
    private FruitFactory facto;
    ArrayList<String> fruitsClasses = new ArrayList<>();

    @Before
    public void setUp() {
        controleur = new Controleur();
        panier = Mockito.mock(Panier.class);
        vueC = new VueConsole();

        mainView = Mockito.mock(VuePanierV2.class);
        mainView.setVueConsole(vueC);

        secondaryView = Mockito.mock(VueMacedoine.class);

        controleur.setPanier(panier);
        controleur.setMainVue(mainView);
        controleur.setVueConsole(vueC);
  
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
    public void action_Add() throws PanierPleinException{
        when(mainView.isActiv()).thenReturn(true);
        when(mainView.getFieldName()).thenReturn("Orange");
        when(mainView.getFieldQuantity()).thenReturn(2);
        when(mainView.getFieldPrice()).thenReturn("2.0");
        when(mainView.getFieldOrigin()).thenReturn("France");
        when(mainView.isJuice()).thenReturn(false);

        controleur.action("add");

        
        FruitSimple fruit = facto.createFruitSimple("Orange", 2.0, "France");

        verify(panier).ajout(fruit, 2); 
    }

    @Test
    public void action_AddJuice() throws PanierPleinException{
        when(mainView.isActiv()).thenReturn(true);
        when(mainView.getFieldName()).thenReturn("Orange");
        when(mainView.getFieldQuantity()).thenReturn(1);
        when(mainView.getFieldPrice()).thenReturn("2.0");
        when(mainView.getFieldOrigin()).thenReturn("France");
        when(mainView.isJuice()).thenReturn(true);

        controleur.action("add");

        
        FruitSimple fruit = facto.createFruitSimple("Orange", 2.0, "France");
        Jus jus = facto.createJus(fruit);

        verify(panier).ajout(jus, 1);  
    }

    @Test
    public void action_del() throws PanierVideException{
        when(mainView.isActiv()).thenReturn(true);

        Fruit fruitRetrait = Mockito.mock(Fruit.class); 
        when(panier.retrait()).thenReturn(fruitRetrait);

        controleur.action("del");

        verify(panier).retrait();  
    }

    
    @Test
    public void action_comboName(){
        when(mainView.isActiv()).thenReturn(true);

        when(mainView.getFieldName()).thenReturn("Orange");

        controleur.action("comboName");

        verify(mainView).getFieldName();
    }

    @Test
    public void action_Default() throws PanierPleinException, PanierVideException {
        when(mainView.isActiv()).thenReturn(true);
        when(mainView.getLineToRemove()).thenReturn(0);
        when(mainView.getNameAt(0)).thenReturn("Orange");
        when(mainView.getOriginAt(0)).thenReturn("France");
        when(mainView.getPriceAt(0)).thenReturn(2.0);

        Fruit fruitRetrait = Mockito.mock(Fruit.class); // Mock de la classe Fruit pour le retrait

        when(panier.retrait("Orange", "France", 2.0)).thenReturn(fruitRetrait);

        controleur.action("other");

        verify(panier).retrait("Orange", "France", 2.0);
    }

    @Test
    public void action_btnMacedoine() throws ClassNotFoundException, InstantiationException, IllegalAccessException{

        when(mainView.isActiv()).thenReturn(true);

        controleur.action("btnMacedoine");

        verify(mainView).closeView();

    }

}