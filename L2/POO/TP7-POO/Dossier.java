import java.util.ArrayList;
import java.util.List;


public class Dossier  implements Affichable {
    private List<Entree> filles ;
    private Entree parent ; 

    Dossier (Entree parent) {
        this.parent = parent ; 
        filles = new ArrayList<Entree>() ; 
        if(parent != null) addEntree(parent);
    }

 

    @Override
    public void afficher() {
        if (parent != null ) System.out.println("Entree Parent : " + parent.toString());
        for ( Entree x : filles) {
            if (x.getElement() instanceof Dossier) {
                if ((Dossier)x.getElement() == this) {
                    System.out.println("Entree Container : " + x.toString());
                }else {
                    System.out.println("Entree Fille : " + x.toString());
                }
                continue ; 
            }    
            System.out.print("Entree Fille : " + x.toString() + " ");
            ((FichierTexte)x.getElement()).afficher();
        }
        System.out.println();        
    }



    public List<Entree> getFilles() {
        return filles;
    }



    public void setFilles(List<Entree> filles) {
        this.filles = filles;
    }



    public Entree getParent() {
        return parent;
    }

    public Entree getEntree (String nom) {
        for (Entree x : filles) {
            if (x.getNom().equals(nom)) return x ; 
        }
        return null ; 
    }

    public Entree getEntree (String nom , boolean cree) {
        Entree tmp = getEntree(nom) ; 
        if (tmp == null) {
            tmp = new Entree(null, nom, this) ;
            addEntree(tmp);
        }
        return tmp ; 
    }

    public void addEntree (Entree e) {
        filles.add(e) ; 
    }
    
    public void ajouter (Element e , String nom) {
        Entree tmp = new Entree(e, nom, this) ;
        addEntree(tmp);
    }

    public String getType() {
        return "dossier" ; 
    }

    public void supprimer (Entree e) {
        filles.remove(e) ; 
    }

    
    public void setParent(Entree parent) {
        this.parent = parent;
    }



    public void ajouter(Dossier dossier, String dirName) {
    }

}
