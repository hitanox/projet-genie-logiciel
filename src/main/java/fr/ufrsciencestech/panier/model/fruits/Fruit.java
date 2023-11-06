package fr.ufrsciencestech.panier.model.fruits;

public interface Fruit {
    boolean isSeedless();  //predicat indiquant si le fruit a ou non des pepins

    String getNom();

    double getPrix();      //prix unitaire du fruit (en euros)

    String getOrigine();   //pays d'origine du fruit

    @Override
    boolean equals(Object o);  //predicat pour tester si 2 fruits sont equivalents

    @Override
    int hashCode();

    @Override
    String toString();    //affichage d'un fruit
}
