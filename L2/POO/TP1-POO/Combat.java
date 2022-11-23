public class Combat {

    public static void main(String[] args) {
        Personnage p1 = new Personnage("Samm", new Information(100, 50, 40)) ; 
        Personnage p2 = new Personnage("Mellioo", new Information(100, 75, 20)) ; 
        p1.lutteIter(p2);
        p1.lutteRec(p2);
    }
    
}