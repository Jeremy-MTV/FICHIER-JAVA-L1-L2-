
public class Jeu {
		private Joueur j;
		private Plateau p;
		
		Jeu(Joueur j, Plateau p){
			this.j = j;
			this.p = p;
		}
		
		public boolean jouer() {
			String s = j.demanderCoordonnes();
			char a = j.demanderAction();
			
			if(a == 'd') { //en cas de pose de drapeau
				p.drapeauCase(s);
				if(p.jeuGagne()) { //en cas de victoire
					System.out.println("Vous avez gagné ! Bravo !");
					p.afficheTout();
					return j.veutJouer();
				}
				
				p.afficheCourant();
				return jouer();
			}
			
			p.revelerCaseA(s);
			
			if(p.jeuPerdu()) {
				System.out.println("Vous avez perdu :/ Vous êtes tombé sur une bombe !");
				return j.veutJouer();
			}
			
			p.afficheCourant();
			return jouer();
		}
		
		public static void main(String[] args) {
			
		}
		
}
