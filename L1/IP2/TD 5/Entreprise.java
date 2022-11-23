public class Entreprise{
    private String nom;
    private Cellule premier;

    Entreprise(){
        this(null, null);
    }

    void afficheEmplo(){
        if(this.nom != null && this.premier != null){
            this.premier.afficheEmplo();
        }
    }

    boolean appartient(String n){
        if(this.premier != null){
            this.premier.appartient(String n);
        }
        return false;
    }

    void ajout(Employe emp){
        if(this.premier != null){
            Cellule prem = this.premier;
            prem.premier.setE(emp);
            this.premier = prem;
        }
    }

    void demission(String n){
        if(this.premier != null){
            this.premier.demission(String n);
        }
    }
}