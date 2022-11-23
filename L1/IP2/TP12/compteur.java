public class compteur{
    private int kilometre_total; //intouchable
    public int kilometre_journalier; // possibilité de le mettre à zero tout les jours.
    private int vitesse;
    private String entreprise; //va changer avec le temps
    private  String unité; //0 = miles/h et 1 = km/h
    int ancienne_vitesse;

    

    compteur(int k_t, int k_j, int v, String e, String unit){
        this.kilometre_total = k_t;
        this.kilometre_journalier = k_j;
        this.vitesse = v;
        this.entreprise = e;
        this.unité = unit;
        this.ancienne_vitesse = 0;
    }

    public void unité(){
        System.out.println(this.unité);
    }

    public void Changer_unité(String s){
        if(this.unité.equals("miles/h")){
            if(s.equals("km/h")){
                this.unité = "km/h"
                System.out.print("vous avez choisi l'unité : km/h");
            }
        }
        if(this.unité.equals("km/h")){
            if(s.equals("miles/h")){
                this.unité = "miles/h"
                System.out.print("vous avez choisi l'unité : miles/h");
            }
        }
    }

    public void accelerer(int n){
        if(this.vitesse < 220){
            this.ancienne_vitesse = this.vitesse;
            this.vitesse+=n;
        }
    }

    public void vitesse(){
        System.out.print("Votre voiture roule à " +  this.vitesse);
    }

   

    public void reset(){
        this.kilometre_journalier = 0;
    }

    public void message_revision(){
        if(this.kilometre_journalier - 10000 != 0){
            System.out.println("Vous devez faire une revision");
        }
    }

    public void rachat(){
        
    }
}