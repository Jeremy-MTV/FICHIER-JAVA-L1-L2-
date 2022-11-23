public abstract class Figure {
    // coordonnées du centre approximatif de la figure
    private int posX;
    private int posY;
    public Figure(int x, int y) {
    posX = x;
    posY = y;
    }

    public final int getPosX(){
        return posX;
    }

    public final int getPosY(){
        return posY;
    }

    public abstract void affiche();

    public abstract double surface();

    public double Distance(Figure f){
        return Math.sqrt(Math.pow(posX-f.posX, 2) + Math.pow(posY-f.posY, 2));
    }

    public void mouvement(int x, int y){
        this.posX = x;
        this.posY = y;
    }

}
    