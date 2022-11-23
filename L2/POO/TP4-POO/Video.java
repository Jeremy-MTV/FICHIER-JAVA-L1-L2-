public class Video extends Media{
	private String auteur;
	private int duree;
	
	Video(String titre, String auteur, int duree){
		super(titre);
		this.auteur = auteur;
		this.duree = duree;
	}
	
	public String toString() {
		return super.toString() + " | " + this.auteur + ", " + Integer.toString(duree) + " minutes";
	}
	
	public int ordreMedia () {
        return 2 ; 
    }
}
