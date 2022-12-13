
import java.util.Iterator;

public class TestIter<E> implements Iterator<E>{
    private E[] tableau;
    private int index = 0;

    public int getIndex() {
        return index;
    }

    public TestIter(E[] tab){
		this.tableau = tab;
	}

    public TestIter(){
        this.tableau = null;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public boolean hasNext() {
        return index < tableau.length && tableau[index] != null;    }

    @Override
    public E next() throws IllegalStateException {
        if(hasNext()){
           E element = tableau[index];
           index++;
           return element;
        }else{
            throw new IllegalStateException();
        }
    }

}
