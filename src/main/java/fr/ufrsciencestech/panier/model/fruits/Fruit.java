package fr.ufrsciencestech.panier.model.fruits;

public interface Fruit {
    /**
     * Prédicat indiquant si le fruit a ou non des pepins
     * @return
     */
    boolean isSeedless();

    /**
     * Nom du fruit
     * @return
     */
    String getNom();

    /**
     * Prix unitaire du fruit (en euros)
     * @return
     */
    double getPrix();

    /**
     * Pays d'origine du fruit
     * @return
     */
    String getOrigine();

    /**
     * Prédicat pour tester si 2 fruits sont equivalents
     * @param o
     * @return résultat
     */
    @Override
    boolean equals(Object o);

    /**
     * Retourne un hashage du fruit
     * @return
     */
    @Override
    int hashCode();

    /**
     * Affichage d'un fruit
     * @return
     */
    @Override
    String toString();
}
