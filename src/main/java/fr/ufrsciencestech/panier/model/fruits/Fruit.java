package fr.ufrsciencestech.panier.model.fruits;

public interface Fruit {
    public boolean isSeedless();  //predicat indiquant si le fruit a ou non des pepins

    public String getNom();
    
    public double getPrix();      //prix unitaire du fruit (en euros)

    public String getOrigine();   //pays d'origine du fruit

    @Override
    public boolean equals(Object o);  //predicat pour tester si 2 fruits sont equivalents

    @Override
    public String toString();    //affichage d'un fruit
}
