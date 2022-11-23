public class TabEntiersTriable implements Triable {
    
    private int[] tab;

    TabEntiersTriable(int[] tab){
        this.tab = new int[tab.length];
        for(int i = 0; i<tab.length; i++){
            this.tab[i] = tab[i];
        }
    }

    public int taille(){
        return tab.length;
    }

    public boolean plusGrand(int i, int j){
        return tab[i]>tab[j];
    }

    public void echange(int i, int j){
        tab[i] += tab[j];
        tab[j] = tab[i] - tab[j];
        tab[i] -= tab[j];
    }

    public String toString(){
        String accumulateur = "";
        for (int x : tab) accumulateur += x + " ";
        return accumulateur + "\n";
    }
}
