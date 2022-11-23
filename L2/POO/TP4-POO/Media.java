
public class Media {
	private String titre;
	private final int nbEnregistrement;
	private static int num=0;
	
	Media(String titre){
		this.titre = titre;
		nbEnregistrement = num++;
	}
	
	public void setTitre(String t) {
		this.titre = t;
	}
	
	public int getNumero() {
		return this.nbEnregistrement;
	}
	
	public String toString() {
		return Integer.toString(nbEnregistrement) + " - " + titre; 
	}
	
	public boolean plusPetit(Media doc) {
		return nbEnregistrement < doc.getNumero();
	}
	public int ordreMedia () {
        return 0 ; 
    }

    public boolean plusPetit (Media doc) {
        if (ordreMedia() > doc.ordreMedia()) return false ;
        if (ordreMedia() < doc.ordreMedia()) return true ; 
        return num < doc.getNum() ; 
}
