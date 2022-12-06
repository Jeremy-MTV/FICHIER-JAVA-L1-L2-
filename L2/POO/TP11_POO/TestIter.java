package L2.POO.TP11_POO;

import java.util.Iterator;

public class TestIter<E> implements Iterator<E>{
    private E[] tableau;
    private int index = 0;

    public TestIter(E[] tableau){
		this.tableau = tableau;
	}

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public boolean hasNext() {
        return index < tableau.length && tableau[index] != null;
    }

    @Override
    public E next() throws IllegalStateException {
        try{
            E element = tableau[index];
            setIndex(index++);
            return element;
        }catch(Exception e){
            throw new IllegalStateException("Erreur");
        }
    }

}
