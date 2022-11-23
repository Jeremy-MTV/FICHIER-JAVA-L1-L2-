
public class Exo2 {

	//1
	public static void affiche(int t[]){
		for(int i:t) {
			System.out.print(t[i]);
		}
	}
	
	//2
	static int[] multiplication(int t1[], int t2[]) {
		int a = Math.max(t1.length, t2.length);
		int t3[] = new int[a];
		for(int i=0; i<a; i++){
			if(t1.length < i) {
				t3[i] = t2[i] ;
			}if(t2.length < i){
				t3[i] = t1[i];
			}else {
			t3[i] = t1[i]*t2[i];
			}
		}
		return t3;
	}
			
	//3 
	public static String valueOf(int a) {
		return String.valueOf(a);
	
	}
	public static  getNumericValue(char c) {
		return Character.getNumericValue(c);
	}
		
	//4
	
	public static int[] split(int t[]) {
		int[] b;
		b.length = t.length;
		for(int i=0; i<t.length; i++){
			if(t[i].length >= 2 ){
				String a = String.valueOf(t[i]);
				for(int d:a.length){
					b[d] = getNumericValue(a.charAt(i));
				}
			}else{
				b[i] = t[i];
			}
		}
	}
	
	
	public static void main(String[] args) {
		int tab[] = {1,3,5,4,7}; 
		int i = 12;
		char d = 'a';
		System.out.print(valueOf(i));
		System.out.print(getNumericValue(d));
		
	}
}
