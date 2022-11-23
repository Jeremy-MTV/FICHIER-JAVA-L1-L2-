public class Triangle extends Figure implements Deformable{

    private double base;
    private double hauteur;

    public Triangle(int x, int y, double base, double hauteur) {
        super(x, y);
        this.base = base;
        this.hauteur = hauteur;
    }

    @Override
    public void affiche() { 
        System.out.println("Triangle : Le centre est (" + getPosX() + "," + getPosY() + ")"+ "La Base est  " + base + " La Hauteur est " + hauteur);
    }

    public double surface(){
        return base*hauteur;
    }
    
    public Figure deformation(double coefV, double coefH){
        return new Triangle(getPosX(), getPosY(), base*coefH, hauteur*coefV);
    }

    
    
}
