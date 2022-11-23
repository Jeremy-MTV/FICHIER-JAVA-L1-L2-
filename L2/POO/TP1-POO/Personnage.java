import java.util.Random;
import java.util.Scanner;

public class Personnage {
    private String nom ; 
    private Information genuine ; 
    private Information now ; 
    
    Personnage (String nom , Information info ) {
        this.nom = nom ; 
        this.genuine = info ; 
        this.now = info ; 
    }
    
    public String toString () {
        return "Je suis " + nom +
                ".Et mes stats d'origines sont :" +genuine.toString() +
                " Et mes stats actuelles sont " + now.toString() ;  
    }

    public boolean isAlive () {
        return this.now.getVitality() > 0 ; 
    }

    public void rebirth() {
        now = new Information(genuine) ; 
    }

    public void attaque (Personnage def) {
        Random rn = new Random() ; 
        System.out.println(nom + " Lance une attaque !");
        int n = rn.nextInt(Math.max(1, now.getForce() - def.now.getForce())) ; 
        if (n==0) n=1 ; 
        if (def.now.getAgility() < now.getAgility()) {
            def.now.editVitality((def.now.getVitality()-n <0)?0:def.now.getVitality()-n);
            System.out.println(def.nom + " a pas pu esquiver, il perd " + n + "pv !");
            return ; 
        }
        def.now.editVitality((def.now.getVitality()-n/2 <0)?0:def.now.getVitality()-n/2);
        def.now.editAgility(def.now.getAgility()-1);
        System.out.println(def.nom + " a pu esquiver, il perd " + n/2 + "pv !");
    }

    public void lutteRec (Personnage p2) { 
        attaque(p2);
        if (!p2.isAlive()) {
            System.out.println(nom + " Est le vainquer de ce combat !!!");
            return ;
        }
        p2.lutteRec(this);
    }

    public void lutteIter (Personnage p2) {
        while (isAlive()) {
            attaque(p2);
            if (!p2.isAlive()) break ; 
            p2.attaque(this);
        }
        if(!p2.isAlive()) {
            System.out.println(nom + " Est le vainquer de ce combat !!!");
            return ;
        }
        System.out.println(p2.nom + " Est le vainquer de ce combat !!!");
    }
}
