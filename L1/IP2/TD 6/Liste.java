public class Liste{
    private Element premier;
    private Element dernier;

    Liste(Element e, Element f){
        this.premier = e;
        this.dernier = f;
    }

    Element getPremier(){
        return this.premier;
    }

    Element getDernier(){
        return this.dernier;
    }

    void setPremier(Element e){
        this.premier = e;
    }

    void setDernier(Element e){
        this.dernier = e;
    }



    int longueur(){
        if(this.premier != null && this.dernier != null){
            return 2 + this.longueur();
        }
        return this.longueur();
    }

    void afficherInverse(){
        afficherInverse(dernier);
    }

    void afficher(){
        afficher(premier);
    }

    void ajouterDebut(int valeur){
        Element a = new Element(valeur, null, null);
        if(premier != null){
            a.setSuivant(getPremier());
            getPremier().setPrecedent(a);
        }
        premier = a;

        if(dernier == null) dernier = a; 
    }
}