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
    public void actionPerformed(ActionEvent e){
        FruitFactory facto = new FruitFactory();

        try {
            if (mainView.isActiv()) {
                if(((Component)e.getSource()).getName().equals("add")) {
                        String fruitName = mainView.getFieldName();
                        Integer quantity = mainView.getFieldQuantity();

                        FruitSimple fruit = facto.createFruitSimple(fruitName);

                        if (mainView.isJuice()) {
                            Jus jus = facto.createJus(fruit);
                            this.p.ajout(jus, quantity);
                        } else {
                            this.p.ajout(fruit, quantity);
                        }
                }
                else if(((Component)e.getSource()).getName().equals("btnMacedoine")) {
                    VueMacedoine vm = new VueMacedoine();
                    vm.addControleur(this);
                    try {
                        vm.setFruitsChoices(fruitsClasses);
                    } catch (Exception exc) {
                        System.out.println(exc);
                    }
                    mainView.closeView();
                    vm.openView();
                    this.secondaryView = vm;
                }
                else if (((Component)e.getSource()).getName().equals("del")) {
                    this.p.retrait();
                }
                else if (((Component)e.getSource()).getName().equals("comboName")) {
                    HashMap<String, String> values = FruitHelper.getDefaultValuesFor(mainView.getFieldName());
                    mainView.updateForm((String) values.get("origin"), (String) values.get("price"));
                }
                else {
                    int position = mainView.getLineToRemove();
                    String name = mainView.getNameAt(position);
                    String origin = mainView.getOriginAt(position);
                    double price = mainView.getPriceAt(position);
                    this.p.retrait(name, origin, price);
                }
            }
            if (secondaryView != null && secondaryView.getName() == "Macedoine" && secondaryView.isActiv()) {
                if(((Component)e.getSource()).getName().equals("addMacedoine")) {
                    secondaryView.closeView();
                    mainView.openView();
                    Macedoine macedoine = facto.createMacedoine(((VueMacedoine) this.secondaryView).getMacedoine());
                    this.p.ajout(macedoine, 1);
                }
                else if(((Component)e.getSource()).getName().equals("add")) {
                    String fruitName = ((VueMacedoine) this.secondaryView).getFieldName();
                    FruitSimple fruit = facto.createFruitSimple(fruitName);
                    ((VueMacedoine) this.secondaryView).addFruit(fruit);
                } else if (((Component)e.getSource()).getName().equals("comboName")) {
                    HashMap<String, String> values = FruitHelper.getDefaultValuesFor(secondaryView.getFieldName());
                    secondaryView.updateForm(values.get("origin"), values.get("price"));
                }

            }
        } catch (PanierVideException | PanierPleinException ex) {
            System.out.println(ex);
        }
    }

    public void setPanier(Panier p){
        this.p = p;
    }

    public Panier getPanier() {
        return this.p;
    }

    public void setMainVue(VuePanierV2 mainView){
        this.mainView = mainView;
    }

    public VueG getMainVue() {
        return this.mainView;
    }

    public void setSecondaryVue(VueMacedoine secondaryView){
        this.secondaryView = secondaryView;
    }

    public VueG getSecondaryVue() {
        return this.secondaryView;
    }

    public void setFruitsClasses(ArrayList<String> fruitsClasses) {
        this.fruitsClasses = fruitsClasses;
    }
}
