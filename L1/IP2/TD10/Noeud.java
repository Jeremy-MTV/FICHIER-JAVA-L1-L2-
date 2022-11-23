public class Noeud{
    private Noeud gauche;
    private Noeud droit;

    Noeud(Noeud g, Noeud d){
        this.gauche = g;
        this.droit = d;
    }

    Noeud(){
        this(null,null);
    }

    void bourgeons(){
        if(this.gauche == null && this.droit == null){
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

    void elagage(){
        if(this.gauche != null){
           if(this.gauche.gauche == null && this.droit.droit == null){
               this.gauche = null;
           }else{
               this.gauche.elagage();
           }
        }
        if(this.droit != null){
            if(this.droit.gauche == null && this.droit.droit == null){
                this.droit = null;
            }else{
                this.droit.elagage();
            }
        }
        
    }

    void croissance(){
        if(this.gauche != null){
            this.gauche = new Noeud(this.gauche, null);
            this.gauche.gauche.croissance();
        }
        if(this.droit != null){
            this.droit = new Noeud(null, this.droit);
            this.droit.droit.croissance();
        }
    } 

    void decroissance(){
        
    }

}