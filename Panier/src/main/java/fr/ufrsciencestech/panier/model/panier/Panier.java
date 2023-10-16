package fr.ufrsciencestech.panier.model.panier;

import fr.ufrsciencestech.panier.model.fruits.Fruit;

import java.util.ArrayList;
import java.util.Observable;

public class Panier extends Observable {
    private ArrayList<Fruit> fruits;  //attribut pour stocker les fruits
    private final int contenanceMax; //nb maximum d'oranges que peut contenir le panier

    public Panier(int contenanceMax) {  //initialise un panier vide ayant une certaine contenance maximale (precisee en parametre)
        this.fruits = new ArrayList<Fruit>();
        if (contenanceMax < 1) {
            throw new IllegalArgumentException("La contenance maximale doit être supérieure à 0");
        } else {
            this.contenanceMax = contenanceMax;
        }
    }

    @Override
    public String toString() {  //affichage de ce qui est contenu dans le panier : liste des fruits presents
        String res = "Panier de " + this.getTaillePanier() + " fruits : " + this.getPrix() + "\n";
        for (Fruit fruit : fruits) {
            res += fruit.toString() + "\n";
        }
        return res;
    }

    public ArrayList<Fruit> getFruits() {  //accesseur du premier attribut
        return this.fruits;
    }

    public void setFruits(ArrayList<Fruit> fruits) { //modificateur du premier attribut
        this.fruits = fruits;
    }

    public int getTaillePanier() {  //accesseur retournant la taille allouee pour l'attibut fruits
        return this.fruits.size();
    }

    public int getContenanceMax() {  //accesseur du second attribut
        return this.contenanceMax;
    }

    public Fruit getFruit(int i) {  //accesseur retournant le fruit contenu dans le panier a l'emplacement n°i ou null s'il n'y a rien a cet emplacement
        return this.fruits.get(i);
    }

    public void setFruit(int i, Fruit f) {  //modificateur du fruit contenu dans le panier a l'emplacement n°i par f (s'il y a bien deja un fruit a cet emplacement, ne rien faire sinon)
        if (this.fruits.contains(this.fruits.get(i))) {
            this.fruits.set(i, f);
        }
    }

    public boolean estVide() {  //predicat indiquant que le panier est vide
        return this.fruits.isEmpty();
    }

    public boolean estPlein() {  //predicat indiquant que le panier est plein
        return this.fruits.size() == this.contenanceMax;
    }

    public void ajout(Fruit o) throws PanierPleinException {  //ajoute le fruit o a la fin du panier si celui-ci n'est pas plein
        if (!estPlein()) {
            this.fruits.add(o);
            setChanged(); //marks this Observable object as having been changed; the hasChanged method will now return true
            notifyObservers(this); //if this object has changed, as indicated by the hasChanged method, then notify all of its observers and then call the clearChanged method to indicate that this object has no longer changed
        } else throw new PanierPleinException();
    }

    public void retrait() throws PanierVideException { //retire le dernier fruit du panier si celui-ci n'est pas vide
        if (!estVide()) {
            this.fruits.remove(getTaillePanier() - 1);
            setChanged(); //marks this Observable object as having been changed; the hasChanged method will now return true
            notifyObservers(this); //if this object has changed, as indicated by the hasChanged method, then notify all of its observers and then call the clearChanged method to indicate that this object has no longer changed
        } else throw new PanierVideException();
    }

    public double getPrix() {  //calcule le prix du panier par addition des prix de tous les fruits contenus dedans
        double prix = 0.0;
        for (Fruit fruit : fruits) {
            prix += fruit.getPrix();
        }
        return prix;
    }

    public void boycotteOrigine(String origine) {
        ArrayList<Fruit> filters = new ArrayList<>();

        for (Fruit fruit : this.fruits) {
            if (!fruit.getOrigine().equals(origine)) {
                filters.add(fruit);
            }
        }

        this.fruits = filters;
    }

    @Override
    public boolean equals(Object o) {  ///predicat pour tester si 2 paniers sont equivalents : s'ils contiennent exactement les memes fruits
        if (o != null && getClass() == o.getClass()) {
            Panier p = (Panier) o;
            int compt = 0;
            if (p.fruits.size() == this.fruits.size()) {
                for (Fruit f : p.fruits) {
                    if (this.fruits.contains(f)) {
                        System.out.println(f);
                        compt++;
                    }
                }
                return compt == p.fruits.size();
            }
        }
        return false;
    }
}
