
public class Image extends Media{
	int hauteur, largeur;
	
	Image(String titre, int hauteur, int largeur){
		super(titre);
		this.hauteur = hauteur;
		this.largeur = largeur;
	}
	
	public String toString() {
		return super.toString();
	}
	
	public int ordreMedia () {
        return 6 ; 
    }
}
