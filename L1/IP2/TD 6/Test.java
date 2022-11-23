public class Test{
   

    public static void main(String[] args){
        Element e, c, b, a;
      e = new Element(2, null, null); //premier
      c = new Element(3, null, e);
      e.setSuivant(c);
     b = new Element(4, null, c);
     c.setSuivant(b);
     a = new Element(5, null, b); //dernier
     b.setSuivant(a);

        Liste r = new Liste(e, a);

        System.out.print(r.longueur());
    }

}