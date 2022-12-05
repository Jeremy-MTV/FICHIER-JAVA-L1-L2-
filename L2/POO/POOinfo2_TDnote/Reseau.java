package L2.POO.POOinfo2_TDnote;

public abstract class Reseau {
    protected final int population;
    protected final Process[] processus;

    public Reseau(int n){
        population = n;
        processus = new Process[population];
        for(int i=0; i<population; i++){
            processus[i] = new Process(i);
        }
    }

   public abstract int[][] messageProco(int index);

}
