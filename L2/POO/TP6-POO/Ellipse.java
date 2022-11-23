public class Ellipse extends Figure implements Deformable{

    private final double grand_rayon;
    private final double petit_rayon;

    public Ellipse(int x, int y, double gr, double pr) {
        super(x, y); //Position du centre
        this.grand_rayon = gr;
        this.petit_rayon = pr;
    }
    
    public void affiche(){
        System.out.println("Ellipse : Le Centre est (" + getPosX() + "," + getPosY() + ") , Le petit rayon est " + petit_rayon + "Le Grand Rayon est " + grand_rayon);
    }

    public final double getPetitRayon(){return petit_rayon;}
    public final double getGrandRayon(){return grand_rayon;}

    public Figure deformation(double coefV, double coefH){
        double newPetitRayon = petit_rayon*coefH;
        double newGrandRayon = grand_rayon*coefV;
        return(newPetitRayon == newGrandRayon)?(new Cercle(getPosX(), getPosY(), newGrandRayon)):(new Ellipse(getPosX(), getPosY(), newPetitRayon, newGrandRayon));
    }

    public double surface(){
        return Math.PI*grand_rayon*petit_rayon; //Utilisation de la bibliotèque Math pour PI
    }
    
}
