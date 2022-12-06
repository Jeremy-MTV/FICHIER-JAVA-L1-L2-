package L2.POO.TP11_POO;

import java.util.Iterator;

public class Test {
    public static void main(String[] args){
        Integer[] intint = {4, null};
		TestIter<Integer> t1 = new TestIter<Integer>(intint);
		while(t1.hasNext()) {
			System.out.println(t1.next());
		}
    }
}
