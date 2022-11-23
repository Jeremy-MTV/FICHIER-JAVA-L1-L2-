import java.util.Scanner;

public class FichierTexte extends Element implements Affichable, Editable {

    private String contenu;
    
    public FichierTexte(String contenu) {
        this.contenu = contenu;
    }

    public FichierTexte() {
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }


    @Override
    public String toString() {
        return "FichierTexte []";
    }

    @Override
    public String getType() {
        // TODO Auto-generated method stub
        return "text";
    }

    @Override
    public void afficher() {
        // TODO Auto-generated method stub
        System.out.println(contenu);
    }

    @Override
    public void editer(Scanner sc, boolean echo) {
        // TODO Auto-generated method stub
        String modif = sc.nextLine() ; 
        String acc = "" ; 
        while (!modif.equals(".")) {
            acc += modif + "\n" ; 
            modif = sc.nextLine() ; 
        }
        if (echo) System.out.println(acc);
        contenu = acc ;         
    }

    

   
    
}
