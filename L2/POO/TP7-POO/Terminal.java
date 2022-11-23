import java.util.*;

public class Terminal {
    private final Dossier root ; 
    private Dossier head ; 

    public Terminal(Dossier root) {
        this.root = root ;
        head = root ; 
    }

    public void cat (String name) {
        if (name.isEmpty()) {
            Scanner sc = new Scanner(System.in) ; 
            String ch = sc.nextLine() ; 
            while (!ch.equals("")) {
                System.out.println(ch);
                ch = sc.nextLine() ; 
            }
            return ; 
        }
        Entree tmp = head.getEntree(name) ;
        if (tmp != null) {
            if (tmp.getElement() instanceof Dossier) {
                System.out.println(tmp.toString());
                return ; 
            }
            ((FichierTexte)tmp.getElement()).afficher();
            return ; 
        }
        System.out.println("Error , File doesn't exist please try again");
    }

    public void cd (String dirName) {
        if (dirName.isEmpty()) {
            head = root ; 
            return ; 
        }
        Entree tmp = head.getEntree(dirName) ; 
        if (tmp != null) {
            if (tmp.getElement() instanceof FichierTexte) {
                System.out.println("Error , DirectoryNameExpected please try again");
                return ; 
            }
            head = (Dossier)tmp.getElement() ; 
            return ; 
        }
        System.out.println("Error , Directory doesn't exist please try again");
    }

    public void ls (String name) {
        if (name.isEmpty()) {
            head.afficher();
            return ; 
        }
        Entree tmp = head.getEntree(name) ; 
        if (tmp != null) {
            if (tmp.getElement() instanceof FichierTexte) {
                System.out.println(tmp.getNom());
                return ; 
            }
            ((Dossier)tmp.getElement()).afficher();  
            return ; 
        }
        System.out.println("Error , Directory doesn't exist please try again");
    }

    public void mkdir (String dirName) {
        if (dirName.isEmpty()) {
            System.out.println("Error , IllegalArgumentExpection please try again");
            return ; 
        }
        Entree tmp = head.getEntree(dirName) ; 
        if (tmp != null ) {
            System.out.println("Error , Directory already exists please try again");
            return ; 
        }
        head.ajouter(new Dossier(null), dirName);
    }

    public void mv (String src , String dst ) {
        mvAux(src, dst, head);
    }
    
    private void mvAux (String src , String dst , Dossier head) {
        if (src.isEmpty() || dst.isEmpty() || src.equals(dst)) {
            System.out.println("Error , IllegalArgumentExeption please try again");
            return ; 
        }
        Entree source = head.getEntree(src) ; 
        if (source == null) {
            System.out.println("Error , " + src + " was not found please try again");
            return ; 
        }
        Entree destination = head.getEntree(dst) ; 
        if (destination != null) {
            if (destination.getElement() instanceof FichierTexte) {
                System.out.println("Error , Destination file already exists please try again");
                return ; 
            }
            this.head = (Dossier)destination.getElement() ; 
            mvAux(src, dst, this.head);
            this.head = head ; 
            return ; 
        }
        source.setNom(dst);
    }

    public void rm (String name) {
        if (name.isEmpty() || name.isEmpty()) {
            System.out.println("Error , IllegalArgumentExeption please try again");
            return ; 
        }
        Entree tmp = head.getEntree(name) ; 
        if (tmp == null) {
            System.out.println("Error , file or directory doesn't exist please try again");
            return ; 
        }
        tmp.supprimer();
    }

    public void ed (String fileName) {
        if (fileName.isEmpty() || fileName.isEmpty()) {
            System.out.println("Error , IllegalArgumentExeption please try again");
            return ; 
        }
        Entree tmp = head.getEntree(fileName) ; 
        if (tmp == null) {
            System.out.println("Error , file or directory doesn't exist please try again");
            return ; 
        }
        if (tmp.getElement() instanceof Dossier) {
            System.out.println("Error , fileNameExpection please try again");
            return ; 
        }
        ((FichierTexte)tmp.getElement()).editer(new Scanner(System.in), true);
    }

    public void cp (String src , String dst) {
        if (src.isEmpty() || dst.isEmpty() || src.equals(dst)) {
            System.out.println("Error , IllegalArgumentExeption please try again");
            return ; 
        }
        Entree source = head.getEntree(src) ; 
        if (source == null) {
            System.out.println("Error , " + src + " was not found please try again");
            return ; 
        }
        Entree destination = head.getEntree(dst) ;
        if (destination != null) {
            if (destination.getElement() instanceof FichierTexte) {
                System.out.println("Error , " + dst + " already exists pleasetry again");
                return ; 
            }
            ((Dossier)destination.getElement()).ajouter(source.getElement(), src);
            return ; 
        }
        head.ajouter(source.getElement(), dst);
    }
}
