public class Test{

    public static void main(String[] args){
        Noeud a = new Noeud();
        Noeud b = new Noeud();
        Noeud c = new Noeud(a, b);
        Noeud d = new Noeud();
        Noeud e = new Noeud(c, d);
        Arbre r = new Arbre(e);

        
        // r.elagage();
    }
}