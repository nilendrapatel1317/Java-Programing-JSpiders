package ListIterator;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Test1 {
	public static void main(String[] args) {
		List l = new ArrayList();
		l.add(10);
		l.add(20);
		l.add(30);
		l.add(40);
		l.add(50);
		
		System.out.println(l);
		System.out.println();
		
		ListIterator listItr = l.listIterator();
		
		while(listItr.hasNext()) {
			System.out.print(listItr.next() + " ");
			listItr.set(70);
			System.out.println(listItr.nextIndex());
		}
		System.out.println();
		System.out.println();
		System.out.println(l);
		System.out.println();
		
		while(listItr.hasPrevious()) {
			System.out.print(listItr.previous() + " ");
			System.out.println(listItr.previousIndex());
		}
	}
}
