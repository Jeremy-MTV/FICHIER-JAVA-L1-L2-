import java.util.Iterator;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Set;
import java.util.ArrayList;


public class TabSet<E> implements Iterable<E>, Set<E>{

    private E[] element;

    public E[] getElement() {
        return element;
    }

    public void setElement(E[] element) {
        this.element = element;
    }

    @SuppressWarnings("unchecked")
	public TabSet() {
		this.element = (E[])new Object[10];
	}

    public boolean contains(Object o) {
		for(E e : element) {
			if(e == o) {
				return true;
			}
		}
		return false;
	}


    public int size () {
        int acc = 0 ; 
        Iterator<E> it = iterator() ; 
        while(it.hasNext()) {
                it.next() ; 
                acc++ ; 
            }
        return acc ; 
    }

    public boolean isEmpty() {
        return size() == 0 ; 
    }

    @SuppressWarnings("unchecked")
	public boolean add(E e) {
		// if(this.size() == element.length) {
		// 	int i = 0;
		// 	Object[] res = new Object[this.size()*2];
		// 	for(E e1 : element) {
		// 		res[i] = e1;
		// 		i++;
		// 	}
		// 	res[i] = e;
		// 	this.element = (E[]) res;
		// 	return true;
		// }
		// for(E e1: element) {
		// 	if (e1 == e) {
		// 		return false;
		// 	}
		// }
		// TabIter it = new TabIter();
		// it.add(e);
		// return true;

        if (e == null) {
            System.out.println("Element null a ajouter");
            return false ; 
        }        
        if (contains(e)) {
            System.out.println("Element deja dans l'ensemble");
            return false ; 
        }
        if (size() >= element.length) {
           E[] tmp = (E[]) new  Object[element.length*2] ; 
           for (int i = 0 ; i<element.length ; i++) {
            tmp[i] = element[i] ; 
           }
           element = tmp ; 
        }

        element[firstPlacefree()] = e ; 
        return true ; 
	}



    private int firstPlacefree () {
        int acc = 0 ;
        for(E x : element) {
            if (x != null) acc++ ; 
        }
        return acc ; 
    }

    public boolean remove(Object o) {
		if(this.contains(o)) {
			TabIter it = new TabIter();
			while(it.hasNext() && it.next() != o) {
				it.next();
			}
			it.remove();
			return true;
		}
		return false;
	}
	
	public void clear() {
		TabIter it = new TabIter();
		while(it.hasNext()) {
			it.next();
			it.remove();
		}
	}
	
	public boolean containsAll(Collection<?> c) {
		for(Object o : c) {
			if(!this.contains(o)) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public boolean addAll(Collection<? extends E> c) {
		if(this.containsAll(c)) {
			return false;
		}
		for(E e : c) {
			this.add(e);
		}
		return true;
	}
	
	@Override
	public boolean removeAll(Collection<?> c) {
		TabIter it = new TabIter();
		while(it.hasNext()) {
			if(c.contains(it.next())) {
				it.remove();
			}
		}
		return true;
	}
	
	@Override
	public Iterator<E> iterator() {
		return new TabIter();
	}

    @Override
	public Object[] toArray() {
		int i = 0;
		Object[] res = new Object[this.size()];
		for(E e : element) {
			if(e != null) {
				res[i] = e;
				i++;
			}
		}
		return res;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T[] toArray(T[] a) {
		if(a.length >= this.size()) {
			int i = 0;
			for(E e : element) {
				if(e != null) {
					a[i] = (T) e;
					i++;
				}
			}
			while(i < a.length) {
				a[i] = null;
				i++;
			}
		} else {
			Class<?> c = a.getClass().getComponentType();
			int i = 0;
			T[] t = (T[]) Array.newInstance(c, this.size());
			for(E e : element) {
				if(e != null) {
					t[i] = (T) e;
					i++;
				}
			}
			return t;
		}
		return a;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		TabIter it = new TabIter();
		while(it.hasNext()) {
			if(!c.contains(it.next())) {
				it.remove();
			}
		}
		return true;
	}
	




    public class TabIter implements Iterator<E>{

        // public TabIter(int n){
        //    Object element = (E[]) new Object[n];
        // }
        
        private int index = -1; 

        @Override
        public boolean hasNext() {
            int pos = index+1 ; 
            while (pos < element.length && element[pos] == null) {
                pos++ ; 
            }
            if (pos >= element.length) return false ; 
            return true ; 
        }

        @Override
        public E next() throws IllegalStateException{
            if (!hasNext()) throw new IllegalStateException(); 
            index++ ; 
            while(index < element.length && element[index] == null) {
                index++ ; 
            }
            if (index >= element.length) throw new IllegalStateException() ;
            return element[index] ;  
        }

        @Override
        public void remove() throws IllegalStateException{
            if (index == -1) throw new IllegalStateException() ; 
            element[index] = null ; 
        }


    }

}
