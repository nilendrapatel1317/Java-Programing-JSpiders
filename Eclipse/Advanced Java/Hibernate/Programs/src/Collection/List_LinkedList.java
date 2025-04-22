package Collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class List_LinkedList {
	public static void main(String[] args) {
		List<String> list = new LinkedList<String>();
		// add(E element): List me last me element add karta hai
		list.add("Apple");
        list.add("Banana");
        list.add("Orange");
		System.out.println("\n=> add() Method");
		System.out.println(list);
		
		// add(int index, E element): Kisi specific index pe element insert karta hai
		list.add(1, "Mango");  
		System.out.println(list);
		
		// get(int index) : List ke kisi index ka element return karta hai
		System.out.println("\n=> get() Method");
		System.out.println(list.get(2));  
		System.out.println(list.getFirst());
		System.out.println(list.getLast());
		
		// set(int index, E element) : List ke kisi index ka element replace karta ha
		System.out.println("\n=> set() Method");
		list.set(1, "Grapes"); 
		System.out.println(list);
		
		// remove(int index) : Kisi specific index ya element ko remove karta hai
		list.remove(1); // Index 1 ka element remove hoga
		list.remove("Banana"); // "Banana" remove hoga
		System.out.println("\n=> remove() Method");
		System.out.println(list);
		
		//contains(Object obj) : List me koi element hai ya nahi, yeh check karta hai (true/false return hota hai)
		System.out.println("\n=> contains() Method");
		System.out.println(list.contains("Apple")); // Output: true
		System.out.println(list.contains("Mango")); // Output: false
		
		//indexOf(Object obj) : List me kisi element ka index return karta hai
		System.out.println("\n=> indexOf() Method");
		System.out.println(list.indexOf("Apple")); // Output: 0
		System.out.println(list.indexOf("Mango")); // Output: -1 
		
		//isEmpty() : List empty hai ya nahi check karta hai (true/false)
		System.out.println("\n=> isEmpty() Method");
		System.out.println(list.isEmpty()); // Output: false

		//size() : List ke total elements ka count return karta hai
		System.out.println("\n=> size() Method");
		System.out.println(list.size()); // Output: size of element

		
		//clear() : List ke sare elements hata deta hai
		list.clear();
		System.out.println("\n=> clear() Method");
		System.out.println(list.isEmpty()); // Output: true
		System.out.println(list);
		
		
		//addFirst(E e) & addLast(E e) : Shuru aur end me fast insertion ke liye hoti hai
		System.out.println("\n=> clear() Method");
		list.addFirst("Nilu");
        list.addLast("Jojo");
        
        System.out.println(list);

	}
}
