public class Piece {
	boolean couleur;
	String piece;
	
	Piece(boolean couleur, String piece){
		this.couleur = couleur;
		this.piece = piece;
	}
	
	public String toString() {
		if(this.couleur) {
			char a = this.piece.charAt(0);
			String b = a + "";
			b.toLowerCase();
			for(int i = 1; i<this.piece.length(); i++) {
				b = b + this.piece.charAt(i);
			}
			return b;
		}else {
			char a = this.piece.charAt(0);
			String b = a + "";
			b.toUpperCase();
			for(int i = 1; i<this.piece.length(); i++) {
				b = b + this.piece.charAt(i);
			}
			return b;
		}
	}
	
	public boolean estValide(Deplacement d, Plateau p) {
		int[] ancienneCoord = d.getAncienneCoord();
		int[] a = d.getNouvelleCoord();
		return !p.horsLimite(a[0], a[1]) &&  (p.getCase(a[0], a[1]).getPiece() == null || p.getCase(a[0], a[1]).getPiece().couleur != couleur) && (a[0] != ancienneCoord[0] || a[1] != ancienneCoord[1]);	
	}
	
	public static void main(String[] args) {
		Piece a = new Piece(true, "ROI");
		System.out.print(a.toString());
	}

}
