public class Pair {
    private Noeud n ; 
    private int k ; 

    Pair (Noeud n , int k) {
        this.n = n ; 
        this.k = k ; 
    }

    public Noeud getNoeud () {
        return this.n ; 
    }

    public int getdeepth() {
        return this.k ; 
    }
}
