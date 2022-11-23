import java.util.*;
import java.io.File;

public class Formateur {

	private LinkedList<Paragraphe> texte;
	Scanner sc;

	// fic est le nom du fichier,
	// chemin compris s’il n’est pas dans le même répertoire
	public Formateur(String filename) {
		sc = null;
		try {
			sc = new Scanner(new File(filename));
		} catch (Exception e) {
			System.out.println("Erreur lors d’ouverture fichier:");
			e.printStackTrace();
			System.exit(1);
		}
		texte = new LinkedList<Paragraphe>();
	}

	// private void readParagraphe() {
	// 	Iterator<Ligne> iterator = this.paragraphe.iterator();
	// 	while(iterator.hasNext()){
	// 		System.out.print(iterator.next());
	// 	}
	// }

	// public Paragraphe read() {
	// 	Iterator<Paragraphe> iterator1 = this.paragraphe.iterator();
	// 	while(iterator.hasNext()){

	// 	}
	// }


    //Je voulais utliser Iterator mais Scanner suffira amplement. 
	private Paragraphe readParagraphe (){
        Paragraphe paragraphe = new Paragraphe();
        String para = sc.next(); 
        System.out.println(para);
        Scanner scLigne = new Scanner(para);
        scLigne.useDelimiter("\n");
        while(scLigne.hasNext()){
            Scanner scInLine = new Scanner(scLigne.next());
            scInLine.useDelimiter(" ");
            Ligne l = new Ligne();
            while (scInLine.hasNext()){
                String  s= scInLine.next();
                if (!s.isBlank()){
                    Mot m = new Mot(s);
                    l.addChaine(m);
                    l.addChaine(new Espace());
                }
            }
            if(!l.isEmpty()) {
                paragraphe.addChaine(l);
            }
        }
        scLigne.close();
            return paragraphe;
    }

    public void print(){
        LinkedList<Paragraphe> a =this.getTexte();
        for (Paragraphe p : a) {
            for (Ligne l : p.getLines()) {
                for (ChainCar c: l.getLine()) {
                    System.out.print(c);
                }
                System.out.println();
            }
            System.out.println();
        }
    }

	public void read(){
        sc.useDelimiter("\n\n+");
        while (sc.hasNext()){
            texte.add(readParagraphe());
        }
        sc.close();
    }


}
