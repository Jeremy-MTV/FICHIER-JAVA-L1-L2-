
public class Pion extends Piece{
	 
	
	Pion(boolean couleur) {
		super(couleur, "Pion");
	}
	
	public boolean estValide(Deplacement d, Plateau p) {
		char typeD = d.typeDeplacement();
		int dist = d.dist();
		if(!super.estValide(d, p) || typeD != 'd' && typeD != 'v' || dist > 2 || !p.intermVide(d)) return false;
		int[] n = d.getNouvelleCoord();
		int[] a = d.getAncienneCoord();
		if(a[1] > n[1]) return false; //le cas contraire voudrait dire qu'il a reculer.
		if(typeD == 'd') {
			if(dist == 2 || p.getCase(n[0], n[1]).estVide() || p.getCase(n[0], n[1]).getPiece().couleur == super.couleur) return false;
			return true;
		}
		if(typeD == 'v') {
			if(dist == 2 && a[1] != 1 && a[1] != p.getHauteur()-2) return false;
		}
		return p.getCase(n[0], n[1]).estVide();
				
	}
	
	
	//Mémo : Déplacement toujours en avant, tout droit, à droite et à gauche.
	//       Avance d'une seule case
	// 		 Capture seulement en diagonal
	// 		 Avance de 2 cases au premier déplacement de la parti.
			 
}
