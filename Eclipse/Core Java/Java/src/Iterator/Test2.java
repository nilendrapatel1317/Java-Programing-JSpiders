//Remove even Element from collection by using Iterator Interface
package Iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Test2 {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add(1);
		c.add(2);
		c.add(3);
		c.add(4);
		c.add(5);
		c.add(6);
		c.add(7);
		c.add(8);
		c.add(9);
		c.add(10);
		
		System.out.println(c);
		System.out.println();
		
		Iterator i = c.iterator();
		
		while (i.hasNext()) {
			int n = (Integer) i.next();
			if(n%2==0) i.remove();
			
		}
		
		System.out.println(c);
		
	}
}
