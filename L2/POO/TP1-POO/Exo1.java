
public class Exo1 {

	//1 - La méthode Main donne une sortie du même type que la signature de départ.(par exemple void)
	
	//2
	static int nbarg(String[] a) {
		return a.length;
	}
	
	//3 
	
	static int StringCount(String b) {
		int a = b.length();
		return a;
	}
	
	//4 - La méthode Hypot est méthode statique de Math.
	
	public static void main(String[] args) {
		//System.out.print(nbarg(args));
		String a = "blavfbgfgfdgbla";
		System.out.print(StringCount(a));
	}
} 
