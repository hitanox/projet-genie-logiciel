package fr.ufrsciencestech.panier.controler;


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
import fr.ufrsciencestech.panier.view.VueG;
import fr.ufrsciencestech.panier.view.VueMacedoine;

public class Controleur implements ActionListener {
    private Panier p;
    private VuePanierV2 mainView;
    private VueMacedoine secondaryView;
    private ArrayList<String> fruitsClasses;

    @Override
    public void actionPerformed(ActionEvent e) {
        FruitFactory facto = new FruitFactory();
        String source = ((Component) e.getSource()).getName();

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
                        } else {
                            this.p.ajout(fruit, quantity);
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
                            System.out.println(exc.getMessage());
                        }
                        mainView.closeView();
                        vm.openView();
                        this.secondaryView = vm;
                        break;
                    case "del":
                        this.p.retrait();
                        break;
                    case "comboName":
                        updateForm(mainView);
                        break;
                    default: {
                        int position = mainView.getLineToRemove();
                        String name = mainView.getNameAt(position);
                        String origin = mainView.getOriginAt(position);
                        double price = mainView.getPriceAt(position);
                        this.p.retrait(name, origin, price);
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
            System.out.println(ex.getMessage());
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

    public void setFruitsClasses(ArrayList<String> fruitsClasses) {
        this.fruitsClasses = fruitsClasses;
    }

    public void updateForm(VueG view) {
        HashMap<String, String> values = FruitHelper.getDefaultValuesFor(view.getFieldName());
        view.updateForm(values.get("origin"), values.get("price"));
    }
}
