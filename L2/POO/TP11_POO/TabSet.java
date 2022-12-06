package L2.POO.TP11_POO;
import java.util.Iterator;

public class TabSet<E>{
    private E[] element;

    public E[] getElement() {
        return element;
    }

    public void setElement(E[] element) {
        this.element = element;
    }

    public class TabIter implements Iterator<E>{

        public TabIter(int n){
           tableau = (E[]) new Object[n];
        }
        
        public Iterator<E> iterator(){
            return new TabIter();
        }


    }

}
