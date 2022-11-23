class Personne {
    private final String prenom , nomDeFamille ;
    private Personne mere , pere ;


    Personne ( String prenom , String nomDeFamille ) {
        this.prenom = prenom;
        this.nomDeFamille =nomDeFamille;
    }

    Personne ( String prenom , String nomDeFamille , Personne pere , Personne mere ) {
        this.prenom = prenom;
        this.nomDeFamille = nomDeFamille;
        this.pere = pere;
        this.mere = mere;

     }

     boolean estFrereOuSoeur(Personne P){
         if(this.mere != null && this.pere != null){
            if(p.pere == this.pere && p.mere == this.mere){
                return true;
            }
         }
         if(this.pere != null && p.pere  != null){
             if(this.pere == p.pere){
                 return true;
             }
         }
         if(this.mere != null && p.mere != null){
             if(this.mere == p.mere){
                 return true;
             }
         }
         return false;
     }

    boolean estCousinGermain(Personne p){
        if(this.pere != null && p.pere != null){
            if(this.pere.pere == p.pere.pere){
                return true;
            }
        }
        if(this.mere != null && p.mere != null){
            if(this.mere.mere == p.mere.mere){
                return true;
            }
        }
        return false;
    }

    int nbAscendants(){
        int cpt = 0;
        if(this.pere != null){
            cpt++;
            this.pere.nbAscendants();
        }
        if(this.mere != null){
            cpt++;
            this.mere.nbAscendants();
        }
        return cpt;
    }

    boolean possedeCommeAscendant(Personne p){
        if(this)
    }
     

}

