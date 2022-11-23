public class TitreCommencePar {

	 private char lettre ;

    TitreCommencePar (char l) {
        this.lettre = l ; 
    } 

    @Override
    public boolean estVrai (Media doc) {
        return Character.toUpperCase(doc.getTitle().charAt(0)) == Character.toUpperCase(lettre) ; 
    }
}