public class Liste{
    private Element premier;
    private Element dernier;

    public Liste(Element e, Element a) {
    }

   int longueur(){
       return longueur(premier);
   }

    void afficherInverse(){
        afficherInverse(dernier);
    }
}