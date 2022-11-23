public class DMEA5 {
  
    public static void aprint(int[] t){
        for (int i=0; i<t.length; i+=1) {
            if(i==0){
            System.out.print("["+t[i]+", ");
          }else if (i==t.length-1) {
            System.out.print(t[i]+"]");
          }else{
            System.out.print(t[i]+", ");
          }
        }
        System.out.println();
      }
    
      private static boolean PointFixe(int [] t){
        int indice=t.length/2;
        System.out.print(indice + " - ");
        if (t[indice]<=indice) {
          System.out.println("droite");
          for ( int i = indice ;i<t.length ; i+=1) {
            if(t[i]==i){
              return true;
            }
          }
        }else{
          System.out.println("gauche");
          for ( int i = 0 ;i<indice ; i+=1) {
            if(t[i]==i){
              return true;
            }
          }
        }
        return false;
      }

      public static void main(String[] args) {
        int[] t = new int[]{-1,0,1,3,4,8};
        int[] t2 = new int[]{-4,-3,-1,0,4,5,6,9};
        int[] t3 = new int[]{-15,-13,-12 , -1,26,9,10};
        System.out.println("t : ");
        aprint(t);
        System.out.println();
        System.out.println(PointFixe(t));
        System.out.println();
        System.out.println("t2 : ");
        aprint(t2);
        System.out.println();
        System.out.println(PointFixe(t2));
        System.out.println();
        System.out.println("t3 : ");
        aprint(t3);
        System.out.println();
        System.out.println(PointFixe(t3));
       
    }


    
     
}
