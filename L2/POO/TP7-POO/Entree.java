public class Entree {
    private Element element; 
    private String nom;
    private Dossier parent;

    public Entree(Element element, String nom, Dossier parent){
        this.element = element; 
        this.nom = nom;
        this.parent = parent;
        remplacer(element);
    }

    public Entree(Dossier d1, String nom2, Object parent2) {
    }

    @Override
    public String toString() {
        // return "Entree [element=" + element + ", nom=" + nom + ", parent=" + parent + "]";
        return nom + " (" + element.getType() + ") ";
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Dossier getParent() {
        return parent;
    }

    public void setParent(Dossier parent) {
        this.parent = parent;
    }

    public void supprimer(){
        parent.supprimer(this);
    }

    public void remplacer(Element e){
        if (e instanceof FichierTexte){
            this.element = e;
            return ;
        }
        Dossier tmp = (Dossier) e ; 
        for (Entree x : tmp.getFilles()) { // on remove le pointeur "./" original
            if (x.getElement() == e) {
                tmp.supprimer(x) ;
                break ;  
            }
        }

        Entree tmpp = new EntreeSpeciale(element, nom, parent) ; 
        tmp.addEntree(tmpp); // on ajoute le pointeur "./" nouveau

        if (parent != null) {// on met a jour le pointeur parent
            for (Entree x : parent.getFilles()) { 
                if ((Dossier)x.getElement() == parent) {
                    tmpp = new EntreeSpeciale(x.element, x.nom, x.parent) ; 
                    tmp.setParent(tmpp);
                    break ; 
                }
            }
        }else tmp.setParent(null); 
        element = e ; 
    }
    
}
