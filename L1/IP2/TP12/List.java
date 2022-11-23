public class List {
    private Cellule first;

    List(Cellule f){
        this.first = f;
    }

    List(){
        this(null);
    }

    public void add(E x){
        if(this.isEmpty()) first = new Cellule(x);
        else first.add(x);
    }

    public int size(){
        if(first == null) return 0;
        return first.size();
    }

    public void concat(List b){
        if(this.isEmpty()) first = b.first;
        else first.concat(b.first);
    }

}