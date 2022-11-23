public class Main {
    public static void main ( String [] args ){
    Noeud a = new Noeud (6 , null , new Noeud (8));
    Noeud b = new Noeud (9 , new Noeud (2) , a );
    Noeud c = new Noeud (5 , b , null );
    Noeud d = new Noeud (1 , new Noeud (4) , null );
    Noeud e = new Noeud (7 , new Noeud (0) , d );
    Noeud f = new Noeud (3 , c , e );
    Arbre g = new Arbre ( f );
    System.out.print(g.recherche(5));  
    }
}