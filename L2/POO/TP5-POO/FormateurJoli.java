public class FormateurJoli {
    private int longueurMax;

    // public FormateurJoli(String filename, int l) {
	// 	sc = null;
	// 	try {
	// 		sc = new Scanner(new File(filename));
    //         if(l != 0 && l > 0) this.longueurMax  = l;
	// 	} catch (Exception e) {
	// 		System.out.println("Erreur lors d’ouverture fichier:");
	// 		e.printStackTrace();
	// 		System.exit(1);
	// 	}
	// 	texte = new LinkedList<Paragraphe>();
	// }

	FormateurJoli (String filename, longueurMax) {
        super(filename) ; //il suffit d'utiliser super pour arriver à ce résultat.
        this.maxWidth = maxWidth ; 
    }

    
    public Paragraphe readParagraphe () {
        Paragraphe p = new ParagrapheJoli(this.maxWidth) ;
        Scanner line = new Scanner(super.getScanner().next()) ;
        line.useDelimiter("\n") ; 
        String test ; 
        Scanner words;
        while (line.hasNext()) { // parcours lignes
            words = new Scanner(line.next()) ; 
            while (words.hasNext()) { // parcours mot
                test = words.next() ; 
                if (!test.isBlank()) p.addChaine(new Mot(test));
                p.addChaine(new Espace(1));
            }
            p.addLigne(new Ligne());   
        }
        p.removeLast();
        return p ; 
    }
}
