package Collection_sort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List l = new ArrayList();
		l.add(40);
		l.add(10);
		l.add(30);
		l.add(20);
		l.add(50);
		
		System.out.println(l);
		Collections.sort(l);
		System.out.println();
		System.out.println("Asc Order " +l);
		System.out.println();
		
		Collections.sort(l, new DescComp());
		System.out.println("Desc Order " +l);
		
		
	}
	
}
 class DescComp implements Comparator{
	 public int compare(Object arg1 , Object arg2) {
		return (Integer)arg2 - (Integer)arg1;
	}
 }