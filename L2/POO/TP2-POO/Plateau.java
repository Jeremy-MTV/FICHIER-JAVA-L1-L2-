
import java.util.Random;

public class Plateau {
	
	int hauteur;
	int largeur;
	int nbMines;
	int nbDrapeaux;
	
	private boolean[][] mines;
	private int[][] etats;
	private int[][] adja;
	
	Plateau(int hauteur, int largeur, int nbMines){
		this.hauteur = hauteur;
		this.largeur = largeur;
		this.nbMines = nbMines;
		nbDrapeaux = 0;
		mines = new boolean[hauteur+2][largeur+2];
		etats = new int[hauteur+2][largeur+2];
		adja = new int[hauteur+2][largeur+2];
		ajouteMinesAlea();
		calculeAdjacence();
	}
	
	private void ajouteMinesAlea() {
		Random rd = new Random();
		int mi = nbMines;
		int i, j;
		
		while(mi != 0) {
			do {
				i = rd.nextInt(hauteur+1);
			}while(i == 0);
			
			do {
				j = rd.nextInt(largeur+1);
			}while(j == 0);
			
			if(!mines[i][j]) {
				mines[i][j] = true;
				mi--;
			}
		}
	}
	
	private void calculeAdjacence() {
		for(int i=0; i< mines.length-1; i++) {
			for(int j = 0; j<mines.length-1; j++) {
				if(mines[i][j]) {
					adja[i-1][j-1]++;
					adja[i-1][j]++;
					adja[i-1][j+1]++;
					adja[i][j-1]++;
					adja[i][j+1]++;
					adja[i+1][j-1]++;
					adja[i+1][j]++;
					adja[i+1][j+1]++;
				}
			}
		}
	}
	
	
	
	public void afficheTout () {
		System.out.print("********************\n* Mines / Drapeaux *\n*    " + nbMines + "   /     " + nbDrapeaux + "  * \n********************");
		System.out.println();
        char c = 'A' ; 
        System.out.print("    ");
        for (int i = 1 ; i<largeur+1 ; i++) System.out.print(i+" ") ;  
        System.out.println();
        System.out.println("-".repeat(3+2*largeur)); 
        for (int i = 1 ; i<hauteur+1 ; i++) {
            System.out.print( (char)(c+i-1) + " | "); 
            for (int k = 1 ; k<largeur+1 ; k++) {
                if (mines[i][k]) System.out.print("* "); 
                else System.out.print(adja[i][k] + " ");
            }
            System.out.println(); 
        }
    }

	public int ligne(char a) { //fonction annexe pour revelerCase
		if(a == 'A') return 1;
		if(a == 'B') return 2;
		if(a == 'C') return 3;
		if(a == 'D') return 4;
		if(a == 'E') return 5;
		if(a == 'F') return 6;
		if(a == 'G') return 7;
		if(a == 'H') return 8;
		if(a == 'I') return 9;
		if(a == 'J') return 10;
		if(a == 'K') return 11;
		if(a == 'L') return 12;
		if(a == 'M') return 13;
		if(a == 'N') return 14;
		if(a == 'O') return 15;
		if(a == 'P') return 16;
		if(a == 'Q') return 17;
		if(a == 'R') return 18;
		if(a == 'S') return 19;
		if(a == 'T') return 20;
		if(a == 'U') return 21;
		if(a == 'V') return 22;
		if(a == 'W') return 23;
		if(a == 'X') return 24;
		if(a == 'Y') return 25;
		if(a == 'Z') return 26;
		return 0;
	}
	
	
	public void revelerCaseA(String s){
		if(s.length() > 2) System.out.print("Coordonnée incorrecte, recommencez.");
		else {
			int a = ligne(s.charAt(0));
			int b = Character.getNumericValue(s.charAt(1));
	        if ( a == 0 || a == hauteur+1 || b == 0 || b == largeur+1) return ;
	        if(etats[a][b] == 1) {
	        	System.out.println("Il y a un drapeau sur cette case !");
	        	return;
	        }
	        if(etats[a][b] == 2) {
	        	System.out.println("Cette case a déjà été révélé");
	        }
	        etats[a][b] = 2;
		}
	}
	
	public void drapeauCase(String s) {
		int a = ligne(s.charAt(0));
		int b = Character.getNumericValue(s.charAt(1));
		if(etats[a][b] == 2) System.out.println("La case a déja été révélé, impossible de mettre un drapeau");
		else if(etats[a][b] == 1) {
			System.out.println("Il y a un drapeau sur cette case, il a été enlevé");
			etats[a][b] = 0;
			nbDrapeaux--;
		}else {
			etats[a][b] = 1;
			nbDrapeaux++;
		}
	}
	
	public void afficheCourant() {
		 System.out.println("*".repeat("*  Mines  /  Drapeaux  *".length()+((nbDrapeaux>9)?1:0)));
	        System.out.println("*  Mines  /  Drapeaux  *");
	        System.out.println("*"+" ".repeat((nbMines>9)?3:4)+nbMines+"    /    "+nbDrapeaux+" ".repeat((nbDrapeaux>9)?6:7)+"*");
	        System.out.println("*".repeat("*  Mines  /  Drapeaux  *".length()+((nbDrapeaux>9)?1:0)));
	        char c = 'A' ; 
	        System.out.print("    ");
	        for (int i = 1 ; i<largeur+1 ; i++) System.out.print(i+" ") ; 
	        System.out.println();
	        System.out.println("-".repeat(3+2*largeur));
	        for (int i = 1 ; i<hauteur+1 ; i++) {
	            System.out.print( (char)(c+i-1) + " | ");
	            for (int k = 1 ; k<largeur+1 ; k++) {
	                switch (etats[i][k]) {
	                    case 0 : System.out.print(". "); break ;
	                    case 2 : System.out.print(adja[i][k] + " "); break ;
	                    default : System.out.print("! "); 
	                }
	            }
	            System.out.println();
	        }
	}
	
	public boolean jeuPerdu(){
		for (int i = 1 ; i<hauteur+1 ; i++) {
            for (int k = 1 ; k<largeur+1 ; k++) {
            	if(etats[i][k] == 2 && mines[i][k]) { //on vérifie si il y a une mine et si la case a été révélé.
            		return true;
            	}
            }
		}
		return false;
	}
	
	public boolean jeuGagne () {
        if (nbDrapeaux != nbMines) return false ;  
        for (int i = 1 ; i<hauteur+1 ; i++) {
            for (int k = 1 ; k<largeur+1 ; k++) {
                if (etats[i][k] == 1 && !mines[i][k]) return false ;  
            }
        }
        return true ; 
    }
	
	public static void main(String[] args) {
		
	}
}