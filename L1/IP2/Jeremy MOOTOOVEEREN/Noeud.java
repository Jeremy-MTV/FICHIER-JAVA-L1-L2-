import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Noeud {
    private int etiquette;
    private Noeud left;
    private Noeud right;

    public Noeud(int ettiquette, Noeud left, Noeud right) {
        this.etiquette = ettiquette;
        this.left = left;
        this.right = right;
    }

    public Noeud(int etiquette) {
        this(etiquette, null, null);
    }

    public static Noeud test() {
        Noeud [] n = new Noeud[10] ; 
        n[4] = new Noeud(4) ; 
        n[1] = new Noeud(1, n[4], null) ; 
        n[7] = new Noeud(7, new Noeud(0), n[1]) ; 
        n[8] = new Noeud(8) ; 
        n[6] = new Noeud(6 , null , n[8]) ; 
        n[9] = new Noeud(9, new Noeud(2), n[6]) ;
        n[5] = new Noeud(5, n[9], null) ; 
        return new Noeud(3, n[5], n[7]) ; 
    }

    public void espace (int n) {
        System.out.print(" ".repeat(n));
    }

    public void affiche (int p) {
        if (right != null) {
            right.affiche(p+1);
        }
        espace(p);
        System.out.println(etiquette);
        if (left != null) {
            left.affiche(p+1);
        }
    }

    public void affichelarge () {
        LinkedList <Pair> p = new LinkedList<Pair>() ; 
        Pair tmp ; int a = this.deepth() ; boolean b = false ;   
        p.offer(new Pair(this, a)) ; System.out.print(" ");
        while (!p.isEmpty()) {
            tmp = p.poll() ; 
            if (a != tmp.getdeepth()) {
                a = tmp.getdeepth() ; 
                b = false ; 
                System.out.println();
            } 
            if (!b){
                System.out.print(" ".repeat(tmp.getNoeud().deepth()));
                b = true ; 
            }
            if (tmp.getNoeud().etiquette != -1) {
                System.out.print(" ".repeat(tmp.getdeepth()-1)+ tmp.getNoeud().etiquette + " ".repeat(tmp.getdeepth()) );         
            }else{
                System.out.print("  ".repeat(tmp.getNoeud().deepth())); 
            }  

            if (tmp.getNoeud().left != null) {
                p.offer(new Pair(tmp.getNoeud().left, a-1)) ; 
            }else{
                if (a != 1 )p.offer(new Pair(new Noeud(-1), a-1)) ; 
            }
            if (tmp.getNoeud().right != null) {
                p.offer(new Pair(tmp.getNoeud().right, a-1)) ; 
            }else{
                if(a != 1)p.offer(new Pair(new Noeud(-1), a-1)) ; 
            }
        }
        System.out.println();
    }

    public int deepth () {
       int d = 1 ; int g = 1 ; 
       if (right != null) d += right.deepth() ; 
       if (left != null) g += left.deepth() ; 
       return Math.max(d, g) ; 
    }

    public void newLeader() {
        LinkedList <Noeud> p = new LinkedList<Noeud>() ; 
        p.offer(this) ; Noeud tmp ;
        while (!p.isEmpty()) {
            tmp = p.poll() ; 
            if (tmp.right == null && tmp.left != null) {
                this.etiquette = tmp.left.etiquette ; 
                tmp.left = tmp.left.left ; 
                return ; 
            }
            if (right != null) p.offer(tmp.right) ;  
        }

    }
}    