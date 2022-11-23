
public class Cavalier extends Piece {
	
	Cavalier(boolean couleur){
		super(couleur, "Cavalier");
	}
	
	public boolean estValide(Deplacement d, Plateau p) {
			if(super.estValide(d, p) || d.typeDeplacement() != 'c') return false;
			int[] a = d.getNouvelleCoord();
			if(!p.getCase(a[0], a[1]).estVide() && p.getCase(a[0], a[1]).getPiece().couleur == super.couleur) return false;
			return true;
	}
	
	//Mémo : Déplacement particulier 
	//		 Ignore les autres pièces lors de son déplacement
	//Cavalier : 
	//          . . . . .
	//			. * . * .
	//			* . . . *
    //          . . C . .
    //          * . . . *
    //          . * . * .	


}
