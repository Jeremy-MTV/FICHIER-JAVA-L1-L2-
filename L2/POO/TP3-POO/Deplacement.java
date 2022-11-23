
public class Deplacement {
	private  int x0, y0, x1, y1;
	
	Deplacement(int x0, int y0, int x1, int y1){
		this.x0 = x0;
		this.y0 = y0;
		this.x1 = x1;
		this.y1 = y1;
	}
	
	public char typeDeplacement() {
		if(x0 == x1 && y0 != y1) return 'v';
		if (x0 != x1 && y0 == y1) return 'h' ;
        if (Math.abs(x0-x1) == Math.abs(y0-y1)) return 'd' ; 
        if (Math.abs(x0-x1) == 1 && Math.abs(y0-y1) == 2 || 	Math.abs(x0-x1) == 2 && Math.abs(y0-y1) == 1) return 'c' ; 
        return 'x' ;
	}
	
	public int [] getAncienneCoord () { //ici l'idéé est de pouvoir récuperer ultérieurement les anciiennes coordonnées pour les utiliser dans les autres classes notamment pour valider les déplacements des pieces
        int [] t = {x0,y0} ;
			return t ; 
	}
	 
	public int [] getNouvelleCoord () { //pareil pour les nouvelles coordonneés
        int [] t = {x1,y1} ;
        return t ;
    }

	
	public int dist() { //je ne sais pas jouer au échec donc je pense que ces déplacements sont correctement implémenter par rapport à ma manière de comprendre les déplacements des différentes pièces.
		switch(typeDeplacement() + "") {
		case "h" : return Math.abs(x0-x1);
		case "v" : return Math.abs(y0-y1);
		case "d" : return Math.abs(x0-x1);
		default : return -1;
		}
	}
   
}



