package Iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class Test1 {

	public static void main(String[] args) {
		Collection  c = new HashSet();
		c.add("Java");
		c.add("JavaScript");
		c.add("HTML");
		c.add("CSS");
		c.add("SQL");
		c.add("DS");
		c.add(20);
		c.add(30);
		c.add(40);
		c.add(50);
		
		System.out.println(c);
		System.out.println();
		
		Iterator i= c.iterator();
		
		while(i.hasNext()) {
			System.out.println(i.next());			
		}
	}

}
