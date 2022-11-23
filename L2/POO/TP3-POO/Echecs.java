
public class Echecs {
	private boolean joueur ; 

	Echecs () {
	    this.joueur = true ; 
	}
	  
	public void jouerTour (Deplacement d , boolean joueur , Plateau p){ 
		    int[] a = d.getNouvelleCoord();
			if (p.horsLimite(a[0], a[1])) return ; 
		    int [] A = d.getAncienneCoord() ;
		    Case c = p.getCase(A[0], A[1]) ;
		    Piece pp = c.getPiece() ; 
		    if (pp.estValide(d, p)) {
		      int [] n = d.getNouvelleCoord() ; 
		      c.enleverPiece();
		      c = p.getCase(n[0], n[1]) ;
		      c.remplirPiece(pp);
		      p.afficher();
		   }  
	}
	  
	public static void main(String[] args) {
//		Plateau p = new Plateau(10, 10);
//		Roi f = new Roi(true);
//		p.remplirCase(4, 3, f);
//		p.afficher();
		Plateau pl1 = new Plateau(10, 10) ;  
        Fou f1 = new Fou(false) ;
        Pion p1 = new Pion(true) ; 
        pl1.remplirCase(2, 2, p1);
        pl1.remplirCase(0, 0, f1);

        
        pl1.afficher();
		
	}
}
