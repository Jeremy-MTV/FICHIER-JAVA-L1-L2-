
public class Roi extends Piece{
	
	Roi(boolean couleur){
		super(couleur, "Roi");
	}
	
	public boolean estValide (Deplacement d , Plateau p) {
        if (!super.estValide(d, p) || d.dist() != 1 || !p.intermVide(d)) return false ; 
        int [] n = d.getNouvelleCoord() ;
        if (!p.getCase(n[0], n[1]).estVide() &&
        p.getCase(n[0], n[1]).getPiece().couleur == super.couleur) return false ; 
        return true ; 
    }
	
	//Mémo : Déplacement sur les cases autour du roi
	
}
