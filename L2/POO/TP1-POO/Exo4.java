import java.util.Scanner;

public class Exo4 {

    //1

    static int question(int maxTentatives){
        int faux = 0;
        Random rd = new Randow();
        int a = rd.newInt(10);
        int b = rd.newInt(10);
        System.out.println("Combien font " + a + "fois " + b + " ?");
        Scanner sc = new Scanner(System.in);
        int reponse = sc.nextInt();
        if(a*b != reponse && maxTentatives != 0){
            System.out.println("Fausse réponse, réésayez");
            faux++;
            question(maxTentatives -1);
        }
        if(a*b == reponse){
            System.out.println("Bravo !!");
            System.out.println("Nombre de tentatives : " + faux);
        }
        

    }

    public static int question2 (int maxtry) {
        Random rnd = new Random() ; 
        Scanner sc = new Scanner(System.in) ; 
        int a1 = (rnd.nextInt(10)) ;
        if (a1==0) a1+=1 ;  
        int a2 = (rnd.nextInt(10)); 
        if (a2==0) a2+=1 ; 
        int errors = -1 ; 
        int resp = 0 ; 
        System.out.println("que fait " + a1 + "*" + a2 + " ?");
        do {
            errors++ ; 
            resp = sc.nextInt() ;  
        } while (resp != a1*a2 && errors < maxtry-1);
        return errors ; 
    } 

    //2

    static int evaluation(int n){
        int score = n;
        while(n>0){
            score-=question2(1);
            n--;
        }
        return score;
    }
    
    public static void main(String[] args) {
		

    }
}
