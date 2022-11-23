public class test {
    public static void main(String[] args) { 
        Dossier d1 = new Dossier(null) ; 
        Entree e1 = new Entree(d1, "root", null) ; 

        Dossier d2 = new Dossier(null) ;
        Dossier d3 = new Dossier(null) ; 
        Dossier d4 = new Dossier(null) ; 
        
        d1.ajouter(d2 , "root/dir1");
        d2.ajouter(d3 , "root/dir1/dir2");
        d3.ajouter(new FichierTexte() , "root/dir1/dir2/fic1");
        d3.ajouter(new FichierTexte() , "root/dir1/dir2/fic2");
        d3.ajouter(d4, "root/dir1/dir2/dir4");

        // Scanner sc = new Scanner(System.in) ; 
        // FichierTexte fic = new FichierTexte() ;
        // fic.editer(sc, true);

        //System.out.println(d3.getEntree("root/dir1/dir2/fic1"));

        // d1.afficher();
        // d2.afficher();
        // d3.afficher();

        Terminal sh = new Terminal(new Dossier(null)) ; 
        sh.ls("");
        sh.mkdir("dos1");
        sh.mkdir("dos2");
        sh.ls("");
        sh.cd("dos1");
        sh.mkdir("dos1-1");
        sh.mkdir("dos1-2");
        sh.mkdir("dos1-3");
        sh.cd("");
        sh.ls("dos1");
        sh.cp("dos1", "dos3");
        sh.ls("");
    }

}
