import java.io.*;
import java.util.*;

public class Arbre{

    private Noeud racine;


    public Noeud getRacine() {
        return racine;
    }


    public Arbre(String path) throws FileNotFoundException  {
        if(path == null) throw new FileNotFoundException(path);
        racine = new Noeud(new File(path));
    }
    

    public void afficher(){
        int deepth = 0; 
        String espace = " ";
        System.out.println(racine.getNom() + " [" + racine.getTaille() + "]");
        deepth++;
        if(racine.getFils() != null){
            for(Noeud a : racine.getFils()){
                System.out.println(espace + a.getNom() + " [" + a.getTaille() + "]");
                if(a.isRepertoire()){
                    deepth=3;
                    String repeated = espace.repeat(deepth);
                    for(Noeud x : a.getFils()){
                        System.out.println(repeated + x.getNom() + " [" + x.getTaille() + "]");
                    }
                }
            }
        }

    }

    public void traverser(String extension){ //Le string de l'extension devra avoir le point de celui-ci, exemple = ".png"
        
        System.out.println("Les fichiers dont l'extension est " + extension + " sont : ");
        System.out.println();

        for(Noeud x : racine.getFils()){
            
                String acc = "";
                String nom = x.getNom();
        
                if(x.isRepertoire()){ //On teste si le noeud est un dossier
                    for(Noeud a : x.getFils()){
                        String acc1 = "";
                        String nom1 = a.getNom();
                        for(int i=0; i<nom1.length(); i++){
                            if(nom1.charAt(i) == '.'){
                                for(int j = i; j<nom1.length(); j++){
                                    acc1 += nom1.charAt(j); 
                                }
                            }
                        }
                        if(acc1.equals(extension)){
                            System.out.println(a.getNom() + " [" + a.getTaille() + "]");
                        }
                    }
                }else{ //Si c'est juste un fichier
                    for(int i=0; i<nom.length(); i++){
                        if(nom.charAt(i) == '.'){
                            for(int j = i; j<x.getNom().length(); j++){
                                acc += nom.charAt(j); 
                            }
                        }
                    }
                    if(acc.equals(extension)){
                        System.out.println(x.getNom() + " [" + x.getTaille() + "]");
                    }
                }
        }
        
    }

    public void supprimer(String extension) throws UnableToDeleteFileException{
        for(Noeud x : racine.getFils()){
            
            String acc = "";
            String nom = x.getNom();
    
            if(x.isRepertoire()){ //On teste si le noeud est un dossier
                for(Noeud a : x.getFils()){
                    String acc1 = "";
                    String nom1 = a.getNom();
                    for(int i=0; i<nom1.length(); i++){
                        if(nom1.charAt(i) == '.'){
                            for(int j = i; j<a.getNom().length(); j++){
                                acc1 += nom1.charAt(j); 
                            }
                        }
                    }
                    if(acc1.equals(extension)){
                        StringTransformation remove = (String s) -> s= "";
                        if(a.getFile().canWrite()){
                            String nameAcc = a.getNom();
                            a.setNom(remove.transf(a.getNom())); //ici, au lieu de le supprimer réellement je ne fais que le renommer afin d'avoir une réponse visuel. 
                            System.out.println(a.getNom() + "Fichier Supprimé" + "  (" + nameAcc + ")");
                        }else{
                            throw new UnableToDeleteFileException("Impossible de supprimer le fichier");
                        }
                    }
                }
            }else{ //Si c'est juste un fichier
                for(int i=0; i<nom.length(); i++){
                    if(nom.charAt(i) == '.'){
                        for(int j = i; j<x.getNom().length(); j++){
                            acc += nom.charAt(j); 
                        }
                    }
                }
                if(acc.equals(extension)){
                    StringTransformation remove = (String s) -> s= "";
                    if(x.getFile().canWrite()){
                        String nameAcc1 = x.getNom();
                        x.setNom(remove.transf(x.getNom())); //pareil ici
                        System.out.println(x.getNom() + "Fichier supprimé" + "  (" + nameAcc1 + ")");
                    }else{
                        throw new UnableToDeleteFileException("Impossible de supprimer le fichier");
                    }
                }
            }
    }
    }


    public class Noeud{ //Noeud de l'arborescence, donc un fichier

        private String nom;
        private int taille;
        private boolean repertoire;
        private ArrayList<Noeud> fils;
        private File file; //J'ai rajouté un attribut file pour la fonction supprimé afin de pouvoir verifier si le fichier en question pouvait être supprimé

        /**
         * @param f
         * @throws FileNotFoundException
         */

        Noeud(File f) throws FileNotFoundException{
            if(!f.exists()) throw new FileNotFoundException();
            nom = f.getName();
            if(f.isDirectory()){ //si c'est un dossier on initialise
                repertoire = true;
                taille = f.listFiles().length;
                file = f;
                fils = new ArrayList<Noeud>();
                for(File x : f.listFiles()){
                    fils.add(new Noeud(x));
                }
                return;
            }
            repertoire = false;
            taille = (int) f.length();
            fils = null;
            file = f;
        }

        public void map(StringTransformation t){ //map change le nom et affiche les fichiers modifiés
            for(Noeud x : this.fils){
                if(x.isRepertoire()){
                    for(Noeud a : x.getFils()){
                        a.setNom(t.transf(a.getNom()));
                        System.out.println(a.getNom() + " [" + a.getTaille() + "]");
                    }
                }else{
                x.setNom(t.transf(x.getNom()));
                System.out.println(x.getNom() + " [" + x.getTaille() + "]");
                }
            }
        }

        public String getNom() {
            return nom;
        }

        public File getFile(){
            return file;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }


        public int getTaille() {
            return taille;
        }


        public void setTaille(int taille) {
            this.taille = taille;
        }


        public boolean isRepertoire() {
            return repertoire;
        }


        public void setRepertoire(boolean repertoire) {
            this.repertoire = repertoire;
        }


        public ArrayList<Noeud> getFils() {
            return fils;
        }


        public void setFils(ArrayList<Noeud> fils) {
            this.fils = fils;
        }

        

    }
}