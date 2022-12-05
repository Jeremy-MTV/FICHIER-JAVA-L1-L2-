package L2.POO.POOinfo2_TDnote;

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

    // public Process f (Stepper s) {
    //     return s.step(new Process(5), "NTM") ; 
    // }

    @Override
    public int[][] messageProco(int index) {
        // TODO Auto-generated method stub
        return null;
    }

}
