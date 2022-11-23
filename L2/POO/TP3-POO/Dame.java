
public class Dame extends Piece{
	Dame(boolean couleur){
		super(couleur, "Dame");
	}
	
	public boolean estValide(Deplacement d, Plateau p) {
		Fou a = new Fou(super.couleur);
		Tour t = new Tour(super.couleur);
		return a.estValide(d, p) || t.estValide(d, p); //Normalement, les deux mouvement du fou et de la tour permettent de retrouver ceux de la dame.
	}
	//Mémo : Déplacement en diagonale, de haut en bas, de gauche à droite et sur les cases autour de la dame.
}
