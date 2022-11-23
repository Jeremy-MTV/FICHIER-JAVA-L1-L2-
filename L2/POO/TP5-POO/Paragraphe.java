import java.util.*;

public class Paragraphe extends ChaineCar {
	private LinkedList<Ligne> paragraphe;
	
	Paragraphe(){
		paragraphe = new LinkedList<Ligne>();
	}
	
	public boolean isEmpty() {
		return paragraphe.size() == 0;
	}
	
	public void addChaine(Ligne a) {
		paragraphe.add(a);
	}

	public void removeLast () {
        paragraphe.removeLast() ; 
    	paragraphe.getLast().removeLast();
}
