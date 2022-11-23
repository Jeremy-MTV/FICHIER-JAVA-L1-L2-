public class Arbre {
    private Noeud root ; 
    
    public void affichelarge () {
        if (root != null) {
            root.affichelarge();
        }
    }

    Arbre (Noeud root) {
        this.root = root ; 
    } 

    public void affichepenche () {
        this.root.affiche(0);
    }

}
