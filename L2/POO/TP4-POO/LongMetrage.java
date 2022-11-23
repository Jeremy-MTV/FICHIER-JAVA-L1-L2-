public class LongMetrage extends Video {
	String Realisateur;
	int duree;
	
	LongMetrage(String titre, String Realisateur, int duree){
		super(titre, Realisateur, duree);
	}
	
	public String toString() {
		return super.toString() + " | " + this.Realisateur + ", " + Integer.toString(duree) + " minutes";
	}
	
	public int ordreMedia () {
        return 3 ; 
    }
}
