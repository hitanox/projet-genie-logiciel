package fr.ufrsciencestech.panier.model.panier;

import fr.ufrsciencestech.panier.model.fruits.Fruit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class Panier extends Observable {

    private ArrayList<Fruit> fruits;  //attribut pour stocker les fruits
    private final int contenanceMax; //nb maximum d'oranges que peut contenir le panier

    public Panier(int contenanceMax) {  //initialise un panier vide ayant une certaine contenance maximale (precisee en parametre)
        this.fruits = new ArrayList<>();
        if (contenanceMax < 1) {
            throw new IllegalArgumentException("La contenance maximale doit être supérieure à 0");
        } else {
            this.contenanceMax = contenanceMax;
        }
    }

    /**
     * Affichage de ce qui est contenu dans le panier : liste des fruits presents
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("Panier de " + this.getTaillePanier() + " fruits : " + this.getPrix() + "\n");
        for (Fruit fruit : fruits) {
            res.append(fruit.toString()).append("\n");
        }
        return res.toString();
    }

    /**
     * Accesseur de la liste de fruits
     * @return liste de fruits
     */
    public ArrayList<Fruit> getFruits() {  
        return this.fruits;
    }

    /**
     * Modificateur de la liste de fruits
     * @param fruits
     */
    public void setFruits(ArrayList<Fruit> fruits) {
        this.fruits = fruits;
    }

    /**
     * Accesseur retournant la taille allouee pour l'attibut fruits
     * @return taille du panier
     */
    public int getTaillePanier() {
        return this.fruits.size();
    }

    /**
     * Accesseur de la contenance maximale du panier
     * @return contenance maximale du panier
     */
    public int getContenanceMax() {
        return this.contenanceMax;
    }

    /**
     * Accesseur retournant le fruit contenu dans le panier a l'emplacement n°i ou null s'il n'y a rien a cet emplacement
     * @param i position du fruit que l'on veut
     * @return fruit souhaité ou null
     */
    public Fruit getFruit(int i) {  
        return this.fruits.get(i);
    }

    /**
     * Modificateur du fruit contenu dans le panier a l'emplacement n°i par f (s'il y a bien deja un fruit a cet emplacement, ne rien faire sinon)
     * @param i position que l'on veux modifier
     * @param f fruit que l'on veut ajouter
     */
    public void setFruit(int i, Fruit f) {  
        if (this.fruits.contains(this.fruits.get(i))) {
            this.fruits.set(i, f);
        }
    }

    /**
     * Prédicat indiquant que le panier est vide
     * @return booléen informant si le panier est vide ou non
     */
    public boolean estVide() {  
        return this.fruits.isEmpty();
    }

    /**
     * Prédicat indiquant que le panier est plein
     * @return booléen informant si le panier est plein ou non
     */
    public boolean estPlein() {  
        return this.fruits.size() == this.contenanceMax;
    }

    /**
     * Ajoute le fruit o à la fin du panier si celui-ci n'est pas plein
     * @param o fruit à ajouter
     * @param quantity nombre de fruits à ajouter
     * @throws PanierPleinException
     */
    public void ajout(Fruit o, Integer quantity) throws PanierPleinException {  
        for (int i = 0; i < quantity; i++) {
            if (!estPlein()) {
                this.fruits.add(o);
            } else {
                setChanged();
                notifyObservers(this);
                throw new PanierPleinException();
            }
        }
        setChanged();
        notifyObservers(this);
    }

    /**
     * Retire le dernier fruit du panier si celui-ci n'est pas vide
     * @return fruit retiré
     * @throws PanierVideException
     */
    public Fruit retrait() throws PanierVideException { 
        if (!estVide()) {
            Fruit fruit = this.fruits.get(getTaillePanier() - 1);;
            this.fruits.remove(getTaillePanier() - 1);
            setChanged();
            notifyObservers(this);
            return fruit;
        } else throw new PanierVideException();
    }
    
    /**
     * Retire du panier les fruits identifiés par nom, origine et prix
     * @param nom
     * @param origine
     * @param prix
     * @return exemple de fruit retiré
     * @throws PanierVideException
     */
    public Fruit retrait(String nom, String origine, double prix) throws PanierVideException {
        if (!estVide()) {
            Fruit fruit = null;
            for(int i=0; i<getTaillePanier(); i++) {
                if(getFruit(i).getNom().equals(nom) && getFruit(i).getOrigine().equals(origine) && getFruit(i).getPrix()==prix) {
                    fruit = this.fruits.get(i);
                    this.fruits.remove(i);
                    i--;
                }
            }
            setChanged();
            notifyObservers(this);
            return fruit;
        } else throw new PanierVideException();
    }

    /**
     * Calcule le prix du panier par addition des prix de tous les fruits contenus dedans
     * @return prix du panier
     */
    public double getPrix() {  
        double prix = 0.0;
        for (Fruit fruit : fruits) {
            prix += fruit.getPrix();
        }
        return prix;
    }

    /**
     * Boycotte une origine placée en paramètre
     * @param origine
     */
    public void boycotteOrigine(String origine) {
        ArrayList<Fruit> filters = new ArrayList<>();

        for (Fruit fruit : this.fruits) {
            if (!fruit.getOrigine().equals(origine)) {
                filters.add(fruit);
            }
        }

        this.fruits = filters;
    }

    /**
     * Prédicat pour tester si 2 paniers sont equivalents : s'ils contiennent exactement les memes fruits
     * @return prédicat
     */
    @Override
    public boolean equals(Object o) {  
        if (o != null && getClass() == o.getClass()) {
            Panier p = (Panier) o;
            int compt = 0;
            if (p.fruits.size() == this.fruits.size()) {
                for (Fruit f : p.fruits) {
                    if (this.fruits.contains(f)) {
                        compt++;
                    }
                }
                return compt == p.fruits.size();
            }
        }
        return false;
    }

    /**
     * Transforme le panier en une matrice d'objets : chaque ligne contient un fruit avec sa description (nom, prix origine, quantité)
     * @return matrice d'objets obtenue
     */
    public Object[][] toObject() {
        Map<Fruit, Integer> fruitWithQuantity = new HashMap<>();

        for (int i = 0; i < fruits.size(); i++) {
            Fruit fruit = fruits.get(i);

            if (fruitWithQuantity.containsKey(fruit)) {
                int currentQuantity = fruitWithQuantity.get(fruit);
                fruitWithQuantity.put(fruit, currentQuantity + 1);
            } else {
                fruitWithQuantity.put(fruit, 1);
            }
        }
        System.out.println("\n");

        Object[][] res = new Object[fruitWithQuantity.size()][4];
        int i = 0;

        for (Map.Entry<Fruit, Integer> entry : fruitWithQuantity.entrySet()) {
            Fruit fruit = entry.getKey();
            int quantity = entry.getValue();
            res[i][0] = (fruit.getNom() != null) ? fruit.getNom() : "";
            res[i][1] = (fruit.getOrigine() != null) ? fruit.getOrigine() : "";
            res[i][2] = fruit.getPrix();
            res[i][3] = quantity;

            i++;
        }

        return res;
    }
}
