
public class Tour extends Piece{
	
	Tour(boolean couleur){
		super(couleur, "Tour");
	}
	
	public boolean estValide (Deplacement d , Plateau p) {
        if (!super.estValide(d, p) || d.typeDeplacement() != 'v' && d.typeDeplacement() != 'h'
        || !p.intermVide(d)) return false ; 
        int [] n = d.getNouvelleCoord() ;
        if (!p.getCase(n[0], n[1]).estVide() && p.getCase(n[0], n[1]).getPiece().couleur == super.couleur) return false ; 
        return true ; 
    }
	//Mémo : Déplacement de haut en bas et de gauche à droite par rapport à la tour.
}
