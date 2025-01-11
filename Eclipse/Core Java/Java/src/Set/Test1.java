package Set;

import java.util.SortedSet;
import java.util.TreeSet;

public class Test1 {
	public static void main(String[] args) {
		SortedSet s = new TreeSet();
		s.add(50);
		s.add(20);
		s.add(40);
		s.add(30);
		s.add(10);
		s.add(60);
		
		display(s);
		System.out.println();
		System.out.println("First = "+ s.first());
		System.out.println();
		System.out.println("Last = "+ s.last());
		System.out.println();
		display(s.headSet(40)); // elem < 40
		System.out.println();
		display(s.tailSet(40)); // elem >= 40
		System.out.println();
		display(s.subSet(20, 50)); // 20 <= elem < 50
		
		
	}
	public static void display(SortedSet s) {
		for (Object o : s) {
			System.out.print(o+" ");
		}
		System.out.println();
	}
}
