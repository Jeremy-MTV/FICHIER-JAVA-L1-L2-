public class Cellule{
    private E contenu;
    private Cellule suivante;

    Cellule(E a){
        this.contenu = a;
    }

    Cellule(){
        this(null);
    }

    public void setSuivante(Cellule a){
        this.suivante = a;
    }

    public int size(){
        if(suivante==null) return 1;
        return 1 + suivante.size();
    }

    public void add(E x){
        Cellule tmp = this;
        while(tmp.next != null) tmp = tmp.next;
        tmp.next = new Cellule(E z);
    }

    public void concat(Cellule x){
        Cellule tmp = this;
        while(tmp.next != null) tmp = tmp.next;
        tmp.next = x;
    }

}