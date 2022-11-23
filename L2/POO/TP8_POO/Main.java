import java.io.*;

public class Main {
    

    public static void main(String[] args) throws FileNotFoundException, UnableToDeleteFileException{
        Arbre a = new Arbre("C:/Users/ronny/Desktop/photo vidéo Euro");
        StringTransformation addBlah = (String s) -> s + ".blah";
        //a.getRacine().map(addBlah);
        //a.traverser(".jpg");
        //a.afficher();
        a.supprimer(".jpg");
    }
}
