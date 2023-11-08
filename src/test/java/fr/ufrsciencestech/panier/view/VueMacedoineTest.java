package fr.ufrsciencestech.panier.view;

import static junit.framework.TestCase.*;
import static org.mockito.Mockito.*;

import fr.ufrsciencestech.panier.model.fruits.fruitsimple.FruitSimple;
import fr.ufrsciencestech.panier.model.fruits.fruitspecifique.Macedoine;
import org.junit.Before;
import org.junit.Test;
import fr.ufrsciencestech.panier.controler.Controleur;
import org.mockito.Mockito;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class VueMacedoineTest {
    private VueMacedoine vueMacedoine;
    private Controleur controleur;
    private DefaultTableModel mockTableModel;
    private Macedoine macedoine;
    private DefaultComboBoxModel mockComboBoxModel;

    @Before
    public void setUp() throws NoSuchFieldException, IllegalAccessException {
        vueMacedoine = new VueMacedoine();
        controleur = Mockito.mock(Controleur.class);
        vueMacedoine.addControleur(controleur);

        macedoine = Mockito.mock(Macedoine.class);

        Field modelField = VueMacedoine.class.getDeclaredField("model");
        modelField.setAccessible(true);
        mockTableModel = Mockito.mock(DefaultTableModel.class);
        modelField.set(vueMacedoine, mockTableModel);

        mockComboBoxModel = Mockito.mock(DefaultComboBoxModel.class);
    }

    @Test
    public void testUpdateTab() {
        when(mockTableModel.getRowCount()).thenReturn(0);

        Object[][] testData = {{"Pomme", 1.0, "France", 1}, {"Orange", 2.0, "Espagne", 1}};
        vueMacedoine.updateTab(testData);

        verify(mockTableModel, times(testData.length)).addRow(Mockito.any(Object[].class));
    }

    @Test
    public void testOpenViewAndCloseView() throws NoSuchFieldException, IllegalAccessException {
        Field addField = VueMacedoine.class.getDeclaredField("add");
        addField.setAccessible(true);
        JButton add = (JButton) addField.get(vueMacedoine);

        Field cancelField = VueMacedoine.class.getDeclaredField("cancel");
        cancelField.setAccessible(true);
        JButton cancel = (JButton) cancelField.get(vueMacedoine);

        assertFalse(vueMacedoine.isActiv());

        vueMacedoine.openView();
        assertTrue(vueMacedoine.isActiv());
        assertTrue(add.isEnabled());
        assertTrue(cancel.isEnabled());

        vueMacedoine.closeView();
        assertFalse(vueMacedoine.isActiv());
    }

    @Test
    public void testAddMacedoineButtonActionPerformed() {
        vueMacedoine.getAddMacedoineButton().doClick();
        verify(controleur).actionPerformed(Mockito.any(ActionEvent.class));
    }

    @Test
    public void testAddButtonActionPerformed() {
        vueMacedoine.getAddButton().doClick();
        verify(controleur).actionPerformed(Mockito.any(ActionEvent.class));
    }

    @Test
    public void testAddFruit() {
        FruitSimple fruit = Mockito.mock(FruitSimple.class);
        when(fruit.getNom()).thenReturn("Pomme");
        when(fruit.getPrix()).thenReturn(1.0);
        when(fruit.getOrigine()).thenReturn("France");

        vueMacedoine.addFruit(fruit, 1);
        verify(mockTableModel).addRow(Mockito.any(Object[].class));
    }

    @Test
    public void testGetFieldQuantity() throws NoSuchFieldException, IllegalAccessException {
        JTextField fieldQuantity = Mockito.mock(JTextField.class);
        when(fieldQuantity.getText()).thenReturn("1");

        int expected = 1;
        int result = vueMacedoine.getFieldQuantity();
        assertEquals(expected, result);
    }

    @Test
    public void testGetFieldName(){
        String expected = "Item 1";
        String result = vueMacedoine.getFieldName();
        assertEquals(expected, result);
    }
}