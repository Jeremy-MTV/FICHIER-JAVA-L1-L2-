
public class Lanceur {
	
	
	
	public static void main(String[] args) {
		System.out.println("Le Démineur ;)");
		System.out.println();
//		p.afficheTout();
		
		
		Joueur a = new Joueur();
		a.setNom(a.demanderNom());
		
		if(!a.veutJouer()){
			System.out.println("Au plaisir de vous revoir :) ");
			a.finir();
			System.exit(1);
		}
		
		
		
		boolean jeu;
		do {
			int[] dim = a.demanderDimensions();
			int mines;
			mines = a.demandernbMines();
			Plateau p = new Plateau(dim[0], dim[1], mines);
			Jeu j1 = new Jeu(a, p);
			p.afficheCourant();
			jeu = j1.jouer();
		}while(jeu);
		
		
		
	}
}