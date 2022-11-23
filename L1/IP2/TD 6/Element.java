public class Element{
    private int valeur;
    private Element suivant;
    private Element precedent;


    int getVal(){
        return this.valeur;
    }

    Element getPrecedent(){
        return this.precedent;
    }

    Element getSuivant(){
        return this.suivant;
    }

    void setPrecedent(Element e){
        this.precedent = e;
    }

    void setSuivant(Element e){
        this.suivant = e;
    }


    Element(int valeur, Element suivant, Element precedent){
        this.valeur = valeur;
        this.suivant = suivant;
        this.precedent = precedent;
    }

    int longueur(){
            if(this.suivant != null){
                return 1 + this.getSuivant().longueur();
            }else{
                return this.getSuivant().longueur();
            }
    }

    void afficherInverse(Element e){
        if(e == null) return;
        else{
            System.out.print(e.getVal());
            afficherInverse(e.getPrecedent());
        }
    }

    void afficher(Element e){
        if(e == null) return;
        else{
            System.out.println(e.getVal());
            afficher(e.getSuivant());
        }
    }

    void ajouterDebut(int valeur){
        Element a = new Element(valeur, null, null);
        if()
    }
}