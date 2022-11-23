public class TriBinaire implements Triable {
    private String [] tab ;

    TriBinaire (String [] tab) {
        this.tab = new String [tab.length] ;
        for (int i = 0; i < tab.length; i++) {
            this.tab[i] = tab[i] ;
        }
    }

    public int taille(){return tab.length;}

    public boolean plusGrand(int i, int j){
        return Integer.valueOf(tab[i]) > Integer.valueOf(tab[j]);
    }

    public void echange(int i, int j) {
        String tmp = tab[i] ;
        tab[i] = tab[j] ;
        tab[j] = tmp ;
        }
        
        public String toString() {
        String acc = "" ;
        for(String x : tab) acc += x + " " ;
        return acc + "\n" ;
        }
}
