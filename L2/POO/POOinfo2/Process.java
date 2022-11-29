package L2.POO.POOinfo2;

public class Process extends Reseau{
    
    public Process[] etat = new Process[population];

    public Process(int n) {
        super(n);
        etat[n] = new Process(n);

        for(int i=0; i<population-1; i++){
            if(i != n){
                etat[i] = new Process(i+1);
            }
        }
    }

    @Override
    public int[][] messageProco(int index) {
        // TODO Auto-generated method stub
        return null;
    }

}
