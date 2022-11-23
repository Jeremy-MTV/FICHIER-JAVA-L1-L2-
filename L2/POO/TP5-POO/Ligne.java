import java.util.*;

public class Ligne extends ChaineCar {
	private LinkedList<ChaineCar> ligne;
	
	Ligne(){
		ligne = new LinkedList<ChaineCar>();
	}
	
	public int len() {
		int c = 0;
		for (int i = 0; i<ligne.size(); i++) {
			c+= ligne.get(i).len();
		}
		return c;
	}
	
	public String toString() {
		String s = "";
		for(int i = 0; i<ligne.size(); i++) {
			s = s + ligne.get(i).toString();
		}
		return s;
	}
	
	public boolean isEmpty() {
		return ligne.size() == 0;
	}
	
	public void addChaine(ChaineCar a) {
		ligne.add(a);
	}

	public void justifier (int length) {
        while (len() < length) {
            for (int i = 0; i < ligne.size(); i++) {
              if (ligne.get(i).getClass() == Espace.class) {
                ((Espace)ligne.get(i)).setSize(ligne.get(i).len()+1);
              }  
            }
        }
    }
}
