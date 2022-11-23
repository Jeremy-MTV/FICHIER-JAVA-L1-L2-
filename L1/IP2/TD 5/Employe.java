public class Employe{
    private final String nom;
    private int salaire;

    Employe(String n, int s){
        this.nom = n;
        this.salaire = s;
    }

    Employe(){
        this(null, null);
    }

    String getNom(){
        return this.nom;
    }

    int getSalaire(){
        return this.salaire;
    }

    int setSalaire(int s){
        this.salaire = s;
    }

    int afficheS(){
        System.out.print(this.salaire);
    }

    String afficheN(){
        System.out.print(this.nom);
    }
}