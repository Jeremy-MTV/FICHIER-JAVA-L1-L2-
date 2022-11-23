public class Noeud{
    private Noeud gauche;
    private Noeud droit;
    
    Noeud(Noeud g, Noeud d){
        this.gauche=g;
        this.droit=d;
    }

    Noeud(){
        this(null, null);
    }

    public Noeud getGauche(){
        return this.gauche;
    }

    public Noeud getDroit(){
        return this.droit;
    }

    public void setGauche(Noeud n){
        this.gauche = n;
    }

    public void setDroit(Noeud n){
        this.droit = n;
    }

    public boolean isEmpty(){
        if(this.gauche == null && this.droit == null){
            return true;
        }
        return false;
    }

    public void bourgeons(){
        if(this.isEmpty()){
            this.gauche = new Noeud();
            this.droit = new Noeud();
        }
        if(this.gauche != null){
            this.gauche.bourgeons();
        }
        if(this.droit != null){
            this.droit.bourgeons();
        }
    }

    public void affiche(int n){
        System.out.println(n);
    }

    public void elagage(){
        int e = 0;
        if(this.gauche != null){
            if(this.gauche.isEmpty()){
                this.gauche = null;
                e++;
            }else{
                this.gauche.elagage();
            }
        }
        if(this.droit != null){
            if(this.droit.isEmpty()){
                this.droit = null;
                e++;
            }else{
                this.droit.elagage();
            }
        }
        if(this.gauche == null && this.droit == null){
            affiche(e);
        }
        
    }

    public void croissance(){
        if(this.gauche != null){
            this.gauche = new Noeud(this.gauche, null);
            this.gauche.gauche.croissance();
        }
        if(this.droit != null){
            this.droit = new Noeud(null, this.droit);
            this.droit.droit.croissance();
        }
    }

    public void decroissance(){
        int p = 1;
        if(this.gauche != null){
            if(p % 2 != 0){
                this.gauche = new Noeud(this.gauche, null);
                // if(this.droit != null){
                //     this.droit = new Noeud(null, this.droit);
                // }
            }
        }

        if(this.droit != null){
            if(p % 2 != 0){
                this.droit = new Noeud(null, this.droit);
                // if(this.gauche != null){
                //     this.gauche = new Noeud(this.gauche, null);
                // }
            }

        }

        p++;
        this.decroissance();
    }

    public Noeud sousArbre(String chemin){
        if(chemin.equals("")){
            return this;
        }
        char premier = chemin.charAt(0);
        if(premier == 'g'){
            if(this.gauche != null){
                return null;
            }
            return this.gauche.sousArbre(chemin.substring(1));
        }
        if(premier == 'd'){
            if(this.droit != null){
                return null;
            }
            return this.droit.sousArbre(chemin.substring(1));
        }
        return null;
    }
}