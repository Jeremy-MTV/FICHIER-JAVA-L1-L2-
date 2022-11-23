public class Arbre{
    private Noeud racine;
    Arbre(){this.racine=null;}
    Arbre(Noeud n){
        this.racine=n;
    }

    void bourgeons(){
        if(this.racine == null){
            return;
        }
        this.racine.bourgeons();
    }

    void croissance(){
        if(this.racine == null){
            return;
        }
        this.racine.croissance();
    }
}