package Collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class List_Practice {
	public static void main(String[] args) {
		List<Integer> l1 = new Vector<Integer>();
		// add(E element): List me last me element add karta hai
		l1.add(10);
		l1.add(20);
		l1.add(30);   
		l1.add(30);   
		System.out.println(l1);
		
		// add(int index, E element): Kisi specific index pe element insert karta hai
		l1.add(1,40); 	
		System.out.println(l1);
		
		// get(int index) : List ke kisi index ka element return karta hai
		System.out.println(l1.get(2));  
		System.out.println(l1.getFirst());
		System.out.println(l1.getLast());
		
		// set(int index, E element) : List ke kisi index ka element replace karta ha
		l1.set(3, 50);
		System.out.println(l1);
		
		// remove(int index) : Kisi specific index ya element ko remove karta hai
		l1.remove(3);
		System.out.println(l1);
		
	}
}
