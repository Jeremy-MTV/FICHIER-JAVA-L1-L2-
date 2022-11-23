public class Arbre{
    private Noeud sommet;

    public Arbre(Noeud sommet){
        this.sommet = sommet;
    }

    public Arbre(){
        this(null);
    }

    public Arbre(Arbre a){
        this.sommet = a.sommet;
        this.etiquette = a.getEtiquette();
    }

    public void affiche(int p){
        if(this.sommet == null) System.out.print("");
        this.sommet.affiche(p-1);
    }
    public void afficheInfixe(){
        if(this.sommet != null){
            this.sommet.afficheInfixe();
        }
    }

    public void affichePrefixe(){
        if(this.sommet != null){
            this.sommet.affichePrefixe();
        }
    }

    public void afficheSuffixe(){
        if(this.sommet != null)  this.sommet.afficheSuffixe();
    }

    public int nbDeNoeuds(){
        if (sommet != null) {
            return 1 + sommet.nbDeNoeuds() ; 
        }
        return 0 ; 
    }

    public int somme(){
        if(this.sommet != null){
            return this.sommet.somme();
        }
        return 0;
    }

    public int profondeur(){
        if(this.sommet == null) return 0;
        return this.sommet.profondeur();
    }

    public boolean recherche(int e){
        if(this.sommet == null){
            return false;
        }
        return this.sommet.recherche(e);
    }
}