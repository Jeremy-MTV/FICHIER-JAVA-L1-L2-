
public class Espace extends ChaineCar {
	
	private int longueurMax;

	// public int len() {
	// 	return 1;
	// }
	
	// public String toString() {
	// 	return " ";
	// }

	Espace (int size) {
        this.longueurMax = size ; 
    }

    public void setSize (int size) {
        this.longueurMax = size ; 
    }

    private String getKSpaces (int t) {
        char [] t = new char[t] ;
        Arrays.fill(t, ' ');
        return new String(t) ; 
    }
    
    @Override
    public int len () {
        return longueurMax ; 
    }

    @Override
    public String toString () {
        return getKSpaces(longueurMax) ; 
    }

}
