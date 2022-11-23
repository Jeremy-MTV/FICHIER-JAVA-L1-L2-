
public class Manga extends Livre {
	boolean sensInverse;
	
	Manga(String titre, String auteur, int nbPages, boolean sensInverse){
		super(titre, auteur, nbPages);
		this.sensInverse = sensInverse;
	}
	
	public String toString() {
		return super.toString() + " | " + this.getAuteur() + ", " + Integer.toString(getnbpages()) + " pages" + "SensInverse" + ((sensInverse)?"oui":"non") ;;
	}
	

    
    public int ordreMedia () {
        return 5 ; 
    }
}

