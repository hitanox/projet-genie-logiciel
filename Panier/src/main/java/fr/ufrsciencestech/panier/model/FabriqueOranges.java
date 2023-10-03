package fr.ufrsciencestech.panier.model;

public class FabriqueOranges implements Fabrique {
    @Override
    public Fruit fabrique() {
        return new Orange();
    }
    
    @Override
    public Fruit fabrique(double prix, String origine) {
        return new Orange(prix, origine);
    }
}
