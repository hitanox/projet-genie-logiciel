package fr.ufrsciencestech.panier.controler;


import fr.ufrsciencestech.panier.model.fruits.Fruit;
import fr.ufrsciencestech.panier.model.fruits.FruitFactory;
import fr.ufrsciencestech.panier.model.fruits.FruitHelper;
import fr.ufrsciencestech.panier.model.fruits.fruitsimple.FruitSimple;
import fr.ufrsciencestech.panier.model.fruits.fruitspecifique.Jus;
import fr.ufrsciencestech.panier.model.panier.Panier;
import fr.ufrsciencestech.panier.model.panier.PanierPleinException;
import fr.ufrsciencestech.panier.model.panier.PanierVideException;
import fr.ufrsciencestech.panier.view.VuePanierV2;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;

import fr.ufrsciencestech.panier.model.fruits.fruitspecifique.Macedoine;
import fr.ufrsciencestech.panier.view.VueConsole;
import fr.ufrsciencestech.panier.view.VueG;
import fr.ufrsciencestech.panier.view.VueMacedoine;

public class Controleur implements ActionListener {
    private Panier p;
    private VuePanierV2 mainView;
    private VueMacedoine secondaryView;
    private ArrayList<String> fruitsClasses;
    private VueConsole consoleView;
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String source = ((Component) e.getSource()).getName();

        action(source);
        
    }

    public void action(String source){
        FruitFactory facto = new FruitFactory();
        
        try {
            if (mainView.isActiv()) {
                switch (source) {
                    case "add": {
                        String fruitName = mainView.getFieldName();
                        Integer quantity = mainView.getFieldQuantity();
                        double price = Double.parseDouble(mainView.getFieldPrice());
                        String origin = mainView.getFieldOrigin();

                        FruitSimple fruit = facto.createFruitSimple(fruitName, price, origin);

                        if (mainView.isJuice()) {
                            Jus jus = facto.createJus(fruit);
                            this.p.ajout(jus, quantity);
                            consoleView.affiche("Ajout de " + jus.toString());
                        } else {
                            this.p.ajout(fruit, quantity);
                            consoleView.affiche("Ajout de " + fruit.toString());
                        }
                        break;
                    }
                    case "btnMacedoine":
                        VueMacedoine vm = new VueMacedoine();
                        vm.addControleur(this);
                        try {
                            vm.setFruitsChoices(fruitsClasses);
                            updateForm(vm);
                        } catch (Exception exc) {
                            consoleView.affiche(exc.toString());
                        }
                        mainView.closeView();
                        vm.openView();
                        this.secondaryView = vm;
                        break;
                    case "del":
                        Fruit fruit = this.p.retrait();
                        consoleView.affiche("Retrait d'un élément de type " + fruit.toString());
                        break;
                    case "comboName":
                        updateForm(mainView);
                        break;
                    default: {
                        int position = mainView.getLineToRemove();
                        String name = mainView.getNameAt(position);
                        String origin = mainView.getOriginAt(position);
                        double price = mainView.getPriceAt(position);
                        Fruit fruit2 = this.p.retrait(name, origin, price);
                        consoleView.affiche("Retrait des éléments de type " + fruit2.toString());
                        break;
                    }
                }
            }
            if (secondaryView != null && secondaryView.getName().equals("Macedoine") && secondaryView.isActiv()) {
                switch (source) {
                    case "addMacedoine":
                        secondaryView.closeView();
                        mainView.openView();
                        Macedoine macedoine = facto.createMacedoine((this.secondaryView).getMacedoine());
                        this.p.ajout(macedoine, 1);
                        consoleView.affiche("Ajout de " + macedoine.toString());
                        break;
                    case "add":
                        String fruitName = (this.secondaryView).getFieldName();
                        FruitSimple fruit = facto.createFruitSimple(fruitName);
                        (this.secondaryView).addFruit(fruit);
                        break;
                    case "comboName":
                        updateForm(secondaryView);
                        break;
                }

            }
        } catch (PanierVideException | PanierPleinException ex) {
            consoleView.affiche(ex.toString());
        }
    }

    public void setPanier(Panier p) {
        this.p = p;
    }

    public Panier getPanier() {
        return this.p;
    }

    public void setMainVue(VuePanierV2 mainView) {
        this.mainView = mainView;
    }

    public VueG getMainVue() {
        return this.mainView;
    }

    public void setSecondaryVue(VueMacedoine secondaryView) {
        this.secondaryView = secondaryView;
    }

    public VueG getSecondaryVue() {
        return this.secondaryView;
    }

    public void setVueConsole(VueConsole vueConsole){
        this.consoleView = vueConsole;
    }

    public VueConsole getVueConsole() {
        return this.consoleView;
    }

    public void setFruitsClasses(ArrayList<String> fruitsClasses) {
        this.fruitsClasses = fruitsClasses;
    }

    public void updateForm(VueG view) {
        HashMap<String, String> values = FruitHelper.getDefaultValuesFor(view.getFieldName());
        view.updateForm(values.get("origin"), values.get("price"));
    }
        
}
