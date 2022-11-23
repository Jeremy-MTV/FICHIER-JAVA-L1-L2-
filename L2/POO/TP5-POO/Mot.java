
public class Mot extends ChaineCar {
	private String mot;
	
	Mot(String a) {
		mot = a;
	}
	
	public int len() {
		return mot.length();
	}
	
	public String toString() {
		return mot;
	}

}
