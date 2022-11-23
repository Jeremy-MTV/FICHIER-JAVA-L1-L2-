public class Noeud{
    private int etiquette;
    private Noeud gauche;
    private Noeud droit;

    public Noeud(int etiquette, Noeud g, Noeud d){
        this.etiquette = etiquette;
        this.gauche = g;
        this.droit = d;
    }

    public static Noeud test(){
        Noeud[] n = new Noeud[10];
        n[4] = new Noeud(4);
        n[1] = new Noeud(1, n[4], null);
        n[0] = new Noeud(0);
        n[7] = new Noeud(7, n[0], n[1]);
        n[8] = new Noeud(8);
        n[6] = new Noeud(6, null, n[8]);
        n[2] = new Noeud(2);
        n[9] = new Noeud(9, n[2], n[6]);
        n[5] = new Noeud(5, n[9], null);
        n[3] = new Noeud(3, n[5], n[7]);
        return n[3];

    }

    public void espace(int n){
        for(int i=0; i<n; i++){
            System.out.print(" ");
        }
    }

    public void affiche(int p){
        if(p == 0) return ;
        if(this.gauche != null){
            System.out.print(this.gauche.etiquette);
            this.affiche(p-1);
        }
        System.out.println("");  
        if(this.droit != null){
            System.out.print(this.droit.etiquette);
            this.affiche(p-1);
        }
        
    }

    public void affichepenché(){
        if(this.gauche != null){
            this.gauche.affiche()
        }
    }

    public Noeud getG(){
        return this.gauche;
    }
    public Noeud getD(){
        return this.droit;
    }
    public int getEtiquette(){
        return this.etiquette;
    }
     
    public Noeud(int etiquette){
        this(etiquette, null, null);
    }

    public void afficheInfixe(){
       if(this.gauche != null){
           this.gauche.afficheInfixe();
       }
       System.out.print(this.etiquette + "");
       if(this.droit != null){
           this.droit.afficheInfixe();
       }
    }

    public void affichePrefixe(){
        System.out.print(this.etiquette + "");
        if(this.gauche != null){
            this.gauche.affichePrefixe();
        }
        if(this.droit != null){
            this.droit.affichePrefixe();
        }
    }

    public void afficheSuffixe(){
        if(this.gauche != null){
            this.gauche.afficheSuffixe();
        }
        if(this.droit != null){
            this.droit.afficheSuffixe();
        }
        System.out.print(this.etiquette + "");
    }

    
    public int nbDeNoeuds(){
        int a = 0;
        if(this.gauche != null){
            a = 1 + this.gauche.nbDeNoeuds();
        }
        if(this.droit != null){
            a += 1 + this.droit.nbDeNoeuds();
        }
        return a;
    }

    public int somme(){
        int a = 0;
        if(this.gauche != null){
            a = a + this.gauche.somme();
        }
        if(this.droit != null){
            a = a + this.droit.somme();
        }
        return a + this.etiquette;
    }

    public int profondeur(){
        int a = 1;
        int b = 1;
        if(this.gauche != null){
            
            a = a + this.gauche.profondeur();
        }
        if(this.droit != null){
            
            a = a + this.droit.profondeur();
        }
        return a;

    }

    public boolean recherche(int e){
        if(this.gauche != null){
            if(this.gauche.etiquette == e){
                return true;
            }
        }

        if(this.droit != null){
            if(this.droit.etiquette == e){
                return true;
            }
        }
        return false;
    }
}