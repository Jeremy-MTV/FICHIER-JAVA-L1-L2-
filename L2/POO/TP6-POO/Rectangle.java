public class Rectangle extends Figure{

    private final double largeur;
    private final double longueur;

    public Rectangle(int x, int y, double largeur, double longueur) {
        super(x, y); //X et y représentent la position du centre
        this.largeur = largeur;
        this.longueur = longueur;
    }


    @Override
    public void affiche() { 
        System.out.println("Rectangle : Le centre est (" + getPosX() + "," + getPosY() + ")" + "La longueur est " + longueur + "La Largeur est " + largeur  );       
    }
    
    public Figure deformation(double coefV, double coefH){
        double newLongueur = longueur*coefV;
        double newLargeur = largeur*coefH;
        return (newLongueur == newLargeur)?(new Carre(getPosX(), getPosY(), newLargeur)):(new Rectangle(getPosX(), getPosY(), newLongueur, newLargeur)) ;
    }

    public double surface(){return longueur*largeur;}
}
