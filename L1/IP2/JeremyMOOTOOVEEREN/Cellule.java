
public class Cellule {
	private  int  valeur;
	private  Cellule  suivante;
	
	Cellule(int a, Cellule b){
		this.valeur = a;
		this.suivante = b;
	}
	
	Cellule(int a){
		this.valeur = a;
		this.suivante = null;
	}
	
	//Question 2 : ce n'est pas absurde car on peut affirmer que la Cellule contient une autre cellule qui est "suivante"
	
	int getV() {
		return this.valeur;
	}
	
	Cellule getC(){
		return this.suivante;
	}

	Cellule getNext() {
        return suivante ; 
    }
	
	public String description() {
		if(this.suivante == null) {
			return String.valueOf(this.valeur);
		}
		return this.valeur + ";" + this.suivante.description();
	}
	
	public int taille(int a) {
		if(this.suivante != null) {
			a++;
			return this.suivante.taille(a);
		}
		return a;
	}
	
	public int somme(int a) {
		if(this.suivante != null) {
			a += this.valeur;
			return this.suivante.somme(a);
		}
		return a + this.valeur;
	}

	public boolean egal (Cellule c1) {
        if (valeur != c1.valeur){
			return false ;
		}
        if (suivante == null && c1.suivante == null){
			return true ; 
		} 
        if (suivante != null && c1.suivante != null){
			return suivante.egal(c1.suivante) ; 
		} 
        return false ; 
    }

	public void ajouter_en_i (int i , int v) {
        if (i==0) suivante = new Cellule(v, suivante) ; 
        else if (suivante == null && i != 0) {
            suivante = new Cellule(v, suivante) ; 
        } else {
            suivante.ajouter_en_i(i-1, v);
        }
    }

	public boolean supprimer_en_i (int i) {
        if (i==0) {
            suivante = suivante.suivante ; 
            return true ; 
        }
        return suivante.supprimer_en_i(i-1) ; 
    }

	public int supprimer_k_premieres_occ (int k , int v) {
        int a = 0 ; 
        while ( suivante != null && suivante.valeur == v && k!= 0) {
            suivante = suivante.suivante ; 
            k-- ; 
            a++ ; 
        }
        if (suivante == null ){
            return a ; 
        }
        return (k==0)? a : a + suivante.supprimer_k_premieres_occ(k, v) ;
    }

    public int taille2 () {
        if (suivante == null) return 1 ; 
        return 1 + suivante.taillev2() ; 
    }
	
	}


