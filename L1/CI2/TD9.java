public class TD9{


    // Exercice 1 

    int PGCDrec(int a, int b){
        if(b==0) return a;
        return PGCDrec(b, a % b);
    }

    int PGCDiter(int a, int b){
        int tmp=0;
        while(b !=0){
            tmp = a;
            a = b;
            b = tmp%b;
        }
        return a;
    }


    //Exercice 2

    long FiboIter(int n){
        int tmp;
        int acc1 = 1;
        int acc2 = 1;
        while (n>1){
            tmp = acc1;
            acc1 = acc2;
            acc2 = tmp+acc2;
            n=n-1;
        }
        return acc2;
    }
    
        // arg 1 = a ; retval = n ; arg2 = b ; arg0 = c ; 
        int code(int c, int a, int b, int ric){
            int n;
            while(a != 0){
                n = b;
                if(a % 2 != 0){
                    c = c*c;
                    a = a/2;
                }
                b = c * b;
                c = c * c;
                a = (a - 1)/2;
            }
            return b;
        }

        

        

    public static void main(String[] args){
        System.out.println(PGCDrec(6, 2));
    }

}