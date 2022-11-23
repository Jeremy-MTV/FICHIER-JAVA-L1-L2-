public class Cellule{
    private Employe emp;
    private Cellule suivant;

    Cellule(Employe emp){
        this.emp = emp;
        this.suivant = null;
    }

    Employe setE(Employe E){
        this.emp = E;
    }
    Cellule(Employe emp, Cellule suiv){
        this.emp = emp;
        this.suivant = suiv;
    }
    
    void afficheEmplo(){
        if(this.emp != null){
            this.emp.afficheN;
            this.emp.afficheS;
        }
        this.suivant.afficheEmplo();
    }

    boolean appartient(String n){
        if(this.emp != null && this.emp.getNom != null){
            if(this.emp.getNom == n){
                return true;
            }
            this.suivant.appartient();
        }else{
            this.suivant.appartient();
        }
        return false; 
    }

    void demission(String n){
        if(this.emp != null){
            if(this.emp.getNom() == n){
                this.emp = null;
            }
            this.suivant.demission(String n);
        }
    }

    boolean augmente(String nom, int montant){
        if(appartient(nom)){
            if(montant > 0){
                if(this.emp != null){
                    if(this.emp.getNom == n){
                        this.emp.setSalaire(montant);
                    }
                    this.suivant.augmente(String nom, int montant);
                }else{
                    return false;
                }            
            }else{
                return false;
            }
        }else{
            return false;
        }
        return true;
    }
}