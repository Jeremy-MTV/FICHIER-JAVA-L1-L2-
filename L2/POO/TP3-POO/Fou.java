
public class Fou extends Piece{
	
	Fou(boolean couleur){
		super(couleur, "Fou");
	}
	
	public boolean estValide(Deplacement d, Plateau p) {
		if(!super.estValide(d, p) || d.typeDeplacement() != 'd' || !p.intermVide(d)) return false;
		int[] n = d.getNouvelleCoord();
		if(!p.getCase(n[0], n[1]).getPiece().couleur == super.couleur) return false;
		return true;
		
	}
	
	//Mémo : Déplacement en diagonale, donc en croix. 
}
