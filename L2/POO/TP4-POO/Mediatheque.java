import java.util.ArrayList;

public class Mediatheque{
	ArrayList<Media> baseDeDonnees;

	Mediatheque(){
		this.baseDeDonnees = new ArrayList<Media>();
	}
	
	public void ajouter(Media doc) {
		
		
		for(int i=0; i<baseDeDonnees.size(); i++) {
			if(doc.plusPetit(baseDeDonnees.get(i))) {
				baseDeDonnees.add(i, doc);
			}
		}
		baseDeDonnees.add(doc);
	}
	
	public String toString() {
		String s = "";
		for(Media x : baseDeDonnees) {
			s += x.toString() + "\n";
		}
		return s;
	}
	
	public void afficherLivre () {
        for (Media x : baseDeDonnees) {
            if (x instanceof Livre) {
                System.out.println(x.toString());
            }
        }
    }

    public ArrayList<Media> recherche (Predicat p) {
        ArrayList<Media> res = new ArrayList<Media>() ;
        for (Media x : dataBase) {
            if (p.estVrai(x)) res.add(x) ; 
        }
        return res ; 
    }
	
	public static void main(String[] args) {
		
		    
		   
		   Media a = new Video("Vlog de Samy", "Moi", 25);
		   Media b = new Manga("Radiant", "Moi", 125, true);
		        
		        Mediatheque med1 = new Mediatheque() ;
		        med1.ajouter(b);
		        med1.ajouter(a);

		        System.out.println(med1.toString());
		      
		    
	


	}
}
