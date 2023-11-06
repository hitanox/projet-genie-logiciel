package fr.ufrsciencestech.panier.view;

import fr.ufrsciencestech.panier.controler.Controleur;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public interface VueG extends Observer {
    @Override
    public void update(Observable m, Object o);
    public void addControleur(Controleur c);
    public String getName();
    public Boolean isActiv();
    public void closeView();
    public void openView();

    String getFieldName();

    void updateForm(String origin, String price);
}
