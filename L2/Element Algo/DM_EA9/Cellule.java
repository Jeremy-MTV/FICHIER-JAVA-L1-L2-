public class Cellule{
    public int key ; 
    public Cellule next ; 

    Cellule (int key) {
        this.key = key ; 
    }

    Cellule (int key , Cellule next) {
        this(key) ; 
        this.next = next ; 
    }
}