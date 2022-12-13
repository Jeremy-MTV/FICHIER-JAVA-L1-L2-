
import java.util.Iterator;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args){
        Integer[] intint = {4, 3, 2};
		TestIter<Integer> t1 = new TestIter<Integer>(intint);
		while(t1.hasNext()) {
			System.out.println(t1.next());
		}

		TabSet<Integer> tab = new TabSet<>() ;
        tab.add(5) ; 
        ArrayList<Integer> a = new ArrayList<>() ; 
        a.add(1) ; a.add(2) ; a.add(3) ; 
        tab.addAll(a) ;
		for (Object x : tab.toArray()) {
			System.out.print(x+" ");
		}



		// TabSet<Integer> t3 = new TabSet<Integer>();
		// TabSet<Integer> t4 = new TabSet<Integer>();
		// Iterator<Integer> n2 = t3.iterator();
		// t3.add(8);
		// t3.add(4);
		// t3.add(5);
		// t3.add(1);
		// t4.add(2);
		// t4.add(6);
		// t4.add(9);
		// t4.add(7);
		// t4.add(10);
		// t4.add(3);
		// System.out.println(t3.containsAll(t4));
		// t3.addAll(t4);
		// t3.add(11);
		// //t3.removeAll(t4);
		// //t3.retainAll(t4);
		// while(n2.hasNext()) {
		// 	System.out.println(n2.next());
		// }
		// System.out.println("-------");
		// Object[] tab = t3.toArray();
		// for(Object o : tab) {
		// 	System.out.println(o);
		// }
    }
}
