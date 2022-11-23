public class Exo3 {
    
    static String Shift(String s){
        String n = "";
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
                if(c == 'a'){
                    c = 'y';
                    n = n + c;
                }
                else if(c == 'e'){
                    c = 'a';
                    n = n + c;
                }
                else if(c == 'i'){
                    c = 'e';
                    n = n + c;
                }
                else if(c == 'o'){
                    c = 'i';
                    n = n + c;
                }
                else if(c == 'u'){
                    c = 'o';
                    n = n + c;
                }
                else if(c == 'y'){
                    c = 'u';
                    n = n + c;
                }else{
                n = n + c;
                }
        }
        return n;
    }

    public static void main(String[] args) {
		String phrase = "Portez ce vieux whisky au juge blond qui fume";
        System.out.print(Shift(phrase));
    }
}
