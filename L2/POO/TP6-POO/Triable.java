public interface Triable {
     void echange(int i, int j);
     boolean plusGrand(int i, int j);
     int taille();

     static void triBulles(Triable t){
        boolean changement = false;
        do{
            changement = false;
            for(int i = 0; i<t.taille()-1 ; i++){
                if(t.plusGrand(i, i+1)){
                    t.echange(i, i+1);
                    changement = true;
                }
            }
        }while(changement);
     }
}
