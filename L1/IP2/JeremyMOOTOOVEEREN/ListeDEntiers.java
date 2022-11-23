
public class ListeDEntiers {
	private Cellule premier;
	
	ListeDEntiers(){
		this.premier = null;
	}
	
	void add(int x){
		Cellule a = new Cellule(x, this.premier);
		this.premier = a;		
	}

	String description(){
		if(this.premier == null) {
			return "la liste est vide";
		} else {
			return "(" + this.premier.description() + ")";
		}
	}

	public boolean egal (ListeDEntiers l1) {
        if (premier != null && l1.premier != null){
			return premier.egal(l1.premier) ;
		} 
        if (premier == null && l1.premier == null){
			return true ;
		}  
        return false ; 
    }
	
	public boolean supprimer (int i) {
        if (i<0 || i>=taille() || premier == null) return false ; 
        if (i==0) {
        	premier = null ; 
            return true ; 
        }
        return premier.supprimer_en_i(i-1) ;  
    }

	public int supprimer_k_premieres_occ (int k , int v) {
        if (premier == null || k<0) return 0 ; 
        int a = 0 ; 
        while (premier != null && premier.getV() == v && k!=0) {
            k-- ; 
            a++ ; 
            premier = premier.getNext() ; 
        }  
        if(premier == null || k==0) {
            return a ; 
        }
        return a+premier.supprimer_k_premieres_occ(k,v) ; 
    }

	
    public ListeDEntiers obtenir_sous_liste_inf_k (int k) {
        if (premier == null) return null ; 
        ListeDEntiers N = new ListeDEntiers() ; 
        return premier.obtenir_sous_liste_inf_k(N , k) ; 
    }
	
}

