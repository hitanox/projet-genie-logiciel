package fr.ufrsciencestech.panier.view;

import java.util.*;

public class VueConsole implements Observer{
    private String trace;
    
    /**
     * @return the trace
     */
    public String getTrace() {
        return trace;
    }

    /**
     * @param trace the trace to set
     */
    public void setTrace(String trace) {
        this.trace = trace;
    }
    
    public VueConsole(){
        trace = "Valeur initiale : " + 0;
        System.out.println(trace);
    }
    
    public void update(Observable m, Object compte){   //This method is called whenever the observed object is changed
        trace = "Nouvelle valeur : " + ((Integer) compte).toString();
        System.out.println(trace);
    }
}
