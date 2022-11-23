public class PileTab {
    public Cellule [] tableau1 ; 
    public int premier ; 
    public int last ; 
    

    PileTab(int length) {
        tableau1 = new Cellule[length] ; 
        premier = 0 ; 
        last = 0 ; 
    }

    public boolean empty() {
        return premier == last && tableau1[premier]==null ; 
    }

    public Cellule get () {
        if (empty()) return null ; 
        Cellule tmp = tableau1[premier] ;
        tableau1[premier] = null ; 
        premier = (premier == last)?last:(premier+1)%tableau1.length ; 
        return tmp ; 
    }

    public void put (Cellule x) {
        if (empty()) {
            tableau1[last] = x ; 
            return ; 
        }
        if ((last+1)%tableau1.length == premier) {
            System.out.println("File pleine , impossible d'empiler !");
            return ; 
        }
        last = (last+1)%tableau1.length ; 
        tableau1[last] = x ; 
    }

    public static void main(String[] args) {
        Cellule c1 = new Cellule(0) ; 
        Cellule c2 = new Cellule(1) ; 
        Cellule c3 = new Cellule(2) ; 
        PileTab p = new PileTab(3) ; 
        p.put(c1);
        p.put(c2);
        p.put(c3);
        p.put(c1);  //Cela doit afficher une erreur car la taille de la pile sera dépassé
        System.out.println("premier = " + p.premier + " last = " + p.last);
        p.get() ; 
        System.out.println("premier = " + p.premier + " last = " + p.last);
        p.get() ;
        System.out.println("premier = " + p.premier + " last = " + p.last);
        System.out.println(p.get()) ; 
       
        
        
    }
}
