package fr.ufrsciencestech.panier.model;

public class Poire implements Fruit{
    private double prix;
    private String origine;
	
    public Poire() 
    {
        this.prix = 0.8;  //prix en euros
        this.origine="Espagne";
    }
    
    public Poire(double prix, String origine) 
    {
	if(prix < 0)
	    this.prix = -prix;  //une solution possible pour interdire les prix negatifs
	else
	    this.prix = prix;

	if(origine.equals(""))
            this.origine = "Espagne";  //Espagne par défaut
	else
            this.origine = origine;   
    }

    public double getPrix(){
	return prix;
    }

    public void setPrix(double prix){
	this.prix=prix;
    }

    public String getOrigine(){
	return origine;
    }
 
    public void setOrigine(String origine){
	this.origine=origine;
    }

    @Override
    public String toString(){
        return "Poire de " + origine + " a " + prix + " euros";
    }

    @Override
    public boolean equals(Object o){  //predicat pour tester si 2 poires sont equivalentes
        if(o != null && getClass() == o.getClass()){
            Poire po = (Poire) o;
            return (prix == po.prix && origine.equals(po.origine));
        }
        return false;
    }

    public boolean isSeedless() {  //predicat indiquant qu'une poire a des pepins
        return false;
    }


    public static void main (String[] args){
        //Ecrire ici vos tests
	System.out.println("premier test Poire");
    Poire p = new Poire(2.5, "France");
    System.out.println(p.toString());

   }
}
