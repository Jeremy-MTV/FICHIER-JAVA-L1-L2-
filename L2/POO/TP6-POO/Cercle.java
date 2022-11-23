public class Cercle extends Ellipse{

    public Cercle(int x, int y, double rayon) {
        super(x, y, y, rayon);
    }

    @Override
    public void affiche() {
        System.out.println("Cercle : Le Centre est (" + getPosX() + "," + getPosY() + ") ,  Rayon = " + super.getGrandRayon());
    }
    
}
