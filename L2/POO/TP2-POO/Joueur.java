import java.util.Scanner;

public class Joueur{
	String nom;
	Scanner scanReponse;
	
	Joueur(){
		nom = "anonyme";
		scanReponse = new Scanner(System.in);
	}
	
	void setNom(String nom) {
		this.nom = nom;
	}
	
	void finir() {
		scanReponse.close();
	}
	
	public boolean veutJouer() {
		System.out.println("Voulez vous jouer ? Oui/Non ?");
		String test = scanReponse.nextLine();
		test = test.toLowerCase();
		if(test.equals("oui")){
			return true;
		}
		return false;
	}
	
	public String demanderNom() {
		System.out.println("Quelle est votre nom ?");
		String n = scanReponse.nextLine();
		return n;
	}
	
	public int[] demanderDimensions() {
		int[] dim = new int[2];
		String l = "";
		String h = "";
		
		System.out.println("Quelle largeur voulez-vous ?");
		l = scanReponse.nextLine();
		dim[0] = Integer.parseInt(l);
		
		System.out.println("Quelle hauteur voulez-vous ?");
		h = scanReponse.nextLine();
		dim[1] = Integer.parseInt(h);
		
		return dim; //on va récuperer les valeurs de dimension dans le tableau
	}
	
	public int demandernbMines() {
		System.out.println("Combien de mines voulez-vous ?");
		int mines;
		do {
			mines = scanReponse.nextInt();
		}while(mines <= 1);
		return mines;
	}
	
	public char demanderAction() {
		String choix;
		do {
			System.out.println("Voulez-vous reveler une case (r) ou placer un drapeau (d) ?");
			choix = scanReponse.nextLine();
			
		}while(choix.length() != 1);
		return choix.charAt(0);
	}
	
	public String demanderCoordonnes() { //ici je préfère utiliser une fonction String car j'ai implémenter des fonctions dans Plateau qui me permettent de prendre le String et d'en retirer les coordonnées directement.
		String c;
		do {
			System.out.println("Quelles coordonnées voulez-vous atteindre ? Exemple : B2 ");
			c = scanReponse.nextLine();
		}while(c.length() != 2 || (c.charAt(0) < 'A' && c.charAt(0) > 'Z'));
		return c;
		
		
	}
	public static void main(String[] args) {
		
	}
}
