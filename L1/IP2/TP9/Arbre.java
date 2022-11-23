public class Arbre {

    private Noeud sommet ; 

    Arbre (Noeud sommet) {
        this.sommet = sommet ; 
    }

    Arbre (int [] t) {
        if (t.length != 0) {
            sommet = new Noeud(t[t.length/2]) ; 
            sommet.creer2(t);
        }else{
            sommet = null ; 
        }
    }

    Arbre (Arbre a) {
        if (a.sommet == null) {
            sommet = null ;
        }else{
            sommet = new Noeud(a.sommet.getEtiquette()) ; 
            sommet.creer(a.sommet) ; 
        }
    }

    public void afficheInfixe() {
        if (sommet != null) {
            sommet.afficheInfixe() ; 
        }
    }

    public void affichePrefixe() {
        if (sommet != null) {
            sommet.affichePrefixe(); 
        }
    }

    public void afficheSuffixe() {
        if (sommet != null) {
            sommet.afficheSuffixe(); 
        }
    }

    public int nombreNoeud() {
        if (sommet != null) {
            return 1 + sommet.nbNoeud() ; 
        }
        return 0 ; 
    }

    public int somme () {
        if (sommet == null) return 0 ; 
        return sommet.somme() ; 
    }

    public int profondeur() {
        if (sommet == null) return 0 ; 
        return sommet.profondeur() ; 
    }

    public boolean chercher (int e) {
        if (sommet == null) return false ; 
        return sommet.chercher(e) ; 
    }

}
