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

    public void afficheInfixe() { // 9
        if (left != null)
            left.afficheInfixe();
        System.out.print(etiquette + " ");
        if (right != null)
            right.afficheInfixe();
    }

    public void affichePrefixe() {
        System.out.print(etiquette + " ");
        if (left != null)
            left.affichePrefixe();
        if (right != null)
            right.affichePrefixe();
    }

    public void afficheSuffixe() {
        if (left != null)
            left.afficheSuffixe();
        if (right != null)
            right.afficheSuffixe();
        System.out.print(etiquette + " ");
    }

    public int nombreNoeud() {
        int a = 0;
        if (right != null)
            a = 1 + right.nombreNoeud();
        if (left != null)
            a += 1 + left.nombreNoeud();
        return a;
    }

    public int somme() {
        int a = 0;
        if (left != null)
            a += left.somme();
        if (right != null)
            a += right.somme();
        return a + etiquette;
    }

    public int profondeur() {
        int a = 1;
        int b = 1;
        if (left != null)
            a += left.profondeur();
        if (right != null)
            b += right.profondeur();
        return Math.max(a, b);

    }

    public int getEtiquette() {
        return this.etiquette;
    }

    public Noeud getLeft() {
        return this.left;
    }

    public Noeud getRight() {
        return this.right;
    }

    public boolean chercher(int e) {
        boolean b = (etiquette == e) ? true : false;
        if (left != null)
            b = b || left.chercher(e);
        if (right != null)
            b = b || right.chercher(e);
        return b;
    }

    public void creer(Noeud n) {
        if (n != null) {
            if (n.left != null) {
                left = new Noeud(n.left.etiquette);
                left.create(n.left);
            }
            if (n.right != null) {
                right = new Noeud(n.right.etiquette);
                right.create(n.right);
            }
        }

    }

    public void creer2 (int [] t) {

        int [] tL = new int [t.length/2] ; 
        int [] tR = new int [t.length - t.length/2 - 1] ; 
        for (int i = 0 ; i<t.length/2 ; i++) {
            tL[i] = t[i] ; 
        } int k = 0 ; 
        for (int i = t.length/2+1 ; i<t.length ; i++) {
            tR[k] = t[i] ; 
            k++ ; 
        }
        if (tL.length != 0 ) {
            left = new Noeud(tL[tL.length/2]) ; 
            left.creer2(tL);
        }
        if (tR.length != 0) {
            right = new Noeud(tR[tR.length/2]) ; 
            right.creer2(tR);
        }

    }

}
