public class BandeDessinee extends Livre {
	String dessinateur;
	
	BandeDessinee(String titre, String dessinateur, int nbPages){
		super(titre, dessinateur, nbPages);
		
	}
	
	public String toString() {
		return super.toString() + " | " + this.dessinateur + ", " + Integer.toString(getnbpages()) + " pages";
	}
	
	public int ordreMedia () {
        return 4 ; 
    }
}
