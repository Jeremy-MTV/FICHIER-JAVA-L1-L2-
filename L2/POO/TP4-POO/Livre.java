
public class Livre extends Media {
	private String auteur;
	private int nbPages;
	
	Livre(String titre, String auteur, int nbPages) {
		super(titre);
		this.auteur = auteur;
		this.nbPages = nbPages;
	}
	
	public String getAuteur() {
		return auteur;
	}
	int getnbpages() {
		return this.nbPages;
	}
	public String toString() {
		return super.toString() + " | " + this.auteur + ", " + Integer.toString(nbPages) + " pages";
	}
	
	public boolean plusPetit (Media doc) { 
        if (doc instanceof Livre) return super.plusPetit(doc) ;
        return false ; 
    }
    
    public int ordreMedia () {
        return 1 ;
    }
}
