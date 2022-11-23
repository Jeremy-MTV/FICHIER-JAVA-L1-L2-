
public class Case {
	boolean couleur;
	Piece piece;
	
	Case(boolean couleur, Piece piece){
		this.couleur = couleur;
		this.piece = piece;
	}
	
	Piece getPiece() {
		return this.piece;
	}
	
	boolean estVide() {
		return this.piece == null;
	}
	
	void remplirPiece(Piece p) {
		this.piece = p;
	}
	
	void enleverPiece() {
		this.piece = null;
	}
	
	
	
	public String toString() {
		if(piece == null){
			if(couleur) return ".";
			else return "#";
		}
		return piece.toString().charAt(0) + "";
	}
	
}
