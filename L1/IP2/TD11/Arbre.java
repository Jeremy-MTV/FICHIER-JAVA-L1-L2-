public class  Arbre{
    private Noeud racine;

    public Arbre(){
        this.racine=null;
    }
    
    public Arbre(Noeud n){
        this.racine = n;
    }
    
    public void bourgeons() {
        if(this.racine != null){
            this.racine.bourgeons();
        }
    }

    public void elagage(){
        if(this.racine == null){
            return;
        }
        if(this.racine.getGauche() == null && this.racine.getDroit() == null){
            this.racine = null;
        }else{
            this.racine.elagage();
        }
    }

    public void croissance(){
        if(this.racine != null){
            this.racine.croissance();
        }
    }

    public void decroissance(){
        if(this.racine == null){
            return;
        }
        this.racine.decroissance();
    }

    public Arbre sousArbre(String chemin){
        if(this.racine == null){
            return null;
        }
        return new Arbre(this.racine.sousArbre(chemin));

    }
}