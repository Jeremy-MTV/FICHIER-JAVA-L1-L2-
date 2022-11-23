public class Plateau {
	private int hauteur;
	private int largeur;
	private Case[][] plateau;
	
	Plateau(int hauteur, int largeur){
		this.setHauteur(hauteur);
		this.largeur = largeur;
		this.plateau = new Case[hauteur][largeur];
		
//		for(int i=0; i<hauteur; i++) {
//			for(int j=0; j<largeur; j++) {
//				if(i%2 == 0 && j%2 == 0) plateau[i][j] = new Case(false, null);
//				else if(i%2 != 0 && j%2 != 2) plateau[i][j] = new Case(false, null);
//				else plateau[i][j] = new Case(true, null);
//			}
//		}
		
		for(int i=0; i<hauteur; i++) {
			for(int j=0; j<largeur; j++) {
				if(i%2 == 0) {
					if(j%2 == 0) plateau[i][j] = new Case(false, null);
					else plateau[i][j] = new Case(true, null);
				}else {
					if(j%2 == 0) plateau[i][j] = new Case(true, null);
					else plateau[i][j] = new Case(false, null);
				}
			}
		}
		
	}
	
	public boolean horsLimite(int x, int y) {
		return x<0 || x>= getHauteur() | y<0 || y>= largeur;
	}
	
//	public boolean horsLimite(Deplacement d) { //Cela va permettre de realiser les déplacements en extracta
//		int[] a = d.getNouvelleCoord();
//		if(horsLimite(a[0], a[1])) return true;
//		return false;
//	}
	
	public Case getCase(int x, int y) {
		if(horsLimite(x, y)) return null;
		return plateau[x][y];
	}
	
	public void videCase(int x, int y) {
		getCase(x, y).enleverPiece();
	}
	
	public void remplirCase(int x, int y, Piece p) {
		getCase(x, y).remplirPiece(p);
	}
	
	public void afficher() { //L'affichage ici permet de pouvoir obtenir les barres verticales et horizontales avec les numéros des cases.
        System.out.println("   0 1 2 3 4 5 6 7 8 9\n");
        int a = 0;
        for(Case [] t : plateau) {
			System.out.print(a+"  ");
			for(Case x : t) {
				System.out.print(x.toString() + " ");
			}
			a++;
			System.out.println();
		}
		
	}
	
	public boolean intermVide (Deplacement d){ //l'idée ici c'est de pouvoir detecter les interstices entre chaques pièces de l'échéquier afin de pouvoir vérifier la possibilité ou non d'un mouvement.
        int [] a = d.getAncienneCoord() ; 
        int [] n = d.getNouvelleCoord() ;
        int dist = d.dist();
        int c;
        switch (d.typeDeplacement()+"") {

            case "h" : 
                c = (n[0]<a[0])?1:-1 ; //si si la coord suivante est inférieur à la coord precedente, c vaut 1 sinon -1, ici le déplacement est caractérise par un saut en hauteur
                for (int i = 1; i < dist; i++) {
                    if (!plateau[a[1]][a[0]+i*c].estVide()) return false ; 
                }
                return true ; 

            case "v" : 
                c = (a[1]<n[1])?1:-1 ; //si la coord precedente est inférieur à la coord suivante, c vaut 1 sinon -1, ici le deplacement est effectué de gauche à droite
                for (int i = 1; i < dist; i++) {
                    if (!plateau[a[1]+c*i][a[0]].estVide()) return false ; 
                }
                return true ;  

            case "d" : 
                c = (a[0] < n[0])?1:-1 ; //si la coord precedente est inférieur à la cord suivante, c vaut 1 sinon c vaut -1, on parle d'un déplacement en diagonale
                int c2 = (a[1] < n[1])?1:-1 ; 
                for (int i = 1 ; i<dist ; i++) {
                    if (!plateau[a[1]+c2*i][a[0]+c *i].estVide()) return false ; 
                } 
                return true ;       
        }
        return false ; 
    }

	public int getHauteur() {
		return hauteur;
	}

	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}


}
